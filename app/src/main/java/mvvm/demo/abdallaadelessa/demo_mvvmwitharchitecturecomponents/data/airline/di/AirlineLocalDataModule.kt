package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di

import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.AppDatabase
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.scopes.AirlineScope
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineEntityDao
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineLocalRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirlineRemoteRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.AirlineUseCase

@Module
class AirlineLocalDataModule() {
    @AirlineScope
    @Provides
    fun providesAirlineLocalRepo(db: AppDatabase): AirlineLocalRepo {
        return AirlineLocalRepo(db.airlineEntityDao())
    }
}