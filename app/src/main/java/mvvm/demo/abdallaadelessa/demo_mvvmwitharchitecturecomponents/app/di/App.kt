package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import dagger.Component
import dagger.Module
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.MyApplication
import dagger.Provides
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.AirlineUsecaseComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class,NetModule::class))
interface AppComponent
{
    fun getAppContext():Context
    fun getAppExecutorService():ExecutorService
    fun AirlineUsecaseBuilder(): AirlineUsecaseComponent.Builder
}

@Module
class AppModule(val app : MyApplication)
{
    @Singleton
    @Provides
    fun provideAppContext():Context= app.applicationContext

    @Singleton
    @Provides
    fun provideAppExecutorService(): ExecutorService {
        return Executors.newFixedThreadPool(10)
    }
}

@Module
class NetModule(val baseUrl : String){
    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()
    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient = OkHttpClient.Builder().build()
    @Singleton
    @Provides
    fun provideRetrofit(gson : Gson, okHttpClient : OkHttpClient): Retrofit
    {
        return  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }
}