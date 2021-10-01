package com.simplemobiletools.dialer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.simplemobiletools.dialer.services.TrueCallerService

class MainViewModelFactory(private val trueCallerService: TrueCallerService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(trueCallerService) as T
    }
}
