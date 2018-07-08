abstract class Direction(val ordinal: Int) {
    @Suppress("LeakingThis") //this is fine, the results of values should be fixed
    val degrees = ((360 / values().size.toFloat()) * ordinal)

    fun opposite() = this.rotateBy(180f)
    fun rotateBy(degrees: Float): Direction {
        val turns = degrees / (360f / values().size)
        var slot = (this.ordinal + turns).toInt() % values().size
        if (slot < 0) {
            slot += values().size
        }
        return values()[slot]
    }

    abstract fun values(): Array<Direction>

    fun degreesTo(direction: Direction) = direction.degrees - this.degrees

    companion object {
        fun nearestTo(degrees: Float, values: Array<Direction>): Direction {
            var degree = degrees
            while (degree < 0) {
                degree += 360
            }
            val idx = if (degree > (360 - ((360 / (values.size * 2)) + 1))) {
                0
            } else {
                ((degree / (360 / values.size)) % values.size).toInt()
            }
            return values[idx]
        }
    }
}

sealed class FourWayDirection(ordinal: Int) : Direction(ordinal) {
    class North : FourWayDirection(0)
    class East : FourWayDirection(1)
    class South : FourWayDirection(2)
    class West : FourWayDirection(3)

    override fun values() = arrayOf<Direction>(N, E, S, W)

    companion object {
        val N = North()
        val E = East()
        val S = South()
        val W = West()

        fun nearestTo(degrees: Float) = Direction.nearestTo(degrees, N.values())
    }
}

sealed class EightWayDirection(ordinal: Int) : Direction(ordinal) {
    class North : EightWayDirection(0)
    class NorthEast : EightWayDirection(1)
    class East : EightWayDirection(2)
    class SouthEast : EightWayDirection(3)
    class South : EightWayDirection(4)
    class SouthWest : EightWayDirection(5)
    class West : EightWayDirection(6)
    class NorthWest : EightWayDirection(7)

    override fun values() = arrayOf<Direction>(N, NE, E, SE, S, SW, W, NW)

    companion object {
        val N = North()
        val NE = NorthEast()
        val E = East()
        val SE = SouthEast()
        val S = South()
        val SW = SouthWest()
        val W = West()
        val NW = NorthWest()

        fun nearestTo(degrees: Float) = Direction.nearestTo(degrees, N.values())
    }
}

sealed class SixteenWayDirection(ordinal: Int) : Direction(ordinal) {
    class North : SixteenWayDirection(0)
    class NorthNorthEast : SixteenWayDirection(1)
    class NorthEast : SixteenWayDirection(2)
    class EastNorthEast : SixteenWayDirection(3)
    class East : SixteenWayDirection(4)
    class EsatSouthEast : SixteenWayDirection(5)
    class SouthEast : SixteenWayDirection(6)
    class SouthSouthEast : SixteenWayDirection(7)
    class South : SixteenWayDirection(8)
    class SouthSouthWest : SixteenWayDirection(9)
    class SouthWest : SixteenWayDirection(10)
    class WestSouthWest : SixteenWayDirection(11)
    class West : SixteenWayDirection(12)
    class WestNorthWest : SixteenWayDirection(13)
    class NorthWest : SixteenWayDirection(14)
    class NorthNorthWest : SixteenWayDirection(15)

    override fun values() = arrayOf<Direction>(N, NNE, NE, ENE, E, ESE, SE, SSE, S, SSW, SW, WSW, W, WNW, NW, NNW)

    companion object {
        val N = North()
        val NNE = NorthNorthEast()
        val NE = NorthEast()
        val ENE = EastNorthEast()
        val E = East()
        val SSE = SouthSouthEast()
        val SE = SouthEast()
        val ESE = EsatSouthEast()
        val S = South()
        val SSW = SouthSouthWest()
        val SW = SouthWest()
        val WSW = WestSouthWest()
        val W = West()
        val WNW = WestNorthWest()
        val NW = NorthWest()
        val NNW = NorthNorthWest()

        fun nearestTo(degrees: Float) = Direction.nearestTo(degrees, N.values())
    }
}
