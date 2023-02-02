package com.mkt.cryptopaprika.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkt.cryptopaprika.common.Resource
import com.mkt.cryptopaprika.domain.use_case.get_coin.GetCoinUseCase
import com.mkt.cryptopaprika.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase)
    : ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = CoinListState(coins = it.data ?: emptyList())
                }
                is Resource.Error ->{
                    _state.value = CoinListState(
                        error = it.message ?: "Something went wrong while processing your request! Please try again later."
                    )
                }
                is Resource.Loading ->{
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}