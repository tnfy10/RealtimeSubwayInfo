package xyz.myeoru.realtimesubwayinfo.domain.model

import com.google.gson.annotations.SerializedName

data class RealtimeArrivalModel(
    @SerializedName("errorMessage")
    val resultMessage: SeoulSubwayOpenApiMessage,
    val realtimeArrivalList: List<RealtimeArrival>
)

/**
 * @param [subwayId] 지하철호선ID (1001:1호선, 1002:2호선, 1003:3호선, 1004:4호선, 1005:5호선 1006:6호선, 1007:7호선, 1008:8호선, 1009:9호선, 1061:중앙선1063:경의중앙선, 1065:공항철도, 1067:경춘선, 1075:수의분당선 1077:신분당선, 1092:우이신설선)
 * @param [updnLine] 상하행선구분 (0 : 상행/내선, 1 : 하행/외선)
 * @param [trainLineNm] 도착지방면 (성수행(목적지역) - 구로디지털단지방면(다음역))
 * @param [statnFid] 이전지하철역ID
 * @param [statnTid] 다음지하철역ID
 * @param [statnId] 지하철역ID
 * @param [statnNm] 지하철역명
 * @param [ordkey] 도착예정열차순번 (상하행코드(1자리), 순번(첫번째, 두번째 열차 , 1자리), 첫번째 도착예정 정류장 - 현재 정류장(3자리), 목적지 정류장, 급행여부(1자리))
 * @param [subwayList] 연계호선ID (1002, 1007 등 연계대상 호선ID)
 * @param [statnList] 연계지하철역ID (1002000233, 1007000000)
 * @param [btrainSttus] 열차종류 (급행,ITX)
 * @param [barvlDt] 열차도착예정시간 (단위:초)
 * @param [btrainNo] 열차번호 (현재운행하고 있는 호선별 열차번호)
 * @param [bstatnId] 종착지하철역ID
 * @param [bstatnNm] 종착지하철역명
 * @param [recptnDt] 열차도착정보를 생성한 시각
 * @param [arvlMsg2] 첫번째도착메세지 (도착, 출발 , 진입 등)
 * @param [arvlMsg3] 두번째도착메세지 (종합운동장 도착, 12분 후 (광명사거리) 등)
 * @param [arvlCd] 도착코드 (0:진입, 1:도착, 2:출발, 3:전역출발, 4:전역진입, 5:전역도착, 99:운행중)
 * @param [totalCount] 총 데이터 건수 (정상조회 시 출력됨)
 */
data class RealtimeArrival(
    val subwayId: String,
    val updnLine: String,
    val trainLineNm: String,
    val statnFid: String,
    val statnTid: String,
    val statnId: String,
    val statnNm: String,
    val ordkey: String,
    val subwayList: String,
    val statnList: String,
    val btrainSttus: Any,
    val barvlDt: String,
    val btrainNo: String,
    val bstatnId: String,
    val bstatnNm: String,
    val recptnDt: String,
    val arvlMsg2: String,
    val arvlMsg3: String,
    val arvlCd: String,
    val totalCount: Int
)