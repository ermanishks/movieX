package com.contest.moviex.ui.tvshows

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.observe
import com.contest.moviex.MainViewModel
import com.contest.moviex.R
import com.contest.moviex.base.BaseFragment
import com.contest.moviex.databinding.LayoutTvShowsFragmentBinding
import kotlinx.android.synthetic.main.layout_tv_shows_fragment.*

/**
 * Created by Manish Kumar
 */
class TvShowsFragment: BaseFragment<LayoutTvShowsFragmentBinding, TvShowsViewModel>() {

    lateinit var activityVM: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.let {
            activityVM= activityViewModel()
        }
        Log.d("MANISH","TvShowsFragment  onCreate")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MANISH","TvShowsFragment  onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MANISH","TvShowsFragment  onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("MANISH","TvShowsFragment  onDestroyView")
    }
    companion object {
        fun newInstance() = TvShowsFragment()
    }

    override fun getViewModelClass(): Class<TvShowsViewModel> {
        return TvShowsViewModel::class.java
    }

    override fun layoutId(): Int {
      return  R.layout.layout_tv_shows_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityVM.list.observe(viewLifecycleOwner){
            view_recycler_1.adapter= SearchedTextAdapter(it)
        }
    }
}