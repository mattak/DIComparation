package me.mattak.dicomparation.di

import me.mattak.dicomparation.domain.usecase.HelloUseCase
import me.mattak.dicomparation.domain.usecase.HelloUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<HelloUseCase> { HelloUseCaseImpl(get()) }
}