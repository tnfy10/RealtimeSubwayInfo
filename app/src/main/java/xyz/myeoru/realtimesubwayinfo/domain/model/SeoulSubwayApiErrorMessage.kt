package xyz.myeoru.realtimesubwayinfo.domain.model

data class SeoulSubwayOpenApiMessage(
    val status: Int,
    val code: String,
    val message: String,
    val total: Int
)