package com.oldratlee.groovy


tick = System.currentTimeMillis();
(10 ** 5).times {
    "oldratlee@gmail.com" =~ /^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}/
}
println(System.currentTimeMillis() - tick)

tick = System.currentTimeMillis()
p = ~/^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}/
(10 ** 5).times {
    "oldratlee@gmail.com" =~ p
}
println(System.currentTimeMillis() - tick)
