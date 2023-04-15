package xyz.myeoru.realtimesubwayinfo.data.datasource

import com.google.gson.Gson
import com.orhanobut.logger.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.json.JSONObject
import xyz.myeoru.realtimesubwayinfo.data.api.SeoulOpenApi
import xyz.myeoru.realtimesubwayinfo.domain.model.RealtimeArrivalModel
import xyz.myeoru.realtimesubwayinfo.domain.model.RealtimeSubwayPositionModel
import javax.inject.Inject

class SeoulOpenApiDataSourceImpl @Inject constructor(private val api: SeoulOpenApi) :
    SeoulOpenApiDataSource {
    override suspend fun getRealtimeStationArrivalInfo(
        apiKey: String,
        startPage: Int,
        endPage: Int,
        stationName: String
    ) = flow {
        val resp =
            api.getRealtimeStationArrivalInfo(apiKey, startPage, endPage, stationName).execute()

        if (!resp.isSuccessful) throw Throwable(resp.errorBody()?.string())

        try {
            val bodyString = resp.body()?.string() ?: ""
            val jsonData = JSONObject(bodyString)
            val hasData = jsonData.has("realtimeArrivalList")
            if (!hasData) throw Throwable(bodyString)

            val data = Gson().fromJson(bodyString, RealtimeArrivalModel::class.java)
                ?: throw Throwable("실시간 지하철 도착 정보를 받아올 수 없음")
            emit(data)
        } catch (e: Exception) {
            val msg = e.message.toString()
            Logger.e(msg)
            throw Throwable(msg)
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getRealtimeSubwayPositionInfo(
        apiKey: String,
        startPage: Int,
        endPage: Int,
        lineName: String
    ) = flow {
        val resp =
            api.getRealtimeSubwayPositionInfo(apiKey, startPage, endPage, lineName).execute()

        if (!resp.isSuccessful) throw Throwable(resp.errorBody()?.string())

        try {
            val bodyString = resp.body()?.string() ?: ""
            val jsonData = JSONObject(bodyString)
            val hasData = jsonData.has("realtimePositionList")
            if (!hasData) throw Throwable(bodyString)

            val data = Gson().fromJson(bodyString, RealtimeSubwayPositionModel::class.java)
                ?: throw Throwable("실시간 지하철 위치 정보를 받아올 수 없음")
            emit(data)
        } catch (e: Exception) {
            val msg = e.message.toString()
            Logger.e(msg)
            throw Throwable(msg)
        }
    }.flowOn(Dispatchers.IO)
}