package xyz.myeoru.realtimesubwayinfo.data.repository

import com.orhanobut.logger.Logger
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.conflate
import xyz.myeoru.realtimesubwayinfo.BuildConfig
import xyz.myeoru.realtimesubwayinfo.data.datasource.SeoulOpenApiDataSource
import xyz.myeoru.realtimesubwayinfo.domain.repository.SeoulOpenApiRepository
import javax.inject.Inject

class SeoulOpenApiRepositoryImpl @Inject constructor(private val seoulOpenApiDataSource: SeoulOpenApiDataSource) :
    SeoulOpenApiRepository {
    override suspend fun getRealtimeStationArrivalInfo(
        startPage: Int,
        endPage: Int,
        stationName: String
    ) = channelFlow {
        val apiKey = BuildConfig.SEOUL_REALTIME_SUBWAY_ARRIVAL_API_KEY
        seoulOpenApiDataSource.getRealtimeStationArrivalInfo(
            apiKey,
            startPage,
            endPage,
            stationName
        ).catch {
            Logger.e(it.message.toString())
            throw it
        }.conflate().collect {
            send(it.realtimeArrivalList)
        }
    }

    override suspend fun getRealtimeSubwayPositionInfo(
        startPage: Int,
        endPage: Int,
        lineName: String
    ) = channelFlow {
        val apiKey = BuildConfig.SEOUL_REALTIME_SUBWAY_ARRIVAL_API_KEY
        seoulOpenApiDataSource.getRealtimeSubwayPositionInfo(
            apiKey,
            startPage,
            endPage,
            lineName
        ).catch {
            Logger.e(it.message.toString())
            throw it
        }.conflate().collect {
            send(it.realtimePositionList)
        }
    }
}