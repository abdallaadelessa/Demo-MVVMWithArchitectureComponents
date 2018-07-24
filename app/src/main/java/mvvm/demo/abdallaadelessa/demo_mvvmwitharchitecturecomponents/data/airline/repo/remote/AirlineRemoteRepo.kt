package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel

class AirlineRemoteRepo (private val service : AirlineRetrofitService) {
     fun listAirlines(): Single<List<AirlineModel>> {
       return service.listAirlines()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
    }
}

