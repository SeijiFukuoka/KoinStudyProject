package br.com.android.seiji.koinstudyproject

import br.com.android.seiji.koinstudyproject.data.DataRepository
import br.com.android.seiji.koinstudyproject.data.DataRepositoryImpl
import com.google.gson.Gson
import org.koin.dsl.module.module


val applicationModule = module {

    single { Gson() }

    factory { CurrenciesAdapter() }
    factory<DataRepository> { DataRepositoryImpl(get()) }
}