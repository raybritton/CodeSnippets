data class IntPoint(var x: Int, var y: Int) {
    fun set(x: Int, y: Int): IntPoint {
        this.x = x
        this.y = y
        return this
    }

    fun move(direction: Direction) {
        val (nx, ny) = moveBy(direction)
        x = nx
        y = ny
    }

    fun isNear(x: Int, y: Int, range: Int) = contains(x.toDouble(), y.toDouble(), range.toDouble())
    fun distanceTo(x: Int, y: Int) = distanceTo(this.x.toDouble(), this.y.toDouble(), x.toDouble(), y.toDouble()).roundToInt()
    fun midPointFrom(x: Int, y: Int) = midPoint(this.x.toDouble(), this.y.toDouble(), x.toDouble(), y.toDouble()).toIntPoint()
    fun angleTo(x: Int, y: Int) = angleTo(this.x.toDouble(), this.y.toDouble(), x.toDouble(), y.toDouble()).roundToInt()
    fun moveBy(direction: Direction) = moveBy(this.x.toDouble(), this.y.toDouble(), 1.0, direction).toIntPoint()
    fun pointOnCircle(radius: Int, degrees: Float) = pointOnCircle(this.x.toDouble(), this.y.toDouble(), radius.toDouble(), degrees.toDouble()).toIntPoint()

    companion object {
        fun Pair<Int, Int>.toIntPoint() = IntPoint(this.first, this.second)
    }
}

data class FloatPoint(var x: Float, var y: Float) {
    fun set(x: Float, y: Float): FloatPoint {
        this.x = x
        this.y = y
        return this
    }

    fun move(direction: Direction) {
        val (nx, ny) = moveBy(direction)
        x = nx
        y = ny
    }

    fun isNear(x: Float, y: Float, range: Float) = contains(x.toDouble(), y.toDouble(), range.toDouble())
    fun distanceTo(x: Float, y: Float) = distanceTo(this.x.toDouble(), this.y.toDouble(), x.toDouble(), y.toDouble()).toFloat()
    fun midPointFrom(x: Float, y: Float) = midPoint(this.x.toDouble(), this.y.toDouble(), x.toDouble(), y.toDouble()).toFloatPoint()
    fun angleTo(x: Float, y: Float) = angleTo(this.x.toDouble(), this.y.toDouble(), x.toDouble(), y.toDouble()).toFloat()
    fun moveBy(direction: Direction) = moveBy(this.x.toDouble(), this.y.toDouble(), 1.0, direction).toFloatPoint()
    fun pointOnCircle(radius: Float, degrees: Float) = pointOnCircle(this.x.toDouble(), this.y.toDouble(), radius.toDouble(), degrees.toDouble()).toFloatPoint()

    companion object {
        fun Pair<Int, Int>.toFloatPoint() = FloatPoint(this.first.toFloat(), this.second.toFloat())
    }
}

private fun contains(x: Double, y: Double, range: Double): Boolean {
    return ((x - range)..(x + range)).contains(x) && ((y - range)..(y + range)).contains(y)
}

private fun midPoint(x1: Double, y1: Double, x2: Double, y2: Double): Pair<Int, Int> {
    return Pair(((x1 + x2) / 2.0).roundToInt(), ((y1 + y2) / 2.0).roundToInt())
}

private fun moveBy(x: Double, y: Double, radius: Double, direction: Direction): Pair<Int, Int> {
    return pointOnCircle(x, y, radius, direction.degrees - 90.0)
}

private fun distanceTo(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    return Math.abs(Math.hypot((x2 - x1), (y2 - y1)))
}

private fun angleTo(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    return Math.toDegrees(Math.atan2((y2 - y1), (x2 - x1))) + 90.0
}

private fun pointOnCircle(x: Double, y: Double, radius: Double, degrees: Double): Pair<Int, Int> {
    val cx = (radius * Math.cos(Math.toRadians(degrees)) + x).roundToInt()
    val cy = (radius * Math.sin(Math.toRadians(degrees)) + y).roundToInt()

    return Pair(cx, cy)
}
