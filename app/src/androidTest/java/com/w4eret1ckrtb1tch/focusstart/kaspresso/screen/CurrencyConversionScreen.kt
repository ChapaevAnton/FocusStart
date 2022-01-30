package com.w4eret1ckrtb1tch.focusstart.kaspresso.screen

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.w4eret1ckrtb1tch.focusstart.R

object CurrencyConversionScreen : Screen<CurrencyConversionScreen>() {

    val charCode = KTextView { withId(R.id.tvCharCode) }
    val name = KTextView { withId(R.id.tvName) }
    val rate = KTextView { withId(R.id.tvRate) }
    val value = KTextView { withId(R.id.tvValue) }
    val arrowId = KImageView { withId(R.id.ivRateArrow) }
    val amountCurrency = KTextView { withId(R.id.tvAmountCurrency) }
    val cash = KEditText { withId(R.id.evCash) }

}