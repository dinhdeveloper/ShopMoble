package com.canhdinh.mobileshop.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryModel(
    val categoryId: Int,
    val categoryImage: String,
    val categoryName: String,
    val promotionId: Int
) : Parcelable