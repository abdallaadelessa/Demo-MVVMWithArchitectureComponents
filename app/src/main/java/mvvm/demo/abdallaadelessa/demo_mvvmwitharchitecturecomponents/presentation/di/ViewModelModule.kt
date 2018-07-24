package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.di.AirlineUseCaseModule
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.di.ViewModelFactory
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.di.ViewModelKey
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines.ListAirlineViewModel

@Module(includes = arrayOf(AirlineUseCaseModule::class))
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListAirlineViewModel::class)
    internal abstract fun listAirlineViewModel(viewModel: ListAirlineViewModel): ViewModel
}