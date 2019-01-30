package br.com.android.seiji.koinstudyproject

import com.google.gson.Gson
import org.koin.dsl.module.module


val applicationModule = module {

    single { Gson() }

    factory { CurrenciesAdaper() }
}