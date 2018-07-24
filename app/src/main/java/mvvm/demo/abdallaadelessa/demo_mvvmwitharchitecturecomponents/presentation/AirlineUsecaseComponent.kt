package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation

import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class AirlineScope

@AirlineScope
@Subcomponent
interface AirlineUsecaseComponent {
    fun inject(mainActivity: MainActivity)
    @Subcomponent.Builder
     interface Builder {
        fun build(): AirlineUsecaseComponent
    }
}