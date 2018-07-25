package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.application.MyApplication


@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    ViewModelFactoryBindingModule::class,
    FeaturesModule::class
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