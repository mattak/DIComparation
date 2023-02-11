#!/bin/bash

find apphilt/src/main/java -type f -name 'Generated*.kt' | xargs rm
find appkoin/src/main/java -type f -name 'Generated*.kt' | xargs rm
cp KoinUseCaseModule.kt appkoin/src/main/java/me/mattak/dicomparation/di/UseCaseModule.kt
cp KoinRepositoryModule.kt appkoin/src/main/java/me/mattak/dicomparation/di/RepositoryModule.kt
cp HiltRepositoryModule.kt apphilt/src/main/java/me/mattak/dicomparation/di/RepositoryModule.kt
cp HiltUseCaseModule.kt apphilt/src/main/java/me/mattak/dicomparation/di/UseCaseModule.kt
