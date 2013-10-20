package com.oldratlee.javassit.agent;


import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.util.logging.Logger;


/**
 * @author ding.lid
 */
public class Agent {
    private static final Logger logger = Logger.getLogger(Agent.class.getName());

    public static void premain(String agentArgs, Instrumentation inst) {
        logger.warning("[premain] begin, agentArgs: " + agentArgs);
        install(agentArgs, inst);
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        logger.warning("[agentmain] begin, agentArgs: " + agentArgs);
        install(agentArgs, inst);
    }

    static void install(String agentArgs, Instrumentation inst) {
        logger.warning("[install] agentArgs: " + agentArgs + ", Instrumentation: " + inst);

        ClassFileTransformer transformer = new Transformer();
        inst.addTransformer(transformer, true);

        logger.warning("[install] addTransformer success.");
    }
}
