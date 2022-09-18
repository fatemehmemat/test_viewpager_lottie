package com.danielecampogiani.viewpagerslidinglottie

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.danielecampogiani.viewpagerslidinglottie.extensions.Half
import com.danielecampogiani.viewpagerslidinglottie.extensions.setupWithViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Health Tips / Advice",
                "Discover tips and advice to help you to help maintain transform and main your health"
            ),
            IntroSlide(
                "Diet Tips / Advice",
                "Find out basics of health diet and good nutrition, Start eating well and keep a balanced diet"
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            setup()
        }
        Log.d("TAG", "setup:header.frame " + header.frame)
    }

    private fun setup() {
        pager.adapter = introSliderAdapter

        header.setupWithViewPager(pager, Half)
        header.playAnimation()
        header.setMinFrame(0)
        header.setMaxFrame(150)



        header.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {
                Log.d("TAG", "onAnimationStart" + p0)
            }

            override fun onAnimationEnd(p0: Animator) {
            }

            override fun onAnimationCancel(p0: Animator) {
                Log.d("TAG", "onAnimationCancel" + p0)
            }

            override fun onAnimationRepeat(p0: Animator) {
                Log.d("TAG", "onAnimationRepeat" + p0)
                if (header.frame == 150) {
                    header.playAnimation()
                    header.setMinFrame(90)
                    header.setMaxFrame(150)
                }
            }
        })
        pager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0) {
                    header.playAnimation()
                    header.setMinFrame(140)
                    header.setMaxFrame(150)
                } else {
                    header.playAnimation()
                    header.setMinFrame(150)
                    header.setMaxFrame(300)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })

       
    }



}
