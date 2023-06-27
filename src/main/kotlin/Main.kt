import algorithm.DistanceCalculator

fun main(args: Array<String>) {
    val presentLat = 37.579369
    val presentLon = 127.015299
    val destinationLat = 37.5828483
    val destinationLon = 127.0105811
    val distanceCalculator = DistanceCalculator.create(presentLat, presentLon, destinationLat, destinationLon)
    val straightDistance = distanceCalculator.calculateDistance()
    println("Distance : $straightDistance")
}