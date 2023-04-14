package xyz.myeoru.realtimesubwayinfo.data

import com.google.gson.GsonBuilder
import com.orhanobut.logger.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.myeoru.realtimesubwayinfo.BuildConfig

object ApiHelper {
    private const val OK_HTTP_TAG = "OkHttpClient"
    private val gson = GsonBuilder().setLenient().create()

    private fun createOkHttpClient() = OkHttpClient.Builder().apply {
        addInterceptor(loggingInterceptor())
    }.build()

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            try {
                JSONObject(message) // json check
                Logger.t(OK_HTTP_TAG).json(message)
            } catch (e: JSONException) {
                Logger.t(OK_HTTP_TAG).i(message)
            }
        }
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.BASIC
        }

        return loggingInterceptor
    }

    fun <T> create(
        api: Class<T>,
        baseUrl: String
    ): T = Retrofit.Builder().apply {
        baseUrl(baseUrl)
        addConverterFactory(GsonConverterFactory.create(gson))
        client(createOkHttpClient())
    }.build().create(api)
}