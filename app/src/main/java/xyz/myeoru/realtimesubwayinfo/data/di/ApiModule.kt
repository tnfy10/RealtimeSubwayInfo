package xyz.myeoru.realtimesubwayinfo.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.realtimesubwayinfo.data.ApiHelper
import xyz.myeoru.realtimesubwayinfo.data.api.SeoulOpenApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideSeoulOpenApi() =
        ApiHelper.create(SeoulOpenApi::class.java, "http://swopenAPI.seoul.go.kr")
}