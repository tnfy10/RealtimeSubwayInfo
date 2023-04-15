package xyz.myeoru.realtimesubwayinfo.data.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SeoulOpenApi {
    @GET("/api/subway/{key}/json/realtimeStationArrival/{startPage}/{endPage}/{stationName}")
    fun getRealtimeStationArrivalInfo(
        @Path("key") apiKey: String,
        @Path("startPage") startPage: Int,
        @Path("endPage") endPage: Int,
        @Path("stationName") stationName: String
    ): Call<ResponseBody>

    @GET("/api/subway/{key}/json/realtimePosition/{startPage}/{endPage}/{lineName}")
    fun getRealtimeSubwayPositionInfo(
        @Path("key") apiKey: String,
        @Path("startPage") startPage: Int,
        @Path("endPage") endPage: Int,
        @Path("lineName") lineName: String
    ): Call<ResponseBody>
}