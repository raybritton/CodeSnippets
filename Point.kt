data class IntPoint(var x: Int, var y: Int) {
    fun isNear(x: Int, y: Int, range: Int) = ((x - range)..(x + range)).contains(x) && ((y - range)..(y + range)).contains(y)

    fun set(x: Int, y: Int): IntPoint {
        this.x = x
        this.y = y
        return this
    }

    fun distanceTo(x: Int, y: Int): Int {
        return Math.abs(Math.hypot((this.x - x).toDouble(), (this.y - y).toDouble()).roundToInt())
    }

    fun midPointFrom(x: Int, y: Int): IntPoint {
        return IntPoint(((this.x + x) / 2f).roundToInt(), ((this.y + y) / 2f).roundToInt())
    }

    fun angleTo(x: Int, y: Int): Float {
        return Math.toDegrees(Math.atan2((y - this.y).toDouble(), (x - this.x).toDouble())).toFloat()
    }

    fun moveBy(direction: Direction): IntPoint {
        return pointOnCircle(1, direction.degrees - 90)
    }

    fun move(direction: Direction) {
        val (nx, ny) = pointOnCircle(1, direction.degrees)
        x = nx
        y = ny
    }

    fun pointOnCircle(radius: Int, degrees: Float): IntPoint {
        val cx = (radius * Math.cos(Math.toRadians(degrees.toDouble())) + x).roundToInt()
        val cy = (radius * Math.sin(Math.toRadians(degrees.toDouble())) + y).roundToInt()

        return IntPoint(cx, cy)
    }
}

data class FloatPoint(var x: Float, var y: Float){
    fun isNear(x: Float, y: Float, range: Float) = ((x - range)..(x + range)).contains(x) && ((y - range)..(y + range)).contains(y)

    fun set(x: Float, y: Float): FloatPoint {
        this.x = x
        this.y = y
        return this
    }

    fun distanceTo(x: Float, y: Float): Float {
        return Math.abs(Math.hypot((this.x - x).toDouble(), (this.y - y).toDouble()).toFloat())
    }

    fun midPointFrom(x: Float, y: Float): FloatPoint {
        return FloatPoint((this.x + x) / 2f, (this.y + y) / 2f)
    }

    fun angleTo(x: Float, y: Float): Float {
        return Math.toDegrees(Math.atan2((y - this.y).toDouble(), (x - this.x).toDouble())).toFloat()
    }

    fun moveBy(direction: Direction): FloatPoint {
        return pointOnCircle(1f, direction.degrees - 90)
    }

    fun move(direction: Direction) {
        val (nx, ny) = pointOnCircle(1f, direction.degrees)
        x = nx
        y = ny
    }

    fun pointOnCircle(radius: Float, degrees: Float): FloatPoint {
        val cx = (radius * Math.sin(degrees * Math.PI / 180f) + x).toFloat()
        val cy = (radius * Math.cos(degrees * Math.PI / 180f) + y).toFloat()

        return FloatPoint(cx, cy)
    }
}
