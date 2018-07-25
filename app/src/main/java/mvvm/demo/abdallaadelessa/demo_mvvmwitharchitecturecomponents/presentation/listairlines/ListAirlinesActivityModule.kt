package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.ViewModelKey
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.di.AirlineUseCaseModule


@Module(includes = arrayOf(AirlineUseCaseModule::class))
abstract class ListAirlinesActivityModule {
    @ContributesAndroidInjector
    abstract fun listAirlinesActivity(): ListAirlinesActivity
    @Binds
    @IntoMap
    @ViewModelKey(ListAirlineViewModel::class)
    abstract fun bindListAirlineViewModel(vm: ListAirlineViewModel): ViewModel
}