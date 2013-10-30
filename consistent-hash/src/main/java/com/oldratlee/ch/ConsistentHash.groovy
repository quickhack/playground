package com.oldratlee.ch

import groovy.transform.CompileStatic

/**
 * @see <a href="https://weblogs.java.net/blog/tomwhite/archive/2007/11/consistent_hash.html">Consistent Hashing</a>
 */
@CompileStatic
class ConsistentHash<N, K> {
    HashFunction<N> nodeHashFunction
    HashFunction<K> keyHashFunction
    int numberOfReplicas

    private final SortedMap<Integer, N> circle = new TreeMap<>()

    void addNode(N node) {
        numberOfReplicas.times { int i ->
            circle.put(nodeHashFunction.hash(node, i), node)
        }
    }

    void addNode(Collection<N> nodes) {
        nodes.each { N n -> addNode(n) }
    }

    void removeNode(N node) {
        numberOfReplicas.times { int i ->
            circle.remove(nodeHashFunction.hash(node, i))
        }
    }

    N get(K key) {
        if (!circle) {
            return null
        }

        final int hash = keyHashFunction.hash(key)
        N node = circle.get(hash)
        if (node) return node

        SortedMap<Integer, N> tailMap = circle.tailMap(hash)
        hash = tailMap ? circle.firstKey() : tailMap.firstKey()
        return circle.get(hash)
    }

    private void setNumberOfReplicas(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas
    }
}
