package com.w4eret1ckrtb1tch.focusstart.kaspresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.kaspresso.config.KTestCase
import com.w4eret1ckrtb1tch.focusstart.kaspresso.config.TestCase
import com.w4eret1ckrtb1tch.focusstart.kaspresso.config.toRate
import com.w4eret1ckrtb1tch.focusstart.kaspresso.config.toValue
import com.w4eret1ckrtb1tch.focusstart.kaspresso.data.Transaction
import com.w4eret1ckrtb1tch.focusstart.kaspresso.data.TransactionData
import com.w4eret1ckrtb1tch.focusstart.kaspresso.screen.MainScreen
import com.w4eret1ckrtb1tch.focusstart.ui.activity.BaseActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigDecimal


@RunWith(AndroidJUnit4::class)
class ListCurrencyTransactionTest : KTestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(BaseActivity::class.java)

    @Test
    @TestCase(
        name = "Test-1",
        description = "Check that the application loads and correctly displays the list of currency rates"
    )
    fun checkTransactions() {
        run {

            step("Check transactions content") {
                checkTransactions(*TransactionData.transaction)
            }
        }
    }

    @Test
    @TestCase(
        name = "Test-1",
        description = "Check title and data refresh button"
    )
    fun checkTitleInfoAndUpdateButton() {
        run {

            step("Check title info") {
                MainScreen {
                    titleInfo {
                        isDisplayed()
                        hasText("Курс валют ЦБ РФ на: 22 окт. 2021 г.")
                    }
                }
            }

            step("Check data update button") {
                MainScreen {
                    updateButton {
                        isEnabled()
                        isDisplayed()
                        click()
                    }
                }
            }
        }
    }

    private fun checkTransactions(vararg transactions: Transaction) {
        transactions.forEachIndexed { index, transaction ->
            MainScreen {
                transactionList {
                    childAt<MainScreen.TransactionItem>(index) {
                        charCode {
                            isDisplayed()
                            hasText(transaction.charCode)
                        }

                        name {
                            isDisplayed()
                            hasText(transaction.name)
                        }

                        rate {
                            isDisplayed()
                            hasText(transaction.rate.toRate())
                        }

                        value {
                            isDisplayed()
                            hasText(transaction.value.toValue())
                        }

                        arrowId {
                            isDisplayed()
                            if (transaction.rate >= BigDecimal(0)) hasDrawable(R.drawable.ic_up) else
                                hasDrawable(R.drawable.ic_down)
                        }
                    }
                }
            }
        }
    }

}