package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.ViewModelKey
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.datasource.local.AirlineLocalDataSource
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.datasource.remote.AirlineRemoteDataSource
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repository.AirlineRepository
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.repository.AirlineRepositoryImpl
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.useCase.AirlineUseCase
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.domain.airline.useCase.AirlineUseCaseImpl
import javax.inject.Singleton


@Module(includes = arrayOf(ListAirlineViewModelModule::class))
abstract class ListAirlinesModule {
    @ContributesAndroidInjector(modules = [ListAirlinesActivityModule::class])
    abstract fun listAirlinesActivity(): ListAirlinesActivity
    @Binds
    @IntoMap
    @ViewModelKey(ListAirlineViewModel::class)
    abstract fun bindListAirlineViewModel(vm: ListAirlineViewModel): ViewModel
}

@Module
class ListAirlinesActivityModule{
}

@Module
class ListAirlineViewModelModule{
    @Singleton
    @Provides
    fun providesAirlineRepo(localDataSource : AirlineLocalDataSource, remoteDataSource : AirlineRemoteDataSource): AirlineRepository
            = AirlineRepositoryImpl(localDataSource,remoteDataSource)
    @Singleton
    @Provides
    fun providesAirlineUseCase(repo : AirlineRepository): AirlineUseCase = AirlineUseCaseImpl(repo)
}