package com.example.lab_7

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DriverScreen(navController: NavController) {
    var driver by remember {
        mutableStateOf("")
    }

    var races = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // back button
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton") // for testing
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // title text
        Text(
            text = "Formula Zero Drivers",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // text field and button to add race locations
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = driver,
                onValueChange = {
                    driver = it // update location to new value
                },
                label = {
                    Text("Add Driver")
                },
                modifier = Modifier.testTag("driverInput") // for testing
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (driver.isNotBlank()) {
                        races.add(driver)
                        driver = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton") // for testing
            ) {
                Text("Add")
            }

            Button(
                onClick = {
                        races.clear()
                },
                modifier = Modifier.testTag("removeDriverButton") // for testing
            ) {
                Text("Delete")
            }
        }

        // list to display races
        LazyColumn {
            items(races) { race ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = race,
                    fontSize = 24.sp
                )
            }
        }
    }
}