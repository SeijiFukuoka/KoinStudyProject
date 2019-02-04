package br.com.android.seiji.koinstudyproject.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.android.seiji.koinstudyproject.data.DataRepositoryFactory
import br.com.android.seiji.koinstudyproject.model.Currency

class CurrenciesViewModel constructor(
    private val dataRepositoryFactory: DataRepositoryFactory
) : ViewModel() {

    private val currencyLiveData = MutableLiveData<List<Currency>>()

    fun observeCurrencies(): LiveData<List<Currency>> {
        return currencyLiveData
    }

    fun retrieveCurrencies(jsonString: String) {
        val data = dataRepositoryFactory.retrieveRemoteSource().getCurrencies(jsonString)
        currencyLiveData.postValue(data)
    }
}