package xyz.myeoru.realtimesubwayinfo.domain.repository

import kotlinx.coroutines.flow.Flow
import xyz.myeoru.realtimesubwayinfo.domain.model.RealtimeArrival

interface SeoulOpenApiRepository {
    suspend fun getRealtimeStationArrivalInfo(
        startPage: Int,
        endPage: Int,
        stationName: String
    ): Flow<List<RealtimeArrival>>
}