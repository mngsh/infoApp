package com.example.testapp.data.repository

import com.example.testapp.data.mapper.PeopleMapper
import com.example.testapp.data.network.PeopleApiClient
import com.example.testapp.data.vo.PeopleVo
import com.example.testapp.domain.repository.UserRepository
import io.reactivex.Single


class UserRemoteRepository : UserRepository {

    override fun getUser(): Single<List<PeopleVo>> {
        return PeopleApiClient.apiClient.getAllPeopleInfo().map { PeopleMapper.toValueObject(it) }
    }
}