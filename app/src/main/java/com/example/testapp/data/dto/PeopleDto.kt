package com.example.testapp.data.dto

import com.google.gson.annotations.SerializedName

data class PeopleDto(
    val id: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val email: String,
    val avatar: String
)