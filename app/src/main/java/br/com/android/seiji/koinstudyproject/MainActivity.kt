package br.com.android.seiji.koinstudyproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.android.seiji.koinstudyproject.data.DataRepositoryFactory
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val currenciesAdapter: CurrenciesAdapter by inject()
    private val dataRepositoryFactory: DataRepositoryFactory by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        val currenciesJson = resources.openRawResource(R.raw.currencies)
            .bufferedReader().use { it.readText() }
        val items = dataRepositoryFactory.retrieveRemoteSource().getCurrencies(currenciesJson)
        currenciesAdapter.currencies = items
    }

    private fun setupRecyclerView() {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = currenciesAdapter
    }
}
