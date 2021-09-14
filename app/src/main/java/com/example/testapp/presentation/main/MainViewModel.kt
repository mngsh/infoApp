package com.example.testapp.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.data.vo.PeopleVo
import com.example.testapp.domain.usecase.GetPeopleUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val useCase: GetPeopleUseCase): ViewModel() {

    init {
        getPeopleList()
    }

    private fun getPeopleList() {
        useCase.getAllPeopleList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {

            })
    }


}