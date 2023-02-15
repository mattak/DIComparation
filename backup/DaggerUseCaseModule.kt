package me.mattak.dicomparation.di

import dagger.Binds
import dagger.Module
import me.mattak.dicomparation.domain.usecase.*

@Module
abstract class UseCaseModule {
    @Binds
    abstract fun bindHelloUseCase(impl: HelloUseCaseImpl): HelloUseCase
}
