package com.example.testapp.data.network

import com.example.testapp.data.dto.PeopleDto
import com.example.testapp.data.dto.UsersDto
import io.reactivex.Single
import retrofit2.http.GET

interface PeopleApiInterface {

    @GET("/api/users")
    fun getAllPeopleInfo(): Single<UsersDto>
}