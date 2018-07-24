package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.AppDatabase
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.model.AirlineEntity
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.model.AirlineModel
import javax.inject.Inject

class AirlineLocalRepo @Inject constructor(db: AppDatabase) {

    val  airlineEntityDao:AirlineEntityDao = db.airlineEntityDao()

    fun saveAirlines(airlines : List<AirlineModel>) : Completable{
        return Observable.fromIterable(airlines)
                .map { AirlineEntity(it.site, it.defaultName, it.logoURL, it.phone, it.usName, it.name, it.code) }
                .toList()
                .flatMapCompletable{ Completable.fromCallable{airlineEntityDao.insertAll(it)} }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

     fun listAirlines():  Single<List<AirlineModel>> {
       return airlineEntityDao.all.flattenAsObservable { it }
               .map{AirlineModel(it.site,it.defaultName,it.logoURL,it.phone,it.usName,it.name,it.code)}
               .toList()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
    }
}