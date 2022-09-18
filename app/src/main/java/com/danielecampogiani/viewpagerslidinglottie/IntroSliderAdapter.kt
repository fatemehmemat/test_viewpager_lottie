package com.danielecampogiani.viewpagerslidinglottie

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danielecampogiani.viewpagerslidinglottie.databinding.SlideItemContainerBinding

class IntroSliderAdapter(private val introSlides: List<IntroSlide>)
    : RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>(){



  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            SlideItemContainerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }

    inner class IntroSlideViewHolder(private val binding: SlideItemContainerBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(introSlide: IntroSlide) {
            binding.title.text = introSlide.title
            binding.description.text = introSlide.description
        }
    }

}
