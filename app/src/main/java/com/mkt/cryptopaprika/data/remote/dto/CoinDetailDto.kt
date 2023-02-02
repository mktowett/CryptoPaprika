package com.mkt.cryptopaprika.data.remote.dto

import com.mkt.cryptopaprika.domain.model.CoinDetail

data class CoinDetailDto(
    var description: String,
    var development_status: String?,
    var first_data_at: String?,
    var hardware_wallet: Boolean?,
    var hash_algorithm: String?,
    var id: String,
    var is_active: Boolean?,
    var is_new: Boolean?,
    var last_data_at: String?,
    var links: Links?,
    var links_extended: List<LinksExtended?>?,
    var logo: String?,
    var message: String?,
    var name: String,
    var open_source: Boolean?,
    var org_structure: String?,
    var proof_type: String?,
    var rank: Int,
    var started_at: String?,
    var symbol: String?,
    var tags: List<Tag>,
    var team: List<TeamMembers>,
    var type: String?,
    var whitepaper: Whitepaper?
)

fun CoinDetailDto.toCoinDetail(): CoinDetail{
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol!!,
        rank = rank,
        isActive = is_active!!,
        tag = tags.map { it.name },
        team = team
    )
}