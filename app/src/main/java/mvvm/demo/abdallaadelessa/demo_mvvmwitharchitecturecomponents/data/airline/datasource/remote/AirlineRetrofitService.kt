package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.datasource.remote

import io.reactivex.Single
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import retrofit2.http.GET

interface  AirlineRetrofitService
{
    @GET("airlines")
    fun listAirlines() : Single<List<AirlineModel>>
}