package com.danielecampogiani.viewpagerslidinglottie.extensions

import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.airbnb.lottie.LottieAnimationView

fun LottieAnimationView.setupWithViewPager(viewPager: ViewPager2, scrollingStrategy: ScrollingStrategy = Full) {

    val adapter = viewPager.adapter
            ?: throw IllegalStateException("ViewPager adapter could not be null")

    val numPages = adapter.itemCount


    viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            var progress = (position + positionOffset) / (numPages - 1)
             progress = scrollingStrategy.compute(progress)
        }

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

        }

        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
        }
    })
}

sealed class ScrollingStrategy {
    abstract fun compute(realProgress: Float): Float
}

object Full : ScrollingStrategy() {
    override fun compute(realProgress: Float) = realProgress
}

object Half : ScrollingStrategy() {
    override fun compute(realProgress: Float) = realProgress /2
}