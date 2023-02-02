package com.mkt.cryptopaprika.domain.model

import com.mkt.cryptopaprika.data.remote.dto.TeamMembers

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tag: List<String>,
    val team: List<TeamMembers>

)
