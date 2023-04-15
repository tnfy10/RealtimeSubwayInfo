package xyz.myeoru.realtimesubwayinfo.domain.model

data class SeoulSubwayApiErrorMessage(
    val code: String,
    val developerMessage: String,
    val link: String,
    val message: String,
    val status: Int,
    val total: Int
)
