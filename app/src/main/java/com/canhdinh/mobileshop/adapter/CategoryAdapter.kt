package com.canhdinh.mobileshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.canhdinh.mobileshop.databinding.CustomItemCategoryBinding
import com.canhdinh.mobileshop.model.CategoryModel

class CategoryAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: CustomItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<CategoryModel>() {
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var category: List<CategoryModel>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CustomItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    class OnClickListener(val clickListener: (meme: CategoryModel) -> Unit) {
        fun onClick(meme: CategoryModel) = clickListener(meme)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currCategory = category[position]
        holder.binding.apply {
            tvCategoryName.text = currCategory.categoryName
//            imvCategory.load(currCategory.categoryImage) {
//                crossfade(true)
//                crossfade(1000)
//            }

            Glide.with(holder.itemView.context)
                .load(currCategory.categoryImage)
                .into(imvCategory)

            holder.binding.itemCategory.setOnClickListener {
                onClickListener.onClick(currCategory)
            }

        }
    }

    override fun getItemCount(): Int = category.size ?: 0
}