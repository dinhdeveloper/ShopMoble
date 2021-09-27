package com.canhdinh.mobileshop.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class Weight(
    val imperial: String,
    val metric: String
) : Serializable