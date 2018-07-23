package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di

import android.content.Context
import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineEntityDao
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineLocalRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AppDatabase
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirLineRemoteRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirLineRetrofitService
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class AirlineScope

@Module
class AirlineDataModule() {
    @AirlineScope
    @Provides
    fun providesRetrofitService(retrofit: Retrofit): AirLineRetrofitService {
        return retrofit.create(AirLineRetrofitService::class.java)
    }

    @AirlineScope
    @Provides
    fun providesRemote(airLineRetrofitService: AirLineRetrofitService): AirLineRemoteRepo {
        return AirLineRemoteRepo(airLineRetrofitService)
    }

    @AirlineScope
    @Provides
    fun providesAirlineEntityDao(context: Context): AirlineEntityDao {
        return AppDatabase.getInstance(context).airlineEntityDao()
    }

    @AirlineScope
    @Provides
    fun providesLocal(airlineEntityDao:AirlineEntityDao): AirlineLocalRepo {
        return AirlineLocalRepo(airlineEntityDao)
    }
}