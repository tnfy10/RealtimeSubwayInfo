package xyz.myeoru.realtimesubwayinfo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.conflate
import xyz.myeoru.realtimesubwayinfo.domain.model.RealtimeArrival
import xyz.myeoru.realtimesubwayinfo.domain.repository.SeoulOpenApiRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val seoulOpenApiRepository: SeoulOpenApiRepository) :
    ViewModel() {
    private val _state =
        MutableStateFlow<RealtimeSubwayArrivalState>(RealtimeSubwayArrivalState.Init)
    var state = _state.asStateFlow()

    suspend fun fetchRealtimeStationArrivalInfo(stationName: String) {
        _state.value = RealtimeSubwayArrivalState.Loading
        seoulOpenApiRepository.getRealtimeStationArrivalInfo(stationName = stationName).catch {
            _state.value = RealtimeSubwayArrivalState.Error(it)
        }.conflate().collect {
            _state.value = RealtimeSubwayArrivalState.Success(it)
        }
    }
}

sealed class RealtimeSubwayArrivalState {
    object Init : RealtimeSubwayArrivalState()
    object Loading : RealtimeSubwayArrivalState()
    data class Success(val data: List<RealtimeArrival>) : RealtimeSubwayArrivalState()
    data class Error(val error: Throwable) : RealtimeSubwayArrivalState()
}