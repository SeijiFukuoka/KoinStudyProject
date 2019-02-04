package br.com.android.seiji.koinstudyproject.data

import br.com.android.seiji.koinstudyproject.model.Currency
import com.google.gson.Gson

class RemoteRepositoryImpl(private val gson: Gson) : DataRepository {

    override fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString, Array<Currency>::class.java).toList()
    }

}