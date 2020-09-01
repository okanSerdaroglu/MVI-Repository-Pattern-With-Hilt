package com.okan.mvi_repository_pattern_with_hilt.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.okan.mvi_repository_pattern_with_hilt.repository.MainRepository


class MainViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: MainRepository
) : ViewModel()
{

}