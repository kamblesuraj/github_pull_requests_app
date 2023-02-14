package com.demo.github.data.repository.UserRepoDetailRepo

import com.demo.github.data.api.GithubAPI
import com.demo.github.data.api.Resource
import com.demo.github.data.model.UserRepoItem
import com.demo.github.exceptions.HttpException
import com.demo.github.exceptions.NoInternetConnectionException
import com.demo.github.exceptions.UnknownException
import com.demo.github.utils.UrlConstants
import java.io.IOException

class UserGitRepoDetailsImpl(
    private val api: GithubAPI
) : UserGitRepoDetail {
    override suspend fun getUserGitRepoDetails(): Resource<UserRepoItem> {
        return try {
            val response = api.getUserDetails(UrlConstants.USER_URL)
            if (response.isSuccessful) {
                response.body()?.let { res ->
                    return Resource.Success(data = res)
                }
            }
            Resource.Error(UnknownException())
        } catch (exception: IOException) {
            Resource.Error(message = NoInternetConnectionException())
        } catch (exception: retrofit2.HttpException) {
            Resource.Error(message = HttpException())
        }
    }
}
