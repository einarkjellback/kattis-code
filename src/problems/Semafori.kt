package problems

fun main() {
    val (numberOfTrafficLights, totLength) = readLine()!!.split(" ").map { it.toInt() }
    data class TrafficLight(val distFromStart: Int, val redDuration: Int, val greenDuration: Int)
    val trafficLights = (1..numberOfTrafficLights).map {
        val trafficLight = readLine()!!.split(" ").map { it.toInt() }
        TrafficLight(trafficLight[0], trafficLight[1], trafficLight[2])
    }
    val calcWaitTime = { light: TrafficLight, t: Int ->
        val placementInRedGreenCycle = t % (light.redDuration + light.greenDuration)
        if (placementInRedGreenCycle >= light.redDuration) 0
        else light.redDuration - placementInRedGreenCycle
    }
    val firstLight = trafficLights.first()
    var accTime = firstLight.distFromStart
    accTime += calcWaitTime(firstLight, accTime)
    for ((prevLight, nextLight) in trafficLights.zipWithNext()) {
        accTime += nextLight.distFromStart - prevLight.distFromStart
        accTime += calcWaitTime(nextLight, accTime)
    }
    println(accTime + totLength - trafficLights.last().distFromStart)
}