package com.demo.github.data.model

data class UserRepoItem(
    val body: String,
    val columns_url: String,
    val created_at: String,
    val creator: Creator,
    val html_url: String,
    val id: Int,
    val name: String,
    val node_id: String,
    val number: Int,
    val owner_url: String,
    val state: String,
    val updated_at: String,
    val url: String
) {
    data class Creator(
        val avatar_url: String,
        val events_url: String,
        val followers_url: String,
        val following_url: String,
        val gists_url: String,
        val gravatar_id: String,
        val html_url: String,
        val id: Int,
        val login: String,
        val organizations_url: String,
        val received_events_url: String,
        val repos_url: String,
        val site_admin: Boolean,
        val starred_url: String,
        val subscriptions_url: String,
        val type: String,
        val url: String
    )
}
