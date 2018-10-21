package com.michaelagustian.whattowatch.features.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.michaelagustian.whattowatch.Constant
import com.michaelagustian.whattowatch.features.movie.MovieFragment

/**
 * Created by Michael Agustian on 20/10/18.
 */

class MainPagerAdapter(val tabs: ArrayList<Int>, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return MovieFragment.newInstance(tabs[position])
    }

    override fun getCount() = tabs.size

    override fun getPageTitle(position: Int): CharSequence? {
        when (tabs[position]) {
            Constant.TAB_MOVIE_DISCOVER -> return "Movie"
            Constant.TAB_MOVIE_TOP_RATED -> return "Top Rated"
            Constant.TAB_MOVIE_POPULAR -> return "Popular"
            Constant.TAB_MOVIE_NOW_PLAYING -> return "Now Playing"
            Constant.TAB_MOVIE_UPCOMING -> return "Upcoming"
        }

        return super.getPageTitle(position)
    }
}