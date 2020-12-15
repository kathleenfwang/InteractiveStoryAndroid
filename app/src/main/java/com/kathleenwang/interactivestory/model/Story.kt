package com.kathleenwang.interactivestory.model

import android.util.Log
import com.kathleenwang.interactivestory.R


class Story {
    private var pages = arrayOfNulls<Page>(7)
    private val tag = Story::class.java.simpleName

    init {
        pages[0] = Page(
                R.drawable.page0,
                R.string.page0,
                Choice(R.string.page0_choice1,1),
                Choice(R.string.page0_choice2,2))
        pages[1] = Page(R.drawable.page1,
                R.string.page1,
                Choice(R.string.page1_choice1, 3),
                Choice(R.string.page1_choice2, 4))

        pages[2] = Page(R.drawable.page2,
                R.string.page2,
                Choice(R.string.page2_choice1, 4),
                Choice(R.string.page2_choice2, 6))

        pages[3] = Page(R.drawable.page3,
                R.string.page3,
                Choice(R.string.page3_choice1, 4),
                Choice(R.string.page3_choice2, 5))

        pages[4] = Page(R.drawable.page4,
                R.string.page4,
                Choice(R.string.page4_choice1, 5),
                Choice(R.string.page4_choice2, 6))
        // last two pages w/ no choices
        pages[5] = Page(R.drawable.page5, R.string.page5)

        pages[6] = Page(R.drawable.page6, R.string.page6)
    }

    // returns a Page
    fun getPage(_pageNumber: Int): Page {
        var pageNumber = _pageNumber
        if (pageNumber >= pages.size) {
            pageNumber = 0
        }
        return pages[pageNumber]!!
    }
}