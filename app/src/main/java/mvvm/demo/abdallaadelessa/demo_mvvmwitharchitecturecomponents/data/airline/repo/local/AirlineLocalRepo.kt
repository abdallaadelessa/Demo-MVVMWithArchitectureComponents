package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel

class AirlineLocalRepo(val dao:AirlineEntityDao) {
    fun saveAirlines(airlines : List<AirlineModel>) : Completable{
        return Observable.fromIterable(airlines)
                .map { AirlineEntity(it.site,it.defaultName,it.logoURL,it.phone,it.usName,it.name,it.code) }
                .toList()
                .flatMapCompletable{ Completable.fromCallable{dao.insertAll(it)} }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

     fun listAirlines():  Single<List<AirlineModel>> {
       return dao.all.flattenAsObservable { it }
               .map{AirlineModel(it.site,it.defaultName,it.logoURL,it.phone,it.usName,it.name,it.code)}
               .toList()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
    }
}