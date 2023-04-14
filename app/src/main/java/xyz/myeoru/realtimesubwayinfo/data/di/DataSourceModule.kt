package xyz.myeoru.realtimesubwayinfo.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.realtimesubwayinfo.data.datasource.SeoulOpenApiDataSource
import xyz.myeoru.realtimesubwayinfo.data.datasource.SeoulOpenApiDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindSeoulOpenApiDataSource(seoulOpenApiDataSourceImpl: SeoulOpenApiDataSourceImpl): SeoulOpenApiDataSource
}