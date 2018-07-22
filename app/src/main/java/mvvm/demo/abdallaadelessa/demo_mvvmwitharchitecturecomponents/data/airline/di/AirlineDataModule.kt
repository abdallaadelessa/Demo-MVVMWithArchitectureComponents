package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di

import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineLocalRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirLineRemoteRepo
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
    fun providesRemote(retrofit: Retrofit): AirLineRemoteRepo {
        return AirLineRemoteRepo(retrofit)
    }

    @AirlineScope
    @Provides
    fun providesLocal(): AirlineLocalRepo {
        return AirlineLocalRepo()
    }
}