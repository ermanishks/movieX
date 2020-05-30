package com.contest.moviex.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.contest.moviex.base.BaseViewHolder
import com.contest.moviex.databinding.LytItemMovieBinding
import com.contest.moviex.model.ResultItemRes

/**
 * Created by Manish Kumar
 */
class MovieAdapter(
    private val vList: List<ResultItemRes>): RecyclerView.Adapter<BaseViewHolder<ResultItemRes>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ResultItemRes> {
        val binding = LytItemMovieBinding.inflate(LayoutInflater.from(parent.context))
       return  MovieHolder(binding)
    }

    override fun getItemCount(): Int {
        return vList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ResultItemRes>, position: Int) {
        holder.bindData(vList[position])
    }
    inner class MovieHolder constructor(private val binding: LytItemMovieBinding) :
        BaseViewHolder<ResultItemRes>(binding.root) {
        override fun bindData(model: ResultItemRes) {
            binding.model = model
            binding.executePendingBindings()
        }
    }

}