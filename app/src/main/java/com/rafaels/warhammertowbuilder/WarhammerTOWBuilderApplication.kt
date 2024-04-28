package com.rafaels.warhammertowbuilder

import android.app.Application
import com.rafaels.warhammertowbuilder.di.dataModule
import com.rafaels.warhammertowbuilder.di.domainModule
import com.rafaels.warhammertowbuilder.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WarhammerTOWBuilderApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@WarhammerTOWBuilderApplication)
            modules(
                viewModelModule,
                domainModule,
                dataModule
            )
        }
    }
}