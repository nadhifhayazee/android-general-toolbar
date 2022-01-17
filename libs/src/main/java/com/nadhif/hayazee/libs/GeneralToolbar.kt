package com.nadhif.hayazee.libs

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class GeneralToolbar constructor(
    context: Context,
    attrs: AttributeSet
) : ConstraintLayout(context, attrs) {

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int
    ) : this(context, attrs)

    private var _attributes: TypedArray
    private var _toolbar: ConstraintLayout
    private var _tvTitle: TextView
    private var _btnBack: ImageView

    val toolbar get() = _toolbar
    val title get() = _tvTitle
    val btnBack get() = _btnBack

    init {

        inflate(context, R.layout.general_toolbar_layout, this)
        _attributes = context.obtainStyledAttributes(attrs, R.styleable.GeneralToolbar)

        _toolbar = findViewById(R.id.rootView)
        _tvTitle = findViewById(R.id.tvTitle)
        _btnBack = findViewById(R.id.btnBack)

        setupView()

        _attributes.recycle()

    }

    private fun setupView() {

        val toolbarBackground = _attributes.getResourceId(
            R.styleable.GeneralToolbar_toolbarBackground,
            R.color.white
        )


        val titleColor =
            _attributes.getColor(
                R.styleable.GeneralToolbar_toolbarTitleColor,
                ContextCompat.getColor(context, R.color.black)
            )


        val toolbarBackIcon = _attributes.getResourceId(
            R.styleable.GeneralToolbar_toolbarBackIcon,
            R.drawable.ic_back_default
        )

        _toolbar.setBackgroundResource(toolbarBackground)
        _tvTitle.text = _attributes.getString(R.styleable.GeneralToolbar_toolbarTitle) ?: "Title"
        _tvTitle.setTextColor(titleColor)
        _btnBack.setImageResource(toolbarBackIcon)

    }


}