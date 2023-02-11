package me.mattak.dicomparation.di

import me.mattak.dicomparation.domain.repository.UserRepository
import me.mattak.dicomparation.domain.repository.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl() }
}