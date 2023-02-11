package me.mattak.dicomparation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import me.mattak.dicomparation.domain.usecase.HelloUseCase
import me.mattak.dicomparation.domain.usecase.HelloUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindHelloUseCase(impl: HelloUseCaseImpl): HelloUseCase
}
