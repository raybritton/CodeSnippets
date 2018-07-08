abstract class Point<T : Number>(var x: T, var y: T) {
    abstract fun isNear(x: T, y: T, range: T): Boolean
    abstract fun set(x: T, y: T): Point<T>
    abstract fun distanceTo(x: T, y: T): T
    abstract fun midPointFrom(x: T, y: T): Point<T>
    abstract fun move(direction: Direction)
    abstract fun angleTo(x: T, y: T): Float
    abstract fun pointOnCircle(radius: T, degrees: Float): Point<T>
    operator fun component1() = x
    operator fun component2() = y
}

class IntPoint(x: Int, y: Int) : Point<Int>(x, y) {
    override fun isNear(x: Int, y: Int, range: Int) = ((x - range)..(x + range)).contains(x) && ((y - range)..(y + range)).contains(y)

    override fun set(x: Int, y: Int): IntPoint {
        this.x = x
        this.y = y
        return this
    }

    override fun distanceTo(x: Int, y: Int): Int {
        return Math.abs(Math.hypot((this.x - x).toDouble(), (this.y - y).toDouble()).toInt())
    }

    override fun midPointFrom(x: Int, y: Int): IntPoint {
        return IntPoint(((this.x + x) / 2f).toInt(), ((this.y + y) / 2f).toInt())
    }

    override fun angleTo(x: Int, y: Int): Float {
        return Math.toDegrees(Math.atan2((y - this.y).toDouble(), (x - this.x).toDouble())).toFloat()
    }

    override fun move(direction: Direction) {
        val (nx, ny) = pointOnCircle(1, direction.degrees)
        x = nx
        y = ny
    }

    override fun pointOnCircle(radius: Int, degrees: Float): Point<Int> {
        val cx = (radius * Math.cos(degrees * Math.PI / 180f) + x).toInt()
        val cy = (radius * Math.sin(degrees * Math.PI / 180f) + y).toInt()

        return IntPoint(cx, cy)
    }
}

class FloatPoint(x: Float, y: Float) : Point<Float>(x, y) {
    override fun isNear(x: Float, y: Float, range: Float) = ((x - range)..(x + range)).contains(x) && ((y - range)..(y + range)).contains(y)

    override fun set(x: Float, y: Float): FloatPoint {
        this.x = x
        this.y = y
        return this
    }

    override fun distanceTo(x: Float, y: Float): Float {
        return Math.abs(Math.hypot((this.x - x).toDouble(), (this.y - y).toDouble()).toFloat())
    }

    override fun midPointFrom(x: Float, y: Float): FloatPoint {
        return FloatPoint((this.x + x) / 2f, (this.y + y) / 2f)
    }

    override fun angleTo(x: Float, y: Float): Float {
        return Math.toDegrees(Math.atan2((y - this.y).toDouble(), (x - this.x).toDouble())).toFloat()
    }

    override fun move(direction: Direction) {
        val (nx, ny) = pointOnCircle(1f, direction.degrees)
        x = nx
        y = ny
    }

    override fun pointOnCircle(radius: Float, degrees: Float): Point<Float> {
        val cx = (radius * Math.cos(degrees * Math.PI / 180f) + x).toFloat()
        val cy = (radius * Math.sin(degrees * Math.PI / 180f) + y).toFloat()

        return FloatPoint(cx, cy)
    }
}
