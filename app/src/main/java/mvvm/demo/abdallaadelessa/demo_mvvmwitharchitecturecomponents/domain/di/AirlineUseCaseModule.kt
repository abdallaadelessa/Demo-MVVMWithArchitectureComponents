package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.di

import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di.AirlineDataModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di.AirlineScope
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineLocalRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirLineRemoteRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.AirlineUseCase
import javax.inject.Singleton

@Module
class AirlineUseCaseModule {
    @AirlineScope
    @Provides
    fun provideAirlineUseCase(remoteRepo: AirLineRemoteRepo, localRepo: AirlineLocalRepo): AirlineUseCase {
        return AirlineUseCase(remoteRepo, localRepo)
    }
}