package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.common.model.Page
import retrofit2.Retrofit
import retrofit2.http.GET

class AirLineRemoteRepo (private val retrofit : Retrofit) {
     fun listAirlines(): Observable<List<AirlineModel>> {
       return retrofit.create(AirLineRetrofitService::class.java).listAirlines()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
    }
}

interface  AirLineRetrofitService
{
    @GET("airlines")
    fun listAirlines() : Observable<List<AirlineModel>>
}