#!/usr/bin/env ruby

require 'erb'

def create_repository(name: String)
  template = <<-TEMPLATE
package me.mattak.dicomparation.domain.repository

import me.mattak.dicomparation.domain.entity.User

interface __NAME__ {
    fun findUser(name: String): User?
    fun addUsers(users: List<User>)
}

class __NAME__Impl : __NAME__ {
    private val _users = arrayListOf<User>()

    override fun findUser(name: String): User? {
        return _users.firstOrNull { it.name == name }
    }

    override fun addUsers(users: List<User>) {
        _users.addAll(users)
    }
}
    TEMPLATE

    return template.gsub(/__NAME__/, name)
end

def create_usecase(name: String, repository: String) 
  template = <<-TEMPLATE
package me.mattak.dicomparation.domain.usecase

import me.mattak.dicomparation.domain.repository.__REPOSITORY__

interface __NAME__ {
    fun execute(name: String): String
}

class __NAME__Impl constructor(
    private val repository: __REPOSITORY__
) : __NAME__ {
    override fun execute(name: String): String {
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello, '${it.name}' from $this" } ?: "User '$name' not found!"
    }
}
  TEMPLATE
  return template.gsub(/__NAME__/, name).gsub(/__REPOSITORY__/, repository)
end

def create_repository_module(repositories)
    template = <<-TEMPLATE
package me.mattak.dicomparation.di

import me.mattak.dicomparation.domain.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl() }
<% repositories.each do |repository| %>
    single<<%= repository %>> { <%= repository %>Impl() }
<% end %>
}
    TEMPLATE
    ERB.new(template).result(binding)
end

def create_usecase_module(usecases)
    template = <<-TEMPLATE
package me.mattak.dicomparation.di

import me.mattak.dicomparation.domain.usecase.*
import org.koin.dsl.module

val useCaseModule = module {
    single<HelloUseCase> { HelloUseCaseImpl(get()) }
<% usecases.each do |usecase| %>
    single<<%= usecase %>> { <%= usecase %>Impl(get()) }
<% end %>
}
    TEMPLATE
    ERB.new(template).result(binding)
end


# MAIN
# ----

if ARGV.size < 1
  puts "usage: #{$0} <generate_class_count>"
  exit 0
end

generateCount = ARGV[0].to_i

repositoryDirectory = "appkoin/src/main/java/me/mattak/dicomparation/domain/repository"
usecaseDirectory = "appkoin/src/main/java/me/mattak/dicomparation/domain/usecase"
diDirectory = "appkoin/src/main/java/me/mattak/dicomparation/di"
repositories = []
usecases = []

generateCount.times do |i|
  repositoryName = "Generated#{i.to_s.rjust(3, '0')}Repository"
  content = create_repository(name: repositoryName)
  File.write("#{repositoryDirectory}/#{repositoryName}.kt", content)
  repositories << repositoryName

  usecaseName = "Generated#{i.to_s.rjust(3, '0')}UseCase"
  content = create_usecase(name: usecaseName, repository: repositoryName)
  File.write("#{usecaseDirectory}/#{usecaseName}.kt", content)
  usecases << usecaseName
end

content = create_repository_module(repositories)
File.write("#{diDirectory}/RepositoryModule.kt", content)
content = create_usecase_module(usecases)
File.write("#{diDirectory}/UseCaseModule.kt", content)

