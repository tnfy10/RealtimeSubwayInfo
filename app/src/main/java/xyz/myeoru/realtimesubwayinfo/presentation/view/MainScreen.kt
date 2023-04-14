package xyz.myeoru.realtimesubwayinfo.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import xyz.myeoru.realtimesubwayinfo.presentation.ui.theme.RealtimeSubwayInfoTheme
import xyz.myeoru.realtimesubwayinfo.presentation.viewmodel.MainViewModel
import xyz.myeoru.realtimesubwayinfo.presentation.viewmodel.RealtimeSubwayArrivalState

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsStateWithLifecycle().value
    val scope = rememberCoroutineScope()

    MainScreenContent(
        state = state,
        onClickSearchBtn = {
            scope.launch {
                viewModel.fetchRealtimeStationArrivalInfo(it)
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenContent(
    state: RealtimeSubwayArrivalState,
    onClickSearchBtn: (value: String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("역이름") }
        )
        Box(modifier = Modifier.height(4.dp))
        Button(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            onClick = {
                onClickSearchBtn(searchText)
            }) {
            Text("검색")
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            when (state) {
                is RealtimeSubwayArrivalState.Init -> {}
                is RealtimeSubwayArrivalState.Error -> {
                    Text(text = state.error.message.toString())
                }

                is RealtimeSubwayArrivalState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                is RealtimeSubwayArrivalState.Success -> {
                    Text(text = state.data.toString())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    RealtimeSubwayInfoTheme {
        MainScreenContent(
            state = RealtimeSubwayArrivalState.Init,
            onClickSearchBtn = {}
        )
    }
}