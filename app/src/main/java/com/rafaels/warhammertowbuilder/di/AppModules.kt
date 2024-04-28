package com.rafaels.warhammertowbuilder.di

import com.rafaels.data.repository.UnitRepositoryImpl
import com.rafaels.domain.UnitRepository
import com.rafaels.domain.usecase.GetUnit
import com.rafaels.warhammertowbuilder.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val domainModule = module {
    single { GetUnit(get()) }
}

val dataModule = module {
    single<UnitRepository> { UnitRepositoryImpl(
        //get()
    ) }
}