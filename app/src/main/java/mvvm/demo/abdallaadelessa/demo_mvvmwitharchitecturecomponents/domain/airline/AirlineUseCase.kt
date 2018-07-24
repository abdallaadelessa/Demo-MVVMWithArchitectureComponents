package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline

import io.reactivex.Observable
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.local.AirlineLocalRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repo.remote.AirlineRemoteRepo
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.model.DataResult
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AirlineUseCase @Inject constructor(private val remoteRepo : AirlineRemoteRepo, private val localRepo : AirlineLocalRepo) {

    fun listAirlines() : Observable<DataResult<List<AirlineModel>>> {

        val remoteSource = remoteRepo.listAirlines()
                .flatMapCompletable {  localRepo.saveAirlines(it) }
                .andThen(localRepo.listAirlines())
                .map{ DataResult.Success.Network(it) as DataResult<List<AirlineModel>> }
                .onErrorReturn { DataResult.Error.Network(it) }
                .toObservable()
                .debounce(300,TimeUnit.MILLISECONDS)

        val localSource = localRepo.listAirlines()
                .map{ DataResult.Success.Local(it) as DataResult<List<AirlineModel>> }
                .onErrorReturn { DataResult.Error.Local(it) }
                .toObservable()

        return Observable.concatArrayEager(localSource,remoteSource)
    }

}

