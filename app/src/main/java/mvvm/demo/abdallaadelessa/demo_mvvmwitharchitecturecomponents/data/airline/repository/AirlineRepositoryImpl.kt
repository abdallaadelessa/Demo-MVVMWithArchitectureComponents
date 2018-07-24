package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repository

import io.reactivex.Observable
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.datasource.local.AirlineLocalDataSource
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.datasource.remote.AirlineRemoteDataSource
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.common.model.DataResult
import java.util.concurrent.TimeUnit

class AirlineRepositoryImpl(private val localDataSource : AirlineLocalDataSource,private val remoteDataSource : AirlineRemoteDataSource):AirlineRepository {

    override fun listAirlines(): Observable<DataResult<List<AirlineModel>>> {

        val remoteSource = remoteDataSource.listAirlines()
                .flatMapCompletable { localDataSource.saveAirlines(it) }
                .andThen(localDataSource.listAirlines())
                .map { DataResult.Success.Network(it) as DataResult<List<AirlineModel>> }
                .onErrorReturn { DataResult.Error.Network(it) }
                .toObservable()
                .debounce(300, TimeUnit.MILLISECONDS)

        val localSource = localDataSource.listAirlines()
                .map { DataResult.Success.Local(it) as DataResult<List<AirlineModel>> }
                .onErrorReturn { DataResult.Error.Local(it) }
                .toObservable()

        return Observable.concatArrayEager(localSource, remoteSource)
    }
}