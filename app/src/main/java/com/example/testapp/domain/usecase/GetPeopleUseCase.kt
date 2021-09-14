package com.example.testapp.domain.usecase

import com.example.testapp.data.vo.PeopleVo
import com.example.testapp.domain.repository.UserRepository
import io.reactivex.Single

class GetPeopleUseCase(private val repository: UserRepository) {

    fun getAllPeopleList(): Single<List<PeopleVo>>{
        return repository.getUser()
    }
}