package com.contest.moviex.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Manish Kumar
 */
abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bindData(model: T)
}