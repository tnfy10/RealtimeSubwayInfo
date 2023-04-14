package xyz.myeoru.realtimesubwayinfo.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.realtimesubwayinfo.data.repository.SeoulOpenApiRepositoryImpl
import xyz.myeoru.realtimesubwayinfo.domain.repository.SeoulOpenApiRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindSeoulOpenApiRepository(seoulOpenApiRepositoryImpl: SeoulOpenApiRepositoryImpl): SeoulOpenApiRepository
}