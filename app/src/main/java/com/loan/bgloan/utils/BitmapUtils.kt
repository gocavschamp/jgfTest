package com.loan.bgloan.utils

import android.graphics.Bitmap
import android.view.View

object BitmapUtils {
    /**
     * 获取已经显示的view的bitmap
     * @param view
     * @return
     */
    private fun getCacheBitmapFromView(view: View): Bitmap? {
        val drawingCacheEnabled = true
        view.isDrawingCacheEnabled = drawingCacheEnabled
        view.buildDrawingCache(drawingCacheEnabled)
        val drawingCache = view.drawingCache
        var bitmap: Bitmap? = null
        if (drawingCache != null) {
            bitmap = Bitmap.createBitmap(drawingCache)
            view.isDrawingCacheEnabled = false
        }
        return bitmap
    }

    /**
     * 获取未显示的view的bitmap
     * @param view
     * @param width
     * @param height
     * @return
     */
    fun getBitmapFromView(view: View, width: Int, height: Int): Bitmap? {
        layoutView(view, width, height)
        return getCacheBitmapFromView(view)
    }

    /**
     * 布局控件
     * @param view
     * @param width
     * @param height
     */
    private fun layoutView(view: View, width: Int, height: Int) {
        view.layout(0, 0, width, height)
        val measuredWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY)
        val measuredHeight = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
        view.measure(measuredWidth, measuredHeight)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
    }
}
