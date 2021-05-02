package com.example.pp

import android.app.Activity
import android.content.Context
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

abstract class SwipeToDelete(context: world, dragDir:Int, SwipeDir:Int ):ItemTouchHelper.SimpleCallback(dragDir,SwipeDir){

    private val deleteIcon = ContextCompat.getDrawable(context.requireContext(), R.drawable.ic_baseline_delete_24)
    private val inWidth = deleteIcon!!.intrinsicWidth
    private val inHeight = deleteIcon!!.intrinsicHeight
    private val background = ColorDrawable()
    private val backgroundColor = Color.parseColor("#f44336")
    val icon = ContextCompat.getDrawable(context.requireContext(), R.drawable.ic_baseline_delete_24)!!

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                             dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        val itemView = viewHolder.itemView
        val itemHeight = itemView.bottom - itemView.top

        // Draw the red delete background
        background.color = backgroundColor
        background.setBounds(
                itemView.right + dX.toInt(),
                itemView.top,
                itemView.right,
                itemView.bottom
        )
        background.draw(c)

        // Calculate position of delete icon
        val iconTop = itemView.top + (itemHeight - inHeight) / 2
        val iconMargin = (itemHeight - inHeight) / 2
        val iconLeft = itemView.right - iconMargin - inWidth
        val iconRight = itemView.right - iconMargin
        val iconBottom = iconTop + inHeight

        // Draw the delete icon
        icon.setBounds(iconLeft, iconTop, iconRight, iconBottom)
        icon.draw(c)
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)


        }
    }


