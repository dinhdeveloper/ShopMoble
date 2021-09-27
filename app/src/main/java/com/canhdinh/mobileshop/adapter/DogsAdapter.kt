package com.canhdinh.mobileshop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.canhdinh.mobileshop.R
import com.canhdinh.mobileshop.databinding.EachRowBinding
import com.canhdinh.mobileshop.model.BreedModel
import javax.inject.Inject

class DogsAdapter @Inject constructor() :
    PagingDataAdapter<BreedModel, DogsAdapter.DogsViewHolder>(Diff()) {


    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val dogs = getItem(position)
        if (dogs != null) {
            holder.binds(dogs, holder.itemView.context)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder =
        DogsViewHolder(EachRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    class DogsViewHolder(private val binding: EachRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binds(dogs: BreedModel, context: Context?) {
            binding.apply {
                if (dogs.breeds.isNotEmpty()) {
                    //name.text = dogs.breeds[0].name
                }

                //cach 1
                val circularProgressDrawable = context?.let { CircularProgressDrawable(it) }
                circularProgressDrawable?.strokeWidth = 5f
                circularProgressDrawable?.centerRadius = 30f
                circularProgressDrawable?.start()


                context?.let {
                    Glide.with(it).load(dogs.url)
                        .centerCrop()
                        .apply(RequestOptions.centerInsideTransform())
                        .placeholder(R.drawable.glide_load)
                        .into(binding.image)
                }
            }
        }

    }

    class Diff : DiffUtil.ItemCallback<BreedModel>() {
        override fun areItemsTheSame(oldItem: BreedModel, newItem: BreedModel): Boolean =
            oldItem.url == newItem.url

        override fun areContentsTheSame(oldItem: BreedModel, newItem: BreedModel): Boolean =
            oldItem == newItem
    }
}