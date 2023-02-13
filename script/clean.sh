#!/bin/bash

find apphilt/src/main/java -type f -name 'Generated*.kt' | xargs rm
find appkoin/src/main/java -type f -name 'Generated*.kt' | xargs rm
cp KoinUseCaseModule.kt appkoin/src/main/java/me/mattak/dicomparation/di/UseCaseModule.kt
cp KoinRepositoryModule.kt appkoin/src/main/java/me/mattak/dicomparation/di/RepositoryModule.kt
cp HiltRepositoryModule.kt apphilt/src/main/java/me/mattak/dicomparation/di/RepositoryModule.kt
cp HiltUseCaseModule.kt apphilt/src/main/java/me/mattak/dicomparation/di/UseCaseModule.kt

find appdbinding/src/main/java -type f -name 'Generated*.kt' | xargs rm
find appdbinding/src/main/res/layout -type f -name 'generated_*.xml' | xargs rm
find appvbinding/src/main/java -type f -name 'Generated*.kt' | xargs rm
find appvbinding/src/main/res/layout -type f -name 'generated_*.xml' | xargs rm
find appcompose/src/main/java -type f -name 'Generated*.kt' | xargs rm
