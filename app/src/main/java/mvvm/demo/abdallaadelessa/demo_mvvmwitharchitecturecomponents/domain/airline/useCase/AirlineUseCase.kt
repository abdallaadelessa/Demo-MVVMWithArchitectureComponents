package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.useCase

import io.reactivex.Observable
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.common.model.DataResult

interface AirlineUseCase{
    fun listAirlines(): Observable<DataResult<List<AirlineModel>>>
}


