package com.mkt.cryptopaprika.data.repository

import com.mkt.cryptopaprika.data.remote.CoinPaprikaApi
import com.mkt.cryptopaprika.data.remote.dto.CoinDetailDto
import com.mkt.cryptopaprika.data.remote.dto.CoinDto
import com.mkt.cryptopaprika.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor( private val api: CoinPaprikaApi)
    : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}