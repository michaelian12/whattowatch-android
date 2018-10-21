package com.michaelagustian.whattowatch.features.main

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.michaelagustian.whattowatch.R
import com.michaelagustian.whattowatch.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val presenter = MainPresenterImpl()

    override fun getResourceLayout() = R.layout.activity_main

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupToolbar(toolbar)

        // Initialize Tab
        vp_movie.adapter = MainPagerAdapter(presenter.getTabs(), supportFragmentManager)
        tl_movie.setupWithViewPager(vp_movie)
        tl_movie.tabMode = TabLayout.MODE_SCROLLABLE
    }
}
