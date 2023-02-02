package com.mkt.cryptopaprika.presentation.coin_list

import com.mkt.cryptopaprika.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)