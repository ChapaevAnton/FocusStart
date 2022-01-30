package com.w4eret1ckrtb1tch.focusstart.kaspresso.screen

import android.view.View
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.w4eret1ckrtb1tch.focusstart.R
import org.hamcrest.Matcher

object MainScreen : Screen<MainScreen>() {


    val titleInfo = KTextView { withId(R.id.tvDate) }
    val updateButton = KButton { withId(R.id.loadCurrenciesButton) }

    val transactionList = KRecyclerView(
        builder = {
            withId(R.id.rvListCurrencies)
        },
        itemTypeBuilder = { itemType(::TransactionItem) }
    )

    class TransactionItem(parent: Matcher<View>) : KRecyclerItem<TransactionItem>(parent) {
        val charCode = KTextView(parent) { withId(R.id.char_code) }
        val name = KTextView(parent) { withId(R.id.name) }
        val rate = KTextView(parent) { withId(R.id.rate) }
        val value = KTextView(parent) { withId(R.id.value) }
        val arrowId = KImageView(parent) { withId(R.id.rate_arrow) }
    }

}