package xyz.myeoru.realtimesubwayinfo.domain.model

data class RealtimeArrivalModel(
    val errorMessage: ErrorMessage,
    val realtimeArrivalList: List<RealtimeArrival>
)

data class ErrorMessage(
    val code: String,
    val developerMessage: String,
    val link: String,
    val message: String,
    val status: Int,
    val total: Int
)

data class RealtimeArrival(
    val arvlCd: String,
    val arvlMsg2: String,
    val arvlMsg3: String,
    val barvlDt: String,
    val beginRow: Any,
    val bstatnId: String,
    val bstatnNm: String,
    val btrainNo: String,
    val btrainSttus: Any,
    val curPage: Any,
    val endRow: Any,
    val ordkey: String,
    val pageRow: Any,
    val recptnDt: String,
    val rowNum: Int,
    val selectedCount: Int,
    val statnFid: String,
    val statnId: String,
    val statnList: String,
    val statnNm: String,
    val statnTid: String,
    val subwayHeading: Any,
    val subwayId: String,
    val subwayList: String,
    val subwayNm: Any,
    val totalCount: Int,
    val trainCo: Any,
    val trainLineNm: String,
    val updnLine: String
)