package xyz.myeoru.realtimesubwayinfo.domain.repository

import kotlinx.coroutines.flow.Flow
import xyz.myeoru.realtimesubwayinfo.domain.model.RealtimeArrival
import xyz.myeoru.realtimesubwayinfo.domain.model.RealtimePosition

interface SeoulOpenApiRepository {
    suspend fun getRealtimeStationArrivalInfo(
        startPage: Int = 0,
        endPage: Int = 999,
        stationName: String
    ): Flow<List<RealtimeArrival>>

    suspend fun getRealtimeSubwayPositionInfo(
        startPage: Int = 0,
        endPage: Int = 999,
        lineName: String
    ): Flow<List<RealtimePosition>>
}