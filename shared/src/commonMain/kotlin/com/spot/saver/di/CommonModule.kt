package com.spot.saver.di

import com.spot.saver.data.repo.spot.SpotsRepo
import com.spot.saver.data.repo.spot.SpotsRepoImpl
import com.spot.saver.domain.FetchSavedSpotsUseCase
import com.spot.saver.view.viewmodel.HomePageViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
    appDeclaration()
    modules(
        viewModelModule,
        domainModule,
        repositoryModule
    )
}

private val viewModelModule = module {
    single { HomePageViewModel() }
}

private val domainModule = module {
    factory { FetchSavedSpotsUseCase(get()) }
}

private val repositoryModule = module {
    single<SpotsRepo> { SpotsRepoImpl() }
}