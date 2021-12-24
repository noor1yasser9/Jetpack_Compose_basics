package com.noor.yasser.ps.jetpackcomposebasics

import android.os.SystemClock
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.noor.yasser.ps.jetpackcomposebasics.L7_Lists.*
import com.noor.yasser.ps.jetpackcomposebasics.L7_Lists.ui.theme.BasicsCodelabTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


//    @Test
//    fun givenASmallScreen_whenTheUIIsGenerated_thenItHasASingleChild() {
//        composeTestRule.setContent {
//            TestUi(widthDp = 300)
//        }
//        composeTestRule.onRoot().onChildren().assertCountEquals(1)
//    }

    @Test
    fun testTaskListScreenIfTaskAreEmpty() {
        composeTestRule.setContent {
            BasicsCodelabTheme {
                TaskListScreen(emptyList())
            }
        }
        composeTestRule.onNodeWithTag(TASK_LIST_TEST_TAG)
            .onChildren()
            .assertCountEquals(0)
    }


    @Test
    fun testFirstAndLastTaskDescription() {
        composeTestRule.setContent {
//            JetPackComposeAndroidTheme {
            TaskListScreen(getTasksList())
//            }
        }

//        composeTestRule.apply {
//            onNodeWithTag(TASK_LIST_TEST_TAG)
//                .onChildren()
//                .onFirst()
//                .assert(hasText("Buy Milk and eggs!"))
//
//            onNodeWithTag(TASK_LIST_TEST_TAG)
//                .onChildren()
//                .onLast()
//                .assert(hasText("Plan for weekend trip"))

        composeTestRule.onNodeWithTag(TASK_LIST_TEST_TAG).onChildren()[6].performClick()

        SystemClock.sleep(1000)
        composeTestRule.onNodeWithTag(TASK_LIST_TEST_TAG).onChildren()[6].performClick()

//    }
    }


    fun getTasksList(): List<Task> = listOf(
        Task("Buy Milk and eggs!"),
        Task("Run 3 miles"),
        Task("Take puppy to clinic"),
        Task("Plan for weekend trip"),
        Task("2 Buy Milk and eggs!"),
        Task("3 Run 3 miles"),
        Task("3 Run 32 miles"),
        Task("3 Run 33 miles"),
        Task("4 Take puppy to clinic"),
        Task("6 Plan for weekend trips")
    )
}