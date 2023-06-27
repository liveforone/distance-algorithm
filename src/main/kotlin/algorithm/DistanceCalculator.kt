package algorithm

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class DistanceCalculator private constructor(
    private val presentLat: Double,
    private val presentLon: Double,
    private val destinationLat: Double,
    private val destinationLon: Double
){
    companion object {
        fun create(presentLat: Double, presentLon: Double, destinationLat: Double, destinationLon: Double): DistanceCalculator {
            return DistanceCalculator(presentLat, presentLon, destinationLat, destinationLon)
        }
    }

    private val earthRadius: Double = 6371.0

    fun calculateDistance(): Double {
        //1.위도와 경도를 라디안 단위로 변환
        val radPreLat = Math.toRadians(presentLat)
        val radPreLon = Math.toRadians(presentLon)
        val radDesLat = Math.toRadians(destinationLat)
        val radDesLon = Math.toRadians(destinationLon)

        //2. 위도와 경도의 차이 계산
        val diffLat = radDesLat - radPreLat
        val diffLon = radDesLon - radPreLon

        //3. 대원거리 공식 적용
        val calculatedResult = (sin(diffLat / 2) * sin(diffLat / 2)
                + (cos(radPreLat) * cos(radDesLat)
                * sin(diffLon / 2) * sin(diffLon / 2)))
        val sqrtResult = 2 * atan2(sqrt(calculatedResult), sqrt(1 - calculatedResult))

        //4. 두 지점 사이의 거리 계산 (단위: km)
        return earthRadius * sqrtResult
    }
}