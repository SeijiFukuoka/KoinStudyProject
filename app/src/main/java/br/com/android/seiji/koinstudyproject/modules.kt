package br.com.android.seiji.koinstudyproject

import br.com.android.seiji.koinstudyproject.data.DataRepository
import br.com.android.seiji.koinstudyproject.data.DataRepositoryFactory
import br.com.android.seiji.koinstudyproject.data.LocalRepositoryImpl
import br.com.android.seiji.koinstudyproject.data.RemoteRepositoryImpl
import com.google.gson.Gson
import org.koin.dsl.module.module


val applicationModule = module {

    single { Gson() }

    factory { CurrenciesAdapter() }
    factory<DataRepository>("local") { LocalRepositoryImpl(get()) }
    factory<DataRepository>("remote") { RemoteRepositoryImpl(get()) }

    factory { DataRepositoryFactory(get("local"), get("remote")) }
}