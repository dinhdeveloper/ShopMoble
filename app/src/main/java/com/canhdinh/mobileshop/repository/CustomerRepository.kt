package com.canhdinh.mobileshop.repository

import com.canhdinh.mobileshop.network.ApiService
import javax.inject.Inject

class CustomerRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getListCustomer() = apiService.getListCustomer()
}