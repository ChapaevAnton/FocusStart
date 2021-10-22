package com.w4eret1ckrtb1tch.focusstart.kaspresso.screen

import androidx.annotation.DrawableRes
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.w4eret1ckrtb1tch.focusstart.R
import com.w4eret1ckrtb1tch.focusstart.presentation.BaseActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigDecimal


@RunWith(AndroidJUnit4::class)
class TransactionTest : KTestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(BaseActivity::class.java)

    @Test
    @TestCase(
        name = "Test-1",
        description = "Check that the application loads and correctly displays the list of currency rates"
    )
    fun checkTransactions() {
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
                        isDisplayed()
                        click()
                    }
                }
            }

            step("Check transactions content") {
                checkTransactions(
                    Transaction(
                        charCode = "AUD",
                        name = "Австралийский доллар",
                        value = 53.1292.toString(),
                        rate = (-0.1198).toString(),
                        arrowId = R.drawable.ic_down
                    ),
                    Transaction(
                        charCode = "AZN",
                        name = "Азербайджанский манат",
                        value = 41.7836.toString(),
                        rate = (-0.0384).toString(),
                        arrowId = R.drawable.ic_down
                    ),
                    Transaction(
                        charCode = "GBP",
                        name = "Фунт стерлингов Соединенного королевства",
                        value = 97.9668.toString(),
                        rate = 0.0168.toString(),
                        arrowId = R.drawable.ic_up
                    ),
                    Transaction(
                        charCode = "AMD",
                        name = "Армянских драмов",
                        value = 14.864.toString(),
                        rate = (-0.0167).toString(),
                        arrowId = R.drawable.ic_down

                    ),
                    Transaction(
                        charCode = "BYN",
                        name = "Белорусский рубль",
                        value = 29.1685.toString(),
                        rate = 0.0355.toString(),
                        arrowId = R.drawable.ic_up
                    )
                )
            }
        }

    }

    data class Transaction(
        val charCode: String,
        val name: String,
        val value: String,
        val rate: String,
        @DrawableRes
        val arrowId: Int
    )

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
                            hasText(transaction.rate)
                        }

                        value {
                            isDisplayed()
                            hasText(transaction.value)
                        }

                        arrowId {
                            isDisplayed()
                            if (transaction.rate.toBigDecimal() >= BigDecimal(0)) hasDrawable(R.drawable.ic_up) else
                                hasDrawable(R.drawable.ic_down)
                        }
                    }
                }
            }
        }
    }

}