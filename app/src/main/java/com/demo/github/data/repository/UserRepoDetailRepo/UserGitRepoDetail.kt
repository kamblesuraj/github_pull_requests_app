package com.demo.github.data.repository.UserRepoDetailRepo

import com.demo.github.data.api.Resource
import com.demo.github.data.model.UserRepoItem

interface UserGitRepoDetail {
    suspend fun getUserGitRepoDetails(): Resource<UserRepoItem>
}