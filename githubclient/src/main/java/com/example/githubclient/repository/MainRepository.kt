package com.example.githubclient.repository

import com.example.githubclient.api.GithubService
import com.example.githubclient.data.RepositoryModel

class MainRepository (private val retrofitService: GithubService) {

    suspend fun getUserRepos(userName: String) : NetworkState<List<RepositoryModel>> {
        val response = retrofitService.getUserRepos(userName)
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }

}