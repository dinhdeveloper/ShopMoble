package com.canhdinh.mobileshop.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CustomerModel(
    val createdDate: String,
    val customerId: Int,
    val dateOfBirth: String,
    val email: String,
    val gender: String,
    val image: String,
    val name: String,
    val password: String,
    val phone: String,
    val status: String
) : Parcelable