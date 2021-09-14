package com.example.testapp.data.dto

import com.google.gson.annotations.SerializedName

data class UsersDto(
    @SerializedName("data")
    val people: List<PeopleDto>
)
