package com.rafaels.warhammertowbuilder.di

import com.rafaels.data.BuildConfig
import com.rafaels.data.RestClient
import com.rafaels.data.error.ErrorHandler
import com.rafaels.data.repository.MockRepositoryImpl
import com.rafaels.data.repository.UnitRepositoryImpl
import com.rafaels.domain.repository.UnitRepository
import com.rafaels.domain.usecase.GetUnit
import com.rafaels.warhammertowbuilder.ui.feature.elvenhonourlist.ElvenHonoursViewModel
import com.rafaels.warhammertowbuilder.ui.feature.home.HomeViewModel
import com.rafaels.warhammertowbuilder.ui.feature.unitItem.UnitItemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { UnitItemViewModel(get()) }
    viewModel { ElvenHonoursViewModel() }
}

val domainModule = module {
    single { GetUnit(get()) }
}

val dataModule = module {
    single<UnitRepository> {
        if (BuildConfig.IS_DEMO) MockRepositoryImpl(get())
        else UnitRepositoryImpl(get(), get())
    }
    single { RestClient.getUnitApi() }
    single { ErrorHandler() }
}