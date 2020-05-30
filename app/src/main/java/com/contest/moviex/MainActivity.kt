package com.contest.moviex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.contest.moviex.base.BaseActivity
import com.contest.moviex.base.viewModel
import com.contest.moviex.databinding.ActivityMainBinding
import com.contest.moviex.ui.extras.ExtrasFragment
import com.contest.moviex.ui.main.HomeFragment
import com.contest.moviex.ui.tvshows.TvShowsFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : BaseActivity<ActivityMainBinding>(), CoroutineScope {

    private lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = viewModel()
        binding.viewPager2.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when(position){
                    0 -> HomeFragment()
                    1 -> TvShowsFragment()
                    2-> ExtrasFragment()
                    else -> HomeFragment()
                }
            }


            override fun getItemCount(): Int {
                return 3
            }
        }
        // to disable sliding
        binding.viewPager2.isUserInputEnabled=false
        TabLayoutMediator(binding.lytTab, binding.viewPager2) { tab, position ->
            when(position){
                0->{tab.text= getString(R.string.movie)}
                1->{tab.text= getString(R.string.tv_shows)}
                2->{tab.text= getString(R.string.extras)}
            }
        }.attach()
        binding.et.addTextChangedListener(watcher)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    val watcher = object : TextWatcher {
        private var searchFor = ""

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val searchText = s.toString().trim()
            if (searchText == searchFor)
                return

            searchFor = searchText

            launch {
                delay(300)  //debounce timeOut
                if (searchText != searchFor)
                    return@launch
                // here launch your code
                vm.searchText.value = searchText
                // save this value in db

            }
        }

        override fun afterTextChanged(s: Editable?) = Unit
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
    }

    override fun getContentViewId(): Int {
        return R.layout.activity_main
    }

    override fun getRootLayoutContainer(): View {
       return  lyt_root
    }
}
