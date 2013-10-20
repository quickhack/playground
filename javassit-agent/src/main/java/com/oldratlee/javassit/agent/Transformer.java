package com.oldratlee.javassit.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author ding.lid
 */
public class Transformer implements ClassFileTransformer {
    private static final Logger logger = Logger.getLogger(Transformer.class.getName());
    private static final Random random = new Random();

    private static final String BASE_FILE_NAME = "com/oldratlee/javassit/Base";
    private static final String SON_FILE_NAME = "com/oldratlee/javassit/Son";

    private static String toClassName(String classFile) {
        return classFile.replace('/', '.');
    }

    @Override
    public byte[] transform(ClassLoader loader, String classFile, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classFileBuffer) throws IllegalClassFormatException {
        if (BASE_FILE_NAME.equals(classFile) || SON_FILE_NAME.equals(classFile)) {
            final String className = toClassName(classFile);
            try {
                logger.warning("Transforming class " + className);
                CtClass clazz = ClassPool.getDefault().makeClass(new ByteArrayInputStream(classFileBuffer), false);
                clazz.defrost();

                for (CtMethod method : clazz.getMethods()) {
                    if (!("hello".equals(method.getName()) || "world".equals(method.getName()))) continue;

                    String code = String.format("System.out.println(\"Insert before %s.%s [%d]\");", className, method.getName(), random.nextLong());
                    logger.info("insert code to method " + method.getName() + " of class " + className + ": " + code);
                    method.insertBefore(code);
                }
                return clazz.toBytecode();
            } catch (Throwable t) {
                StringWriter stringWriter = new StringWriter();
                t.printStackTrace(new PrintWriter(stringWriter));
                String msg = "Fail to transform class " + className + ", cause: " + stringWriter.toString();
                logger.severe(msg);
                throw new IllegalStateException(msg);
            }
        }
        return null;
    }
}
