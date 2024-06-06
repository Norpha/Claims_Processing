package com.jemutai.equityinsuranceapplication


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jemutai.equityinsuranceapplication.data.ClaimObject

import com.jemutai.equityinsuranceapplication.data.Home
import com.jemutai.equityinsuranceapplication.data.PoliciesStatusObject
import com.jemutai.equityinsuranceapplication.data.SplashObject
import com.jemutai.equityinsuranceapplication.screens.claims.ClaimStatus
import com.jemutai.equityinsuranceapplication.screens.claims.InsuranceClaimForm


@Composable
fun AppNav(navController: NavHostController) {

    NavHost(navController = navController,
        startDestination = SplashObject.route) {
        composable(SplashObject.route){
            SplashScreen(navController = navController)
        }

        composable(Home.route) {
            HomeScreen(navController)
        }
        composable(PoliciesStatusObject.route) {
            ClaimStatus()
        }
        composable(ClaimObject.route) {
            InsuranceClaimForm(
                onDismiss = { navController.popBackStack() },
                onSubmit = { insuranceClaimDetails -> navController.popBackStack() },
                navController
            )
        }


    }
}

