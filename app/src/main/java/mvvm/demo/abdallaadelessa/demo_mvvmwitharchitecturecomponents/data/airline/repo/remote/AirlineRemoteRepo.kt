package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.common.model.Page
import retrofit2.Retrofit
import retrofit2.http.GET

class AirlineRemoteRepo (private val service : AirLineRetrofitService) {
     fun listAirlines(): Single<List<AirlineModel>> {
       return service.listAirlines()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
    }
}

