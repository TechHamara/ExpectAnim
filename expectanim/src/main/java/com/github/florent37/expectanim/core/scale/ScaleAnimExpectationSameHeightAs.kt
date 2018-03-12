package com.github.florent37.expectanim.core.scale

import android.view.View

/**
 * Created by florentchampigny on 20/02/2017.
 */
class ScaleAnimExpectationSameHeightAs(otherView: View, gravityHorizontal: Int?, gravityVertical: Int?) : ScaleAnimExpectationViewDependant(otherView, gravityHorizontal, gravityVertical) {

    override fun getCalculatedValueScaleX(viewToMove: View): Float? {
        return if (keepRatio) {
            getCalculatedValueScaleY(viewToMove)
        } else null
    }

    override fun getCalculatedValueScaleY(viewToMove: View): Float? {
        val viewToMoveHeight = viewToMove.height

        val otherViewHeight = viewCalculator!!.finalHeightOfView(otherView)

        return if (otherViewHeight == 0f || viewToMoveHeight.toFloat() == 0f) {
            0f
        } else otherViewHeight / viewToMoveHeight
    }
}
