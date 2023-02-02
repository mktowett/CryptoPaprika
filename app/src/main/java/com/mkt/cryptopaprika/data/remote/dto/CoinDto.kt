package com.mkt.cryptopaprika.data.remote.dto

import com.mkt.cryptopaprika.domain.model.Coin

data class CoinDto(
    var id: String?,
    var is_active: Boolean?,
    var is_new: Boolean?,
    var name: String?,
    var rank: Int?,
    var symbol: String?,
    var type: String?
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}