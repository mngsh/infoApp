package com.example.testapp.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.data.vo.PeopleVo
import com.example.testapp.domain.usecase.GetPeopleUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainViewModel(private val useCase: GetPeopleUseCase): ViewModel() {

    private lateinit var disposable: CompositeDisposable

    val peopleListLiveData = MutableLiveData<List<PeopleVo>>()
    val errorLiveData= MutableLiveData<String>()

    init {
        getPeopleList()
    }

    private fun getPeopleList() {
        disposable.addAll(useCase.getAllPeopleList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ people ->
                peopleListLiveData.postValue(people.toList())
            }, { error ->
                errorLiveData.postValue(error.message)
            }))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

}