package com.mkt.cryptopaprika.presentation.coin_details

import com.mkt.cryptopaprika.domain.model.Coin
import com.mkt.cryptopaprika.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coins: CoinDetail? = null,
    val error: String = ""
)