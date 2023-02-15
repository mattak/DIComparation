package me.mattak.dicomparation.di

import me.mattak.dicomparation.domain.usecase.*
import org.koin.dsl.module

val useCaseModule = module {
    single<HelloUseCase> { HelloUseCaseImpl(get()) }
}
