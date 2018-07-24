package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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