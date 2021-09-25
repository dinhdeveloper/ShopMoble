package com.canhdinh.mobileshop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.canhdinh.mobileshop.databinding.CustomItemCategoryBinding
import com.canhdinh.mobileshop.model.CategoryModel

class CateBindingAdapter : RecyclerView.Adapter<CateBindingAdapter.CategotyViewHolder>() {
    class CategotyViewHolder(private val categoryItemCategoryBinding: CustomItemCategoryBinding) :
        RecyclerView.ViewHolder(categoryItemCategoryBinding.root) {
        fun onBind(category: CategoryModel) {
            //categoryItemCategoryBinding.category = category
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<CategoryModel>() {
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var categoryList: List<CategoryModel>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategotyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cateItemBinding = CustomItemCategoryBinding.inflate(inflater, parent, false)
        return CategotyViewHolder(cateItemBinding)
    }

    override fun onBindViewHolder(holder: CategotyViewHolder, position: Int) {
        holder.onBind(category = categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size ?: 0
}