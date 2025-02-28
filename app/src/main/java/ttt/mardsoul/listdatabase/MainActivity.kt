package ttt.mardsoul.listdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ttt.mardsoul.listdatabase.ui.ItemListScreen
import ttt.mardsoul.listdatabase.ui.theme.IPTestTaskTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IPTestTaskTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ItemListScreen()
                }
            }
        }
    }
}