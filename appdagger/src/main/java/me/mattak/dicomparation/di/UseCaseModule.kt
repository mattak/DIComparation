package me.mattak.dicomparation.di

import dagger.Binds
import dagger.Module
import me.mattak.dicomparation.domain.usecase.*

@Module
abstract class UseCaseModule {
    @Binds
    abstract fun bindHelloUseCase(impl: HelloUseCaseImpl): HelloUseCase

    @Binds
    abstract fun bindGenerated000UseCase(impl: Generated000UseCaseImpl): Generated000UseCase

    @Binds
    abstract fun bindGenerated001UseCase(impl: Generated001UseCaseImpl): Generated001UseCase

}
