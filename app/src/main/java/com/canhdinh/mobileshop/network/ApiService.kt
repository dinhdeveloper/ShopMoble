package com.canhdinh.mobileshop.network

import com.canhdinh.mobileshop.model.BreedModel
import com.canhdinh.mobileshop.model.CategoryModel
import com.canhdinh.mobileshop.model.CustomerModel
import com.canhdinh.mobileshop.model.ResponseApi
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("category/list")
    suspend fun getListCategory(): Response<List<CategoryModel>>

    @GET("customer/list")
    suspend fun getListCustomer(): Response<List<CustomerModel>>

    @POST("customer")
    suspend fun addCustomer(@Body customer: CustomerModel?): Response<CustomerModel?>?

    @GET("character")
    suspend fun getAllCharacters(
        // @Query("count") size:Int,
        @Query("page") page: Int

    ): Response<ResponseApi>

    @GET("v1/images/search")
    suspend fun getAllDogs(
        @Query("page") page:Int,
        @Query("limit") limit:Int
    ):List<BreedModel>
}