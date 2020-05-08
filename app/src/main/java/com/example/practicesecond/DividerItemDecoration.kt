package com.example.practicesecond

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecoration (context: Context,val paddingLeft:Int, val paddingRight: Int): RecyclerView.ItemDecoration(){
    private val dividerHeight : Int
    //private var divider : Drawable
    private var mDivider:Drawable

    init{
        val typedArray:TypedArray = context.obtainStyledAttributes(intArrayOf(android.R.attr.listDivider))
       mDivider = typedArray.getDrawable(0 )!!
       // mDivider = ContextCompat.getDrawable(context,R.drawable.divider_medium)
        dividerHeight = mDivider.intrinsicHeight
        typedArray.recycle()


    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val left = parent.paddingLeft +paddingLeft
        val right = parent.width - parent.paddingRight-paddingRight

        val childCount = parent.childCount
        for(i in 0 until childCount){
            val child = parent.getChildAt(i)
            val params: RecyclerView.LayoutParams = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + (mDivider?.intrinsicHeight?:0)

            mDivider?.let{
                it.setBounds(left,top,right,bottom)
                it.draw(c)
            }
        }

    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(0,0,0,dividerHeight)}




}