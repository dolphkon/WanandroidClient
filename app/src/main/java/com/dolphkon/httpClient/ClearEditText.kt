package com.dolphkon.httpClient

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.OnFocusChangeListener
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httpClient
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/29 15:11
 * Description:TODO
 * *****************************************************
 */
class ClearEditText : AppCompatEditText, OnFocusChangeListener, TextWatcher {
    private var mClearDrawable: Drawable? = null

    constructor(context: Context) : super(context) {}
    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = android.R.attr.editTextStyle) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        mClearDrawable = compoundDrawables[2]
        if (mClearDrawable == null) {
            mClearDrawable = ContextCompat.getDrawable(App.context, R.drawable.login_cancel)
        }
        mClearDrawable!!.setBounds(0, 0, mClearDrawable!!.intrinsicWidth, mClearDrawable!!.intrinsicHeight)
        onFocusChangeListener = this
        addTextChangedListener(this)
        setClearIconVisible(false)
    }

    /**
     * 设置图标的显示与隐藏
     */
    private fun setClearIconVisible(visible: Boolean) {
        val right = if (visible) mClearDrawable else null
        setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], right, compoundDrawables[3])
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        setClearIconVisible(s.length > 0)
    }

    override fun afterTextChanged(s: Editable) {}
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (compoundDrawables[2] != null) {
            if (event.action == MotionEvent.ACTION_UP) {
                val touchable = (event.x > (width
                        - paddingRight - mClearDrawable!!.intrinsicWidth)
                        && event.x < width - paddingRight)
                if (touchable) {
                    this.setText("")
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onFocusChange(v: View, hasFocus: Boolean) {
        if (hasFocus) {
            setClearIconVisible(text!!.length > 0)
        } else {
            setClearIconVisible(false)
        }
    }
}