package com.jemutai.equityinsuranceapplication.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jemutai.equityinsuranceapplication.data.ClaimFeatures
import com.jemutai.equityinsuranceapplication.data.ClaimObject
import com.jemutai.equityinsuranceapplication.data.PoliciesStatusObject
import com.jemutai.equityinsuranceapplication.ui.theme.maroon

val features = listOf(
    ClaimFeatures(
        icon = Icons.Default.Edit,
        title = "New Claim",
        color = maroon,


    ),
    ClaimFeatures(
        icon = Icons.Default.CheckCircle,
        title = "Claim Status",
        color = maroon,


    ),
    ClaimFeatures(
        icon = Icons.Default.CheckCircle,
        title = "Claims History",
        color = maroon,


    ),

ClaimFeatures(
icon = Icons.Rounded.MailOutline,
title = "Upload Documents",
color = maroon,


    )
)


@Composable
fun ClaimsSection(navController: NavController) {

    Column {
        Text(
            text = "Claim Management",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )
    }
    LazyRow {
        items(features.size) { index ->
            ClaimFeatureCard(index = index, navController = navController)
        }
    }
}

@Composable
fun ClaimFeatureCard(index: Int, navController: NavController) {
    val feature = features[index]
    var lastItemPaddingEnd = 0.dp
    if (index == features.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = lastItemPaddingEnd)
            .clickable {
                when (feature.title) {
                    "New Claim" -> navController.navigate(ClaimObject.route)
                    "Claim Status" -> navController.navigate(PoliciesStatusObject.route)
                    "Claims History" -> navController.navigate(PoliciesStatusObject.route)
                    "Upload Documents" -> navController.navigate(PoliciesStatusObject.route)

                   // Screen("ClaimStatus")
                }
            }
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(feature.color)
                .width(250.dp)
                .height(160.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = feature.icon,
                contentDescription = feature.title,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = feature.title, style = MaterialTheme.typography.headlineSmall, color = Color.White)
//
            }
        }
    }
