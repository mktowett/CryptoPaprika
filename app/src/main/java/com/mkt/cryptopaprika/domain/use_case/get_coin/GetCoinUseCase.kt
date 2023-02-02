package com.mkt.cryptopaprika.domain.use_case.get_coin

import com.mkt.cryptopaprika.common.Resource
import com.mkt.cryptopaprika.data.remote.dto.toCoin
import com.mkt.cryptopaprika.data.remote.dto.toCoinDetail
import com.mkt.cryptopaprika.domain.model.Coin
import com.mkt.cryptopaprika.domain.model.CoinDetail
import com.mkt.cryptopaprika.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?: "An error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server please check your connection!"))
        }
    }
}