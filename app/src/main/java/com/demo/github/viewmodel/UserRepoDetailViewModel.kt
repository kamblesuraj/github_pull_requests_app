package com.demo.github.viewmodel

import androidx.lifecycle.ViewModel
import com.demo.github.data.repository.UserRepoDetailRepo.UserGitRepoDetail
import javax.inject.Inject

class UserRepoDetailViewModel @Inject constructor(
    private val userGitRepoDetail: UserGitRepoDetail
) : ViewModel() {

}