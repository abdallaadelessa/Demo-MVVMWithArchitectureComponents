package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.di

import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.scopes.AirlineScope
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di.AirlineLocalDataModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di.AirlineRemoteDataModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineLocalRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirlineRemoteRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.AirlineUseCase

@Module(includes = arrayOf(AirlineLocalDataModule::class, AirlineRemoteDataModule::class))
class AirlineUseCaseModule {
    @AirlineScope
    @Provides
    fun provideAirlineUseCase(remoteRepo: AirlineRemoteRepo, localRepo: AirlineLocalRepo): AirlineUseCase {
        return AirlineUseCase(remoteRepo, localRepo)
    }
}