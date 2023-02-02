package com.mkt.cryptopaprika.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkt.cryptopaprika.common.Resource
import com.mkt.cryptopaprika.domain.model.CoinDetail
import com.mkt.cryptopaprika.domain.use_case.get_coin.GetCoinUseCase
import com.mkt.cryptopaprika.domain.use_case.get_coins.GetCoinsUseCase
import com.mkt.cryptopaprika.presentation.coin_list.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(private val getCoinUseCase: GetCoinUseCase,
                                              savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>("coinId")?.let {
            getCoin(coinId = it)
        }

    }

    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = CoinDetailState(coins = it.data)
                }
                is Resource.Error ->{
                    _state.value = CoinDetailState(
                        error = it.message ?: "Something went wrong while processing your request! Please try again later."
                    )
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}