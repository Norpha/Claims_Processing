package com.jemutai.equityinsuranceapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jemutai.equityinsuranceapplication.screens.main.BottomNavigationBar
import com.jemutai.equityinsuranceapplication.screens.main.ClaimsSection
import com.jemutai.equityinsuranceapplication.screens.main.Policies
import com.jemutai.equityinsuranceapplication.screens.main.TopNavigationBar
import com.jemutai.equityinsuranceapplication.ui.theme.EquityInsuranceApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EquityInsuranceApplicationTheme {
                SetBarColor(color = MaterialTheme.colorScheme.background)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNav(navController)
                }
            }
        }
    }

}

@Composable
private fun SetBarColor(color: Color) {


}

@Composable

fun HomeScreen(oyaaa: NavHostController) {
    Scaffold(
        bottomBar = {
           BottomNavigationBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            TopNavigationBar()
            Spacer(modifier = Modifier.height(16.dp))
            Policies(oyaaa)
            Spacer(modifier = Modifier.height(16.dp))
            ClaimsSection(oyaaa)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


