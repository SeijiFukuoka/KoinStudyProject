package br.com.android.seiji.koinstudyproject.data

import br.com.android.seiji.koinstudyproject.model.Currency

interface DataRepository {
    fun getCurrencies(jsonString: String): List<Currency>
}