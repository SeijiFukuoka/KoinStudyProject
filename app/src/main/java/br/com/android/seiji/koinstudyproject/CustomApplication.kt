package br.com.android.seiji.koinstudyproject

import android.app.Application
import org.koin.android.ext.android.startKoin

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule, browseModule))
    }
}