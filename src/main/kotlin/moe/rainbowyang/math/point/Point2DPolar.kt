package moe.rainbowyang.math.point

import moe.rainbowyang.math.util.asPoint2D
import kotlin.math.*

/**
 * 二维极坐标点
 * @author Rainbow Yang
 */

data class Point2DPolar(val radius: Double, val angle: Double) : Point {
    constructor(radius: Number, angle: Number) : this(radius.toDouble(), angle.toDouble())

    companion object {
        operator fun invoke(form: Point): Point2DPolar {
            val pd = form.asPoint2D
            return Point2DPolar(pd.length, pd.angle)
        }
    }

    override val asAxes by lazy { PointAxes(radius * cos(angle), radius * sin(angle)) }

    /**
     * 逆时针旋转[angle]【弧度】
     */
    fun spin(angle: Number) = Point2DPolar(radius, this.angle + angle.toDouble())

    override fun equals(other: Any?): Boolean {
        if (super.equals(other)) return true

        other as Point2DPolar

        if (radius != other.radius || (angle % (PI * 2)) == (other.angle % (PI * 2))) return false

        return true
    }
}