package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.di

import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.datasource.local.AirlineLocalDataSource
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.datasource.remote.AirlineRemoteDataSource
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repository.AirlineRepository
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repository.AirlineRepositoryImpl
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.useCase.AirlineUseCase
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.useCase.AirlineUseCaseImpl
import javax.inject.Singleton


@Module
class AirlineUseCaseModule{
    @Singleton
    @Provides
    fun providesAirlineRepo(localDataSource : AirlineLocalDataSource, remoteDataSource : AirlineRemoteDataSource):AirlineRepository = AirlineRepositoryImpl(localDataSource,remoteDataSource)
    @Singleton
    @Provides
    fun providesAirlineUseCase(repo : AirlineRepository): AirlineUseCase = AirlineUseCaseImpl(repo)
}