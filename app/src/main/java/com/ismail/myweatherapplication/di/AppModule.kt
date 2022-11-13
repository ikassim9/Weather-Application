package com.ismail.myweatherapplication.di

import com.ismail.myweatherapplication.service.OpenWeatherMapApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
class AppModule {

    @Provides
    fun providesRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    }

    @Provides

    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    }


    @Provides

    fun providesOpenWeatherApi(retrofit: Retrofit): OpenWeatherMapApi {
        return retrofit.create(OpenWeatherMapApi::class.java)
    }
}