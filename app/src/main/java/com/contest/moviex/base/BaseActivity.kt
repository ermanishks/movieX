package com.contest.moviex.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.contest.moviex.ImdbViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by Manish Kumar
 */
abstract class BaseActivity<B : ViewDataBinding>: DaggerAppCompatActivity() {

    protected lateinit var binding: B
    abstract fun getContentViewId(): Int
    abstract fun getRootLayoutContainer(): View

    @Inject
    lateinit var viewModelFactory: ImdbViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getContentViewId())
    }

    // first change

    // second change

    // third change 

    inline fun <reified T : ViewModel> FragmentActivity.viewModel(): T {
        return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
    }
}