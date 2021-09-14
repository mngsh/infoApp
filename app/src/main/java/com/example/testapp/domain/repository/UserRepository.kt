package com.example.testapp.domain.repository

import com.example.testapp.data.vo.PeopleVo
import io.reactivex.Single

interface UserRepository {

    fun getUser(): Single<List<PeopleVo>>
}