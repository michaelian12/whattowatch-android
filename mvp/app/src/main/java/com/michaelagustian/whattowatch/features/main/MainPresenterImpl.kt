package com.michaelagustian.whattowatch.features.main

import com.michaelagustian.whattowatch.Constant

/**
 * Created by Michael Agustian on 21/10/18.
 */

class MainPresenterImpl : MainPresenter {

    override fun getTabs(): ArrayList<Int> {
        val tabs = ArrayList<Int>()
        tabs.add(Constant.TAB_MOVIE_DISCOVER)
        tabs.add(Constant.TAB_MOVIE_TOP_RATED)
        tabs.add(Constant.TAB_MOVIE_POPULAR)
        tabs.add(Constant.TAB_MOVIE_NOW_PLAYING)
        tabs.add(Constant.TAB_MOVIE_UPCOMING)
        return tabs
    }
}