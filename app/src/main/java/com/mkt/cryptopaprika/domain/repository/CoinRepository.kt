package com.mkt.cryptopaprika.domain.repository

import com.mkt.cryptopaprika.data.remote.dto.CoinDetailDto
import com.mkt.cryptopaprika.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}