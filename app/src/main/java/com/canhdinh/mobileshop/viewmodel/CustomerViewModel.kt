package com.canhdinh.mobileshop.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canhdinh.mobileshop.model.CustomerModel
import com.canhdinh.mobileshop.repository.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(private val customerRepository: CustomerRepository) :ViewModel(){
    private val _response = MutableLiveData<List<CustomerModel>>()
    val customerResponse: LiveData<List<CustomerModel>>
        get() = _response

    init {
        getListCustomer()
    }

    private fun getListCustomer() = viewModelScope.launch {
        customerRepository.getListCustomer().let { response ->
            try {
                if (response.isSuccessful) {
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