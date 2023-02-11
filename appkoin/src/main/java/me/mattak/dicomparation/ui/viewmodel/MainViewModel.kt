package me.mattak.dicomparation.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.mattak.dicomparation.domain.usecase.HelloUseCase

class MainViewModel constructor(
    private val helloUseCase: HelloUseCase
) : ViewModel() {
    val message = MutableLiveData<String>()

    fun onCreate() {
        val text = helloUseCase.execute("DIComponent")
        this.message.value = text
    }
}
