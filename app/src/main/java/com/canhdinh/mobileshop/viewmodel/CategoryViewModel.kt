package com.canhdinh.mobileshop.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canhdinh.mobileshop.model.CategoryModel
import com.canhdinh.mobileshop.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) :
    ViewModel() {

    private val _response = MutableLiveData<List<CategoryModel>>()
    val categoryResponse: LiveData<List<CategoryModel>>
        get() = _response

    init {
        getListCategory()
    }

    private fun getListCategory() = viewModelScope.launch {
        repository.getListCategory().let { response ->
            try {
                if (response.isSuccessful) {
                    _response.postValue(response.body())
                    _response.postValue(response.body())
                } else {
                    Log.d("response", "error: ${response.code()}")
                }
            }catch (ex: SocketTimeoutException){
                Log.e("AAAAAAAAAA","${ex.message}")
            }


        }
    }
}