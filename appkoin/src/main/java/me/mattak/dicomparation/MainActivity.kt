package me.mattak.dicomparation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.mattak.dicomparation.ui.theme.DIComparationTheme
import me.mattak.dicomparation.ui.viewmodel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DIComparationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", viewModel)
                }
            }
        }
        PerformanceMeasure.end("LAUNCH")
    }
}

@Composable
fun Greeting(
    name: String,
    viewModel: MainViewModel,
) {
    val state = viewModel.message.observeAsState()
    state.value?.let {
        Text(text = "Hello $name!")
    } ?: run {
        Text(text = "Not initialized")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DIComparationTheme {
        Text("Android")
    }
}