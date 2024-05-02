package com.rafaels.warhammertowbuilder.di

import com.rafaels.data.BuildConfig
import com.rafaels.data.RestClient
import com.rafaels.data.error.ErrorHandler
import com.rafaels.data.repository.MockRepositoryImpl
import com.rafaels.data.repository.UnitRepositoryImpl
import com.rafaels.domain.repository.UnitRepository
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
    single<UnitRepository> {
        if(BuildConfig.IS_DEMO) MockRepositoryImpl(get())
        else UnitRepositoryImpl(get(), get())
    }
    single { RestClient.getUnitApi() }
    single { ErrorHandler() }
}