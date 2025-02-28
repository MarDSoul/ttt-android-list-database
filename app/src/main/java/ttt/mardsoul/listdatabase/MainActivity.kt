package ttt.mardsoul.listdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
                ItemListScreen()
            }
        }
    }
}