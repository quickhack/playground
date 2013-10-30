package com.oldratlee.ch;

/**
 * @author ding.lid
 */
public interface HashFunction<K> {
    int hash(K s);
    
    int hash(K s, int order);
}
