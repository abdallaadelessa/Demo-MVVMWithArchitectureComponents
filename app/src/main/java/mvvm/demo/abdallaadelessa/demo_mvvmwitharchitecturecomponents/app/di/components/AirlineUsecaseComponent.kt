package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.components

import dagger.Subcomponent
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.scopes.AirlineScope
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.MainActivity

@AirlineScope
@Subcomponent
interface AirlineUsecaseComponent {
    fun inject(mainActivity: MainActivity)
    @Subcomponent.Builder
     interface Builder {
        fun build(): AirlineUsecaseComponent
    }
}