package xyz.myeoru.realtimesubwayinfo.data.datasource

import kotlinx.coroutines.flow.Flow
import xyz.myeoru.realtimesubwayinfo.domain.model.RealtimeArrivalModel

interface SeoulOpenApiDataSource {
    suspend fun getRealtimeStationArrivalInfo(
        apiKey: String,
        startPage: Int,
        endPage: Int,
        stationName: String
    ): Flow<RealtimeArrivalModel>
}