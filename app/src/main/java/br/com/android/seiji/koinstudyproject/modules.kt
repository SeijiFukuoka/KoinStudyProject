package br.com.android.seiji.koinstudyproject

import br.com.android.seiji.koinstudyproject.data.DataRepository
import br.com.android.seiji.koinstudyproject.data.DataRepositoryFactory
import br.com.android.seiji.koinstudyproject.data.LocalRepositoryImpl
import br.com.android.seiji.koinstudyproject.data.RemoteRepositoryImpl
import br.com.android.seiji.koinstudyproject.presentation.CurrenciesAdapter
import br.com.android.seiji.koinstudyproject.presentation.CurrenciesViewModel
import com.google.gson.Gson
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val applicationModule = module {

    single { Gson() }
    single { UrlHelper(getProperty("currency_base_url")) }

    factory<DataRepository>("local") { LocalRepositoryImpl(get()) }
    factory<DataRepository>("remote") { RemoteRepositoryImpl(get()) }

    factory { DataRepositoryFactory(get("local"), get("remote")) }
}

val browseModule = module("browse") {
    factory { CurrenciesAdapter() }
    viewModel { CurrenciesViewModel(get()) }
}