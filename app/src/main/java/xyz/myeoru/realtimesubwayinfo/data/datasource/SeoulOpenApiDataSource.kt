package xyz.myeoru.realtimesubwayinfo.data.datasource

import kotlinx.coroutines.flow.Flow
import xyz.myeoru.realtimesubwayinfo.domain.model.RealtimeArrivalModel
import xyz.myeoru.realtimesubwayinfo.domain.model.RealtimeSubwayPositionModel

interface SeoulOpenApiDataSource {
    suspend fun getRealtimeStationArrivalInfo(
        apiKey: String,
        startPage: Int,
        endPage: Int,
        stationName: String
    ): Flow<RealtimeArrivalModel>

    suspend fun getRealtimeSubwayPositionInfo(
        apiKey: String,
        startPage: Int,
        endPage: Int,
        lineName: String
    ): Flow<RealtimeSubwayPositionModel>
}