package com.oldratlee.ch

import com.google.common.hash.Hashing
import org.junit.Test

import javax.naming.OperationNotSupportedException

/**
 * @author ding.lid
 */
class ConsistentHashTest {
    static class Machine {
        String ip
    }

    static class KeyHashFunction implements HashFunction<String> {
        @Override
        int hash(String s) {
            return Hashing.md5().hashString(s).asInt()
        }

        @Override
        int hash(String s, int order) {
            throw new OperationNotSupportedException()
        }
    }

    static class NodeHashFunction implements HashFunction<Machine> {
        @Override
        int hash(Machine s) {
            return Hashing.md5().hashString(s.ip).asInt()
        }

        @Override
        int hash(Machine s, int order) {
            return Hashing.md5().hashString(s.ip + order).asInt()
        }
    }

    static Random random = new Random()

    @Test
    public void test_test1() throws Exception {
        ConsistentHash<Machine, String> consistentHash = new ConsistentHash(numberOfReplicas: 100, keyHashFunction: new KeyHashFunction(), nodeHashFunction: new NodeHashFunction())
        
        def machines = []
        1..10.each { int i -> machines << new Machine(ip: "1.1.1.$i") }
        consistentHash.addNode(machines)

        Machine node = consistentHash.get("12345")
        
        for(m in machines) {
            if (m.ip != node.ip) {
                consistentHash.removeNode(m)
                break
            }
        }
        
        assert consistentHash.get("12345").ip == node.ip
    }
}
