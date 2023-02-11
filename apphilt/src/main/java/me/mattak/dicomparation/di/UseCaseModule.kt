package me.mattak.dicomparation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import me.mattak.dicomparation.domain.usecase.*

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindHelloUseCase(impl: HelloUseCaseImpl): HelloUseCase
}
