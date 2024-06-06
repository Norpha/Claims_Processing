package com.jemutai.equityinsuranceapplication.screens.claims

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import com.jemutai.equityinsuranceapplication.data.ClaimStatus
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jemutai.equityinsuranceapplication.ui.theme.maroon


val status = listOf(
    ClaimStatus(
       policyNumber = "023/ICS/235890",
       claimId = "C001",
       // lossDate = "12/04/2023,
        description = "Car accident",
        color = maroon,
        status = "Approved"

    ),

    ClaimStatus(
        policyNumber = "024/ICS/235653",
        claimId = "C0012",
        // lossDate = "12/04/2023,
        description = "Home Insurance",
        color = maroon,
        status = "Pending"


    ),
    ClaimStatus(
        policyNumber = "024/ICS/1235890",
        claimId = "C0015",
        // lossDate = "12/04/2023,
        description = "Health  Insurance",
        color = maroon,
        status = "Denied"


    ),
    ClaimStatus(
        policyNumber = "023/ICS/455890",
        claimId = "C0031",
        // lossDate = "12/04/2023,
        description = "Health Insurance",
        color = maroon,
        status = "Approved"


    ),

    ClaimStatus(
        policyNumber = "023/ICS/455890",
        claimId = "C0031",
        // lossDate = "12/04/2023,
        description = "Health Insurance",
        color = maroon,
        status = "Approved"


    ),
)

@Composable
fun ClaimStatus() {

    Column {
        Text(
            text = "Check Your  Claim Status",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {
            items(status.size) { index ->
                ClaimStatusCard(index = index)
            }
        }
    }
}
@Composable
fun ClaimStatusCard(index: Int) {
    val claimsts = status[index]
    var lastItemPaddingEnd = 0.dp
    if (index == status.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top= 9.dp, bottom= 10.dp, start = 66.dp, end = lastItemPaddingEnd)






    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(claimsts.color)
                .width(250.dp)
                .height(160.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp),

                verticalArrangement = Arrangement.Center

        ) {


            Text(text = claimsts.policyNumber, style = MaterialTheme.typography.headlineSmall, color = Color.White)

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = claimsts.claimId, style = MaterialTheme.typography.headlineSmall, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = claimsts.description, style = MaterialTheme.typography.headlineSmall, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = claimsts.status, style = MaterialTheme.typography.headlineSmall, color = Color.White)
//
        }
    }
}





//
//@Composable
//fun ClaimsScreen() {
//
//    Column {
//        Row(
//            modifier = androidx.compose.ui.Modifier
//                .fillMaxWidth(),
//
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = "Claim Code",
//
//                fontWeight = FontWeight.SemiBold,
//                color = MaterialTheme.colorScheme.onBackground,
//                modifier = androidx.compose.ui.Modifier.padding(16.dp)
//            )
//            Text(
//                text = "Description",
//
//                fontWeight = FontWeight.SemiBold,
//                color = MaterialTheme.colorScheme.onBackground,
//                modifier = androidx.compose.ui.Modifier.padding(16.dp)
//            )
//            Text(
//                text = "Status",
//
//                fontWeight = FontWeight.SemiBold,
//                color = MaterialTheme.colorScheme.onBackground,
//                modifier = androidx.compose.ui.Modifier.padding(16.dp)
//            )
//        }
//
//
//
//        val claims = listOf(
//            ClaimStatus("C001", "Car accident", "Pending"),
//            ClaimStatus("C002", "Home insurance", "Approved"),
//            ClaimStatus("C003", "Health insurance", "Denied")
//        )
//
//
//
//
//
//
//
//
//        LazyColumn {
//            items(claims) { claim ->
//                ClaimRow(claim = claim)
//            }
//        }
//    }
//}
//
//
//@Composable
//fun ClaimRow(claim: ClaimStatus) {
//    Box(
//        modifier = androidx.compose.ui.Modifier.fillMaxWidth()
//    ) {
//
//        Row(
//            modifier = androidx.compose.ui.Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(text = claim.claimId, style = MaterialTheme.typography.bodySmall)
//            Text(text = claim.description, style = MaterialTheme.typography.bodySmall)
//            Text(text = claim.status, style = MaterialTheme.typography.bodySmall)
//        }
//    }
//}