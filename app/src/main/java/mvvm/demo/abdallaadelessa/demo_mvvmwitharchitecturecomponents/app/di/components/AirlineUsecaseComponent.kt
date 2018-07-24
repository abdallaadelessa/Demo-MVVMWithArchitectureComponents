package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.components

import dagger.Subcomponent
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.MainActivity
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