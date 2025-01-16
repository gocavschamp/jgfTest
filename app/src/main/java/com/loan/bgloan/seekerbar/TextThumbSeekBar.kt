package com.loan.bgloan.seekerbar

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.SeekBar
import com.tools.widget.SizeUtils.dp2px
import com.tools.widget.SizeUtils.sp2px

@SuppressLint("AppCompatCustomView")
class TextThumbSeekBar  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.seekBarStyle
) : SeekBar(context, attrs, defStyleAttr) {

    private val textPaint = Paint()
    private val bgPaint = Paint()
    private val textRect = Rect()
    private val textbgRect = RectF()
    private val paddingHor =  dp2px(getContext(),8f)
    private val paddingVer =  dp2px(getContext(),5f)

    // 用于存储要显示在thumb上的文字
    private var thumbText = "进度"

    init {
        textPaint.apply {
            color = Color.BLACK
            textSize = sp2px(getContext(),20f).toFloat()
            isAntiAlias = true
        }
        bgPaint.apply {
            color = Color.BLUE
            isAntiAlias = true
        }
    }

    // 设置thumb上要显示的文字
    fun setThumbText(text: String) {
        thumbText = text
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 计算thumb的中心位置
        val thumbX = thumb.bounds.centerX()
        val thumbY = thumb.bounds.centerY()

        // 获取要显示文字的宽度和高度
        textPaint.getTextBounds(thumbText+progress, 0, thumbText.length, textRect)
        textbgRect.set((thumbX - textRect.width() / 2- paddingHor).toFloat(),
            (thumbY - textRect.height() / 2- paddingVer).toFloat(),
            (thumbX + textRect.width() / 2+paddingHor).toFloat(), (thumbY + textRect.height() / 2+paddingVer).toFloat()
        )
        canvas.drawRoundRect(textbgRect, dp2px(context,5f).toFloat(), dp2px(context,5f).toFloat(),bgPaint)
        // 在thumb的中心位置绘制文字
        canvas.drawText(thumbText, thumbX - textRect.width() / 2f, thumbY + textRect.height() / 2f, textPaint)
    }
}
fun Float.sp2px(context: Context): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, context.resources.displayMetrics).toInt()
}
fun Float.dp2px(context: Context): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics).toInt()
}