package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di

import dagger.Module
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.scopes.AirlineScope
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirlineRemoteRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirLineRetrofitService
import retrofit2.Retrofit

@Module
class AirlineRemoteDataModule() {

    @AirlineScope
    @Provides
    fun providesRetrofitService(retrofit: Retrofit): AirLineRetrofitService {
        return retrofit.create(AirLineRetrofitService::class.java)
    }

    @AirlineScope
    @Provides
    fun providesRemote(airLineRetrofitService: AirLineRetrofitService): AirlineRemoteRepo {
        return AirlineRemoteRepo(airLineRetrofitService)
    }

}