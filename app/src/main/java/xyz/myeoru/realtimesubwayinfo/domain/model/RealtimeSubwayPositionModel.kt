package xyz.myeoru.realtimesubwayinfo.domain.model

import com.google.gson.annotations.SerializedName

data class RealtimeSubwayPositionModel(
    @SerializedName("errorMessage")
    val resultMessage: SeoulSubwayOpenApiMessage,
    val realtimePositionList: List<RealtimePosition>
)

/**
 * @param [subwayId] 지하철호선ID (1001:1호선, 1002:2호선, 1003:3호선, 1004:4호선, 1005:5호선 1006:6호선, 1007:7호선, 1008:8호선, 1009:9호선, 1061:중앙선1063:경의중앙선, 1065:공항철도, 1067:경춘선, 1075:수의분당선 1077:신분당선, 1092:우이신설선)
 * @param [subwayNm] 지하철호선명
 * @param [statnId] 지하철역ID
 * @param [statnNm] 지하철역명
 * @param [trainNo] 열차번호
 * @param [lastRecptnDt] 최종수신날짜
 * @param [recptnDt] 최종수신시간
 * @param [updnLine] 상하행선구분 (0 : 상행/내선, 1 : 하행/외선)
 * @param [statnTid] 종착지하철역ID
 * @param [statnTnm] 종착지하철역명
 * @param [trainSttus] 열차상태구분 (0:진입 1:도착, 2:출발, 3:전역출발)
 * @param [directAt] 급행여부 (1:급행, 0:아님)
 * @param [lstcarAt] 막차여부 (1:막차, 0:아님)
 * @param [totalCount] 총 데이터 건수 (정상조회 시 출력됨)
 */
data class RealtimePosition(
    val subwayId: String,
    val subwayNm: String,
    val statnId: String,
    val statnNm: String,
    val trainNo: String,
    val lastRecptnDt: String,
    val recptnDt: String,
    val updnLine: String,
    val statnTid: String,
    val statnTnm: String,
    val trainSttus: String,
    val directAt: String,
    val lstcarAt: String,
    val totalCount: Int
)