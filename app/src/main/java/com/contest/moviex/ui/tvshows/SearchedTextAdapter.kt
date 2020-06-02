package com.contest.moviex.ui.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contest.moviex.base.BaseViewHolder
import com.contest.moviex.databinding.ItemSearchTextsBinding
import com.contest.moviex.model.SearchTextUI

/**
 * Created by Manish Kumar
 */
class SearchedTextAdapter(
    private val vList: List<SearchTextUI>): RecyclerView.Adapter<BaseViewHolder<SearchTextUI>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<SearchTextUI> {
        val binding = ItemSearchTextsBinding.inflate(LayoutInflater.from(parent.context))
        return  TextHolder(binding)
    }

    override fun getItemCount(): Int {
        return vList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<SearchTextUI>, position: Int) {
        holder.bindData(vList[position])
    }

    inner class TextHolder constructor(private val binding: ItemSearchTextsBinding) :
        BaseViewHolder<SearchTextUI>(binding.root) {
        override fun bindData(model: SearchTextUI) {
            binding.model = model
            binding.executePendingBindings()
        }
    }
}