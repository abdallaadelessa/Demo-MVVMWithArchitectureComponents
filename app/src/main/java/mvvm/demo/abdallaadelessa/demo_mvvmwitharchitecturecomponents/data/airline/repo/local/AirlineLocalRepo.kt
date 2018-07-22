package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.common.model.Page
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel

class AirlineLocalRepo {
    fun saveAirlines(airlines : List<AirlineModel>) : Completable{
        return Completable.complete()
    }

     fun listAirlines():  Observable<List<AirlineModel>> {
       return Observable.just(ArrayList<AirlineModel>())
    }
}