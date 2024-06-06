package com.jemutai.equityinsuranceapplication.screens.main


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ExitToApp
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jemutai.equityinsuranceapplication.data.BottomNavigation

val items = listOf(

    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomNavigation(
        title = " My Policies",
        icon = Icons.AutoMirrored.Rounded.List
    ),

    BottomNavigation(
        title = "Sign Out",
        icon = Icons.AutoMirrored.Rounded.ExitToApp
    )

)



@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.onBackground)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = {
//                        val navController = rememberNavController()
//                        when (item.title) {
//                            "Home" -> navController.navigate("NewHome")
//                            "Policies" -> navController.navigate("policies")
//                            "Claims" -> navController.navigate("claims")
//                            "Log out" -> {
//                        // Handle logout action
//                         //This could be navigating to a login screen or clearing user data
//                    }
//                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = {
                                Text(text = item.title, color = MaterialTheme.colorScheme.onPrimary)
                                Text(
                                    text = item.title,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                )



//
//                        NavigationBarItem(
//                            selected = index == 0,
//                            onClick = {},
//                            icon = {
//                                Icon(
//                                    imageVector = item.icon, contentDescription = item.title,
//                                    tint = MaterialTheme.colorScheme.onPrimary
//                                )
//                            },
//                            label = {
//                                Text(text = item.title, color = MaterialTheme.colorScheme.onPrimary)
//                                Text(
//                                    text = item.title,
//                                    color = MaterialTheme.colorScheme.onPrimary
//                                )
//                            }
//                        )

                    }


            }
        }
    }


