package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.Test
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput


@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home(): Unit {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()

        //participation

        //home to drivers
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        //verify driver screen
        composeTestRule
            .onNodeWithText("Formula Zero Drivers")
            .assertExists()

        // enter driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Verstappen")

        //add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver appears
        composeTestRule
            .onNodeWithText("Verstappen")
            .assertExists()

        // delete driver
        composeTestRule
            .onNodeWithTag("removeDriverButton")
            .performClick()

        // verify delete driver
        composeTestRule
            .onNodeWithText("Verstappen")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}

