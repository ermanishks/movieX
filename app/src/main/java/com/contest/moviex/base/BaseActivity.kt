package com.contest.moviex.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Created by Manish Kumar
 */
abstract class BaseActivity<B : ViewDataBinding>:AppCompatActivity(){

    protected lateinit var binding: B
    abstract fun getContentViewId(): Int
    abstract fun getRootLayoutContainer(): View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getContentViewId())
    }
}
inline fun <reified T : ViewModel> FragmentActivity.viewModel(): T {
    return ViewModelProviders.of(this)[T::class.java]
}