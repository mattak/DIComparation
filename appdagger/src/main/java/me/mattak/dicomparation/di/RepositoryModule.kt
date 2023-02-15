package me.mattak.dicomparation.di

import dagger.Binds
import dagger.Module
import me.mattak.dicomparation.domain.repository.*

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindGenerated000Repository(impl: Generated000RepositoryImpl): Generated000Repository

    @Binds
    abstract fun bindGenerated001Repository(impl: Generated001RepositoryImpl): Generated001Repository

}
