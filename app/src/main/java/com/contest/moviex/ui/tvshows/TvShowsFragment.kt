package com.contest.moviex.ui.tvshows

import android.os.Bundle
import android.util.Log
import com.contest.moviex.R
import com.contest.moviex.base.BaseFragment
import com.contest.moviex.databinding.LayoutTvShowsFragmentBinding

/**
 * Created by Manish Kumar
 */
class TvShowsFragment: BaseFragment<LayoutTvShowsFragmentBinding, TvShowsViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
}