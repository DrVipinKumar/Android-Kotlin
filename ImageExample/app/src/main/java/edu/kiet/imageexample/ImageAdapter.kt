package edu.kiet.imageexample

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class ImageAdapter(val context:Context) : PagerAdapter() {
    companion object{
        var images= arrayListOf<Int>(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5)
    }
    override fun getCount(): Int {
       return images.size
    }

    override fun isViewFromObject(view: View, `any`: Any): Boolean {
       return view==any
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var imageView =ImageView(context)
        imageView.scaleType=ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(images[position])
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `any`: Any) {
        container.removeView(any as View?)
    }

}
