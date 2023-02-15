package me.mattak.dicomparation.di

import dagger.Binds
import dagger.Module
import me.mattak.dicomparation.domain.repository.*

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}
