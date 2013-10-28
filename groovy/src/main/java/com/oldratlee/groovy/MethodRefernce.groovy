package com.oldratlee.groovy

mr = [1, 2].&toString
println "parameterTypes: $mr.parameterTypes"
println "maximumNumberOfParameters: $mr.maximumNumberOfParameters"
println "result: $mr"

mr = [1, 2].&contains
println "parameterTypes: $mr.parameterTypes"
println "maximumNumberOfParameters: $mr.maximumNumberOfParameters"
println "result: ${mr(1)}"
