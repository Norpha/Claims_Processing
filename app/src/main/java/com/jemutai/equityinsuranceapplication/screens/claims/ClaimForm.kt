package com.jemutai.equityinsuranceapplication.screens.claims

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jemutai.equityinsuranceapplication.R
import com.jemutai.equityinsuranceapplication.data.InsuranceClaimDetails
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun InsuranceClaimForm(
    onDismiss: () -> Unit,
    onSubmit: (InsuranceClaimDetails) -> Unit,
    navController: NavController
) {
   // val calenderState = rememberSheetState()
    var claimType by remember { mutableStateOf("") }
    var claimDescription by remember { mutableStateOf("") }
    var claimDate by rememberSaveable { mutableStateOf(Date().time) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { androidx.compose.material.Text(text = "File Insurance Claim") },
        text = {
            Column {
                androidx.compose.material.TextField(
                    value = claimType,
                    onValueChange = { claimType = it },
                    label = { Text("Claim Type") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = claimDescription,
                    onValueChange = { claimDescription = it },
                    label = { Text("Claim Description") },
                    maxLines = 5
                )
                Spacer(modifier = Modifier.height(16.dp))
                ClaimDateTextField { claimDate = it }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    // Validate input fields
                    if (claimType.isNotBlank() && claimDescription.isNotBlank()) {
                        onSubmit(InsuranceClaimDetails(claimType, claimDescription))
                        onDismiss()
                    }
                }
            ) {
                Text(text = "Submit")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text(text = "Cancel")
            }
        }
    )
}

@Composable
fun ClaimDateTextField(claimDate: (Long) -> Unit){
    Text(
        text = stringResource(id = R.string.claim_date),
        style = MaterialTheme.typography.bodyLarge
    )
    val interactionSource = remember { MutableInteractionSource()}
    val isPressed: Boolean by interactionSource.collectIsPressedAsState()

    val currentDate = Date().toFormattedString()
    var selectedDate by rememberSaveable { mutableStateOf(currentDate)}

    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val year: Int = calendar.get(Calendar.YEAR)
    val month: Int = calendar.get(Calendar.MONTH)
    val day: Int  = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val datePickerDialog =
        DatePickerDialog(context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val newDate = Calendar.getInstance()
            newDate.set(year, month, dayOfMonth)
            selectedDate  ="${month.toMonthName()} $dayOfMonth, $year"
            claimDate(newDate.timeInMillis)
        }, year, month, day)
    TextField(
        modifier = Modifier.fillMaxWidth(),
        readOnly = true,
        value = selectedDate,
        onValueChange = {},
        trailingIcon = {Icons.Default.DateRange},
        interactionSource = interactionSource
    )
    if (isPressed){
        datePickerDialog.show()
    }
}
fun Int.toMonthName(): String {
    return DateFormatSymbols().months[this]
}

private fun Date.toFormattedString(): String {
    val  simpleDateFormat = SimpleDateFormat("LLLL dd, yyyy", Locale.getDefault())
    return simpleDateFormat.format(this)
}

//@Preview
//@Composable
//fun PreviewMode(){
//    val claimDetails = remember { mutableStateOf(InsuranceClaimDetails("", "")) }
//
//    // Define a boolean state to simulate the visibility of the modal
//    var isModalVisible by remember { mutableStateOf(true) }
//
//    // Function to dismiss the modal
//    val dismissModal: () -> Unit = { isModalVisible = false }
//
//    // Function to submit the form
//    val submitForm: (InsuranceClaimDetails) -> Unit = {
//        claimDetails.value = it
//        isModalVisible = false
//    }
//
//    // Compose the UI
//    Column {
//        InsuranceClaimForm(
//
//            onDismiss = dismissModal,
//            onSubmit = submitForm
//        )
//    }
//}
