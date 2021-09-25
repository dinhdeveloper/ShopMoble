package com.canhdinh.mobileshop.repository

import com.canhdinh.mobileshop.network.ApiService
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val service: ApiService) {

    suspend fun getListCategory() = service.getListCategory()

}