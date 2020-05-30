package com.contest.moviex.ui.extras

import android.os.Bundle
import android.util.Log
import android.view.View
import com.contest.moviex.R
import com.contest.moviex.base.BaseFragment
import com.contest.moviex.databinding.LytExtrasFragmentBinding
import com.contest.moviex.ui.tvshows.TvShowsFragment

/**
 * Created by Manish Kumar
 */
class ExtrasFragment: BaseFragment<LytExtrasFragmentBinding, ExtrasViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MANISH","ExtrasFragment  onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onResume() {
        super.onResume()
        Log.d("MANISH","ExtrasFragment  onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MANISH","ExtrasFragment  onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("MANISH","ExtrasFragment  onDestroyView")
    }
    companion object {
        fun newInstance() = TvShowsFragment()
    }

    override fun getViewModelClass(): Class<ExtrasViewModel> {
        return ExtrasViewModel::class.java
    }

    override fun layoutId(): Int {
       return R.layout.lyt_extras_fragment
    }
}