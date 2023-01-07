package com.example.githubclient.ui.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubclient.data.RepositoryModel
import com.example.githubclient.repository.MainRepository
import com.example.githubclient.repository.NetworkState
import kotlinx.coroutines.launch

class MainViewModel (private val mainRepository: MainRepository): ViewModel() {
    val repoList = MutableLiveData<List<RepositoryModel>?>()

    fun getUserRepos(userName: String) {
        Log.d("Thread Outside", Thread.currentThread().name)

        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)
            when (val response = mainRepository.getUserRepos(userName)) {
                is NetworkState.Success -> {
                    repoList.postValue(response.data)
                }
                is NetworkState.Error -> {
                        //movieList.postValue(NetworkState.Error())

                }
            }
        }
    }

}