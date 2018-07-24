package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.datasource.remote

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import retrofit2.Retrofit
import javax.inject.Inject

class AirlineRemoteDataSource @Inject constructor(retrofit: Retrofit) {

    val airlineRetrofitService : AirlineRetrofitService = retrofit.create(AirlineRetrofitService::class.java)

     fun listAirlines(): Single<List<AirlineModel>> {
       return airlineRetrofitService.listAirlines()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
    }
}

