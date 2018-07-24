package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline

import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repository.AirlineRepository

class AirlineUseCaseImpl (private val airlineRepository : AirlineRepository) : AirlineUseCase {

    override fun listAirlines() = airlineRepository.listAirlines()
}
