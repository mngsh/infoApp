package com.example.testapp.data.mapper

import com.example.testapp.data.dto.PeopleDto
import com.example.testapp.data.dto.UsersDto
import com.example.testapp.data.vo.PeopleVo

object PeopleMapper {

    fun toValueObject(dto: UsersDto): List<PeopleVo> {
        return dto.people.map { toValueObject(it) }
    }

    private fun toValueObject(dto: PeopleDto): PeopleVo {
        return PeopleVo(
            id = dto.id,
            firstName = dto.firstName,
            lastName = dto.lastName,
            email = dto.email,
            avatar = dto.avatar
        )
    }
}