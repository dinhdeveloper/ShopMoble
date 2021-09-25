package com.canhdinh.mobileshop.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val amount: String,
    val categoryId: Int,
    val percentSale: String,
    val priceSale: String,
    val productId: Int,
    val productImage: String,
    val productName: String,
    val productPrice: String,
    val rate: String,
    val status: String
) : Parcelable