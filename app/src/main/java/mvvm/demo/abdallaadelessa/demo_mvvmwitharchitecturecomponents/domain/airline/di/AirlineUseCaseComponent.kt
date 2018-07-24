package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.di

import dagger.Subcomponent
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines.ListAirlineViewModel

@AirlineScope
@Subcomponent(modules = arrayOf(AirlineUseCaseModule::class))
interface AirlineUseCaseComponent {
    fun inject(viewModel: ListAirlineViewModel)

    @Subcomponent.Builder
     interface Builder {
        fun build(): AirlineUseCaseComponent
    }
}