package me.mattak.dicomparation.di

import me.mattak.dicomparation.domain.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl() }
}
