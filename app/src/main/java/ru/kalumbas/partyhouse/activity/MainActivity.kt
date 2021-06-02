package ru.kalumbas.partyhouse.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import ru.kalumbas.partyhouse.R
import ru.kalumbas.partyhouse.viewModel.MainActivityViewModel

/**
 * Main activity of the app
 * Shows info about all created parties
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel by viewModels<MainActivityViewModel>()
        viewModel.getInfo(1)
        viewModel.getEvents().observe(this, Observer {

        })
    }
}