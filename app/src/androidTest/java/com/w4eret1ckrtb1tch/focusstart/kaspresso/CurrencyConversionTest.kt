package com.w4eret1ckrtb1tch.focusstart.kaspresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.kaspresso.config.*
import com.w4eret1ckrtb1tch.focusstart.kaspresso.config.ConfigTest.INPUT_CASH
import com.w4eret1ckrtb1tch.focusstart.kaspresso.config.ConfigTest.INPUT_CASH_ZERO
import com.w4eret1ckrtb1tch.focusstart.kaspresso.config.ConfigTest.TRANSACTION_INDEX
import com.w4eret1ckrtb1tch.focusstart.kaspresso.data.Transaction
import com.w4eret1ckrtb1tch.focusstart.kaspresso.data.TransactionData
import com.w4eret1ckrtb1tch.focusstart.kaspresso.screen.CurrencyConversionScreen
import com.w4eret1ckrtb1tch.focusstart.kaspresso.screen.MainScreen
import com.w4eret1ckrtb1tch.focusstart.ui.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigDecimal

@RunWith(AndroidJUnit4::class)
class CurrencyConversionTest : KTestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @TestCase(
        name = "Test-2",
        description = "Check the efficiency of the conversion logic"
    )
    fun checkCurrencyConversion() {

        before {
            checkClickTransaction(TRANSACTION_INDEX)
        }.after {

        }.run {

            step("Check transactions detailed content") {
                checkDetailTransaction(TransactionData.transaction[TRANSACTION_INDEX])
            }

            step("Check conversion logic") {
                checkConversionLogic(TransactionData.transaction[TRANSACTION_INDEX])
            }
        }

    }

    private fun checkClickTransaction(index: Int) {
        MainScreen {
            transactionList {
                childAt<MainScreen.TransactionItem>(index) {
                    click()
                }
            }
        }
    }

    private fun checkDetailTransaction(transaction: Transaction) {
        CurrencyConversionScreen {
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

            amountCurrency {
                hasText(INPUT_CASH_ZERO.toAmountCurrency())
            }
        }
    }

    private fun checkConversionLogic(transaction: Transaction) {
        CurrencyConversionScreen {

            cash {
                typeText(INPUT_CASH.toString())
            }

            amountCurrency {
                isDisplayed()
                hasText(transaction.amountCurrency.toAmountCurrency())
            }
        }

    }

}