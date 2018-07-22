package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation

import dagger.Component
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di.AirlineDataModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.AirlineUseCase
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.di.AirlineUseCaseModule
import javax.inject.Singleton
import dagger.Subcomponent
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.di.AirlineScope
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope


@AirlineScope
@Subcomponent(modules = arrayOf(AirlineUseCaseModule::class,AirlineDataModule::class))
interface AirlineUsecaseComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
     interface Builder {
        fun airlineUseCaseModule(module: AirlineUseCaseModule): Builder
        fun airlineDataModule(module: AirlineDataModule): Builder
        fun build(): AirlineUsecaseComponent
    }
}