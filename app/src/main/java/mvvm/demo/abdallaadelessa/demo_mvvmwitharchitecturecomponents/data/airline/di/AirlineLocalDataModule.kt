package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di

import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.AppDatabase
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.scopes.AirlineScope
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineEntityDao
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineLocalRepo

@Module
class AirlineLocalDataModule() {

    @AirlineScope
    @Provides
    fun providesAirlineEntityDao(db: AppDatabase): AirlineEntityDao {
        return db.airlineEntityDao()
    }

    @AirlineScope
    @Provides
    fun providesAirlineLocalRepo(airlineEntityDao: AirlineEntityDao): AirlineLocalRepo {
        return AirlineLocalRepo(airlineEntityDao)
    }

}