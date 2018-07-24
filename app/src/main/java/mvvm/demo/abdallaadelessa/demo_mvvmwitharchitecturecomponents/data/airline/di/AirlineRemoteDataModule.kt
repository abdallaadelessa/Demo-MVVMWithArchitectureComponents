package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di

import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.scopes.AirlineScope
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirlineRemoteRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirlineRetrofitService
import retrofit2.Retrofit

@Module
class AirlineRemoteDataModule() {
    @AirlineScope
    @Provides
    fun providesAirlineRemoteRepo(retrofit: Retrofit): AirlineRemoteRepo {
        return AirlineRemoteRepo(retrofit.create(AirlineRetrofitService::class.java))
    }
}