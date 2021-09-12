package edu.kiet.camerapermissionandroid11

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
@BindingAdapter("loadImageUrl")
fun ImageView.loadImageUrl(url:String)
{
    Glide.with(this.context).load(url).into(this)
}