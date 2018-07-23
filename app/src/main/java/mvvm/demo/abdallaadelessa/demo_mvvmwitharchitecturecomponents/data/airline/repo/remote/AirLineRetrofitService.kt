package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote

import io.reactivex.Observable
import io.reactivex.Single
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import retrofit2.http.GET

interface  AirLineRetrofitService
{
    @GET("airlines")
    fun listAirlines() : Single<List<AirlineModel>>
}