package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import retrofit2.adapter.rxjava2.Result.response
import timber.log.Timber


@Module
class NetModule(val baseUrl: String) {
    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideOkHttpInterceptor() : Interceptor = LoggingInterceptor()

    @Singleton
    @Provides
    fun provideOkhttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }
}

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain!!.request()

        val t1 = System.nanoTime()

        Timber.d("Sending request ${request.url()} ${chain.connection()} ${request.headers()}")

        val response = chain.proceed(request)

        val t2 = System.nanoTime()

        Timber.d("Received response for ${response.request().url()} ${(t2 - t1) / 1e6} ${response.headers()}")

        return response;
    }
}