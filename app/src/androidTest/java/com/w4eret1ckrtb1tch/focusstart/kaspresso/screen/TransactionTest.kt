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
                        isEnabled()
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
                        value = BigDecimal(53.1292),
                        rate = BigDecimal(-0.1198),
                        arrowId = R.drawable.ic_down
                    ),
                    Transaction(
                        charCode = "AMD",
                        name = "Армянских драмов",
                        value = BigDecimal(14.864),
                        rate = BigDecimal(-0.0167),
                        arrowId = R.drawable.ic_down

                    ),
                    Transaction(
                        charCode = "GBP",
                        name = "Фунт стерлингов Соединенного королевства",
                        value = BigDecimal(97.9668),
                        rate = BigDecimal(0.0168),
                        arrowId = R.drawable.ic_up
                    ),
                    Transaction(
                        charCode = "AZN",
                        name = "Азербайджанский манат",
                        value = BigDecimal(41.7836),
                        rate = BigDecimal(-0.0384),
                        arrowId = R.drawable.ic_down
                    ),
                    Transaction(
                        charCode = "BYN",
                        name = "Белорусский рубль",
                        value = BigDecimal(29.1685),
                        rate = BigDecimal(0.0355),
                        arrowId = R.drawable.ic_up
                    )
                )
            }
        }

    }

    data class Transaction(
        val charCode: String,
        val name: String,
        val value: BigDecimal,
        val rate: BigDecimal,
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

    private fun BigDecimal.toRate() =
        String.format("( %1$.4f ₽ )", this)

    private fun BigDecimal.toValue() =
        String.format("%1$.4f ₽", this)

}