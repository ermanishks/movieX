package com.contest.moviex.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.observe
import com.contest.moviex.MainViewModel
import com.contest.moviex.R
import com.contest.moviex.base.BaseFragment
import com.contest.moviex.base.Status
import com.contest.moviex.databinding.LayoutFragmentHomeBinding
import com.contest.moviex.ui.main.adapters.DividerItemDecoration
import com.contest.moviex.ui.main.adapters.MovieAdapter
import kotlinx.android.synthetic.main.layout_fragment_home.*

/**
 * Created by Manish Kumar
 */
class HomeFragment: BaseFragment<LayoutFragmentHomeBinding, HomeViewModel>() {

     lateinit var activityVM: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MANISH","HomeFragment  onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       activity?.let {
           activityVM= activityViewModel()
       }
        activityVM.searchText.observe(viewLifecycleOwner){
            viewModel.searchMovie(it)
        }
        viewModel.movieInfo.observe(viewLifecycleOwner) { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    bar_laoding.visibility= View.GONE
                    resource.data?.let {
                        view_recycler.addItemDecoration(DividerItemDecoration(10))
                        view_recycler.adapter= MovieAdapter(it)
                    }
                }
                Status.LOADING -> {
                    bar_laoding.visibility= View.VISIBLE
                }
                Status.ERROR -> {
                    bar_laoding.visibility= View.GONE
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        Log.d("MANISH","HomeFragment  onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MANISH","HomeFragment  onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("MANISH","HomeFragment  onDestroyView")
    }

    override fun getViewModelClass(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun layoutId(): Int {
        return R.layout.layout_fragment_home
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}