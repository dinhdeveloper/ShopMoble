package com.canhdinh.mobileshop.repository

import androidx.paging.*
import com.canhdinh.mobileshop.model.BreedModel
import com.canhdinh.mobileshop.network.ApiService
import com.canhdinh.mobileshop.paging.RickyMortyPagingSource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val apiService: ApiService) : PagingSource<Int, BreedModel>() {

    private val DEFAULT_PAGE_INDEX= 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BreedModel> {
        val page = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val response = apiService.getAllDogs(page,params.loadSize)
            LoadResult.Page(
                response,
                prevKey = if(page == DEFAULT_PAGE_INDEX) null else page-1,
                nextKey = if(response.isEmpty()) null else page+1
            )
        } catch (exception: IOException){
            LoadResult.Error(exception)
        } catch (exception: HttpException){
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, BreedModel>): Int? {
        return null
    }
}
