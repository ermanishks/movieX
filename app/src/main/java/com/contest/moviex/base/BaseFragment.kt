package com.contest.moviex.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.contest.moviex.ImdbViewModelFactory
import com.contest.moviex.network.NetworkService
import com.contest.moviex.repo.MovieRepository
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by Manish Kumar
 */
abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel>:DaggerFragment() {


    /**
     * Gets the class of the View model for instantiation
     * @return - Class of view model
     */
    abstract fun getViewModelClass(): Class<VM>

   @Inject lateinit var viewModelFactory: ImdbViewModelFactory

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    /**
     * Layout to be inflated for the fragment
     * @return - Resource ID of the layout
     */
    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[getViewModelClass()]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(layoutId(), container, false)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        return view
    }

    // vms with different scope
    inline fun <reified T : ViewModel> Fragment.activityViewModel(): T {
        return ViewModelProviders.of(activity!!)[T::class.java]
    }

    inline fun <reified T : ViewModel> Fragment.parentFragmentViewModel(
    ): T {
        return androidx.lifecycle.ViewModelProviders.of(parentFragment!!, viewModelFactory)[T::class.java]
    }

    inline fun <reified T : ViewModel> Fragment.targetFragmentViewModel(
    ): T {
        return androidx.lifecycle.ViewModelProviders.of(targetFragment!!, viewModelFactory)[T::class.java]
    }

}