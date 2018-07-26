package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.common.bindingAdapters

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, url:String?) {
    Glide.with(view.context).load(url).into(view);
}