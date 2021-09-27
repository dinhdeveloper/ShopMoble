package com.canhdinh.mobileshop.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.canhdinh.mobileshop.model.BreedModel
import com.canhdinh.mobileshop.model.RickMorty
import com.canhdinh.mobileshop.network.ApiService
import com.canhdinh.mobileshop.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val service: ApiService) :
    ViewModel() {

    val getAllDogs:Flow<PagingData<BreedModel>> = Pager(config = PagingConfig(10,enablePlaceholders = true)){
        CharacterRepository(service)
    }.flow.cachedIn(viewModelScope)
}