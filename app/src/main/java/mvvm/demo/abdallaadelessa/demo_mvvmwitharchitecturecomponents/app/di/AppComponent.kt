package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.application.MyApplication
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines.ListAirlinesActivityModule


@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    ActivityBindingModule::class,
    ViewModelFactoryBindingModule::class
])
interface AppComponent
{
    @Component.Builder
     interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun appModule(module:AppModule):Builder
        fun netModule(module:NetModule): Builder
        fun build(): AppComponent
    }
    fun inject(app: MyApplication)
}