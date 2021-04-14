package dev.challenge.soundcloudapp.data.model

data class User(
    val avatar_url: String,
    val id: Int,
    val kind: String,
    val last_modified: String,
    val permalink: String,
    val permalink_url: String,
    val uri: String,
    val username: String
)