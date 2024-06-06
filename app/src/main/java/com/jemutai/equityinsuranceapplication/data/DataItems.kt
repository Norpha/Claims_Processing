package com.jemutai.equityinsuranceapplication.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class ClaimFeatures(
    val icon: ImageVector,
    val title: String,
    val color: Color,

)

data class BottomNavigation(
    val title :String,
    val  icon : ImageVector
)

data class ClaimStatus(
    val policyNumber: String,
    val claimId: String,
    //val lossDate: Date,
    val description: String,
    val status: String,
    val color: Color
)

data class Policies (

    val name: String,
    val background: Color


)

data class InsuranceClaimDetails(
    val claimType: String,
    val claimDescription: String,
//    val claimDate: String
)