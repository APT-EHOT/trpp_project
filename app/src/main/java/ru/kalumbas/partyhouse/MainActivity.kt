package ru.kalumbas.partyhouse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

/**
 * Main activity of the app
 * Shows info about all created parties
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Loads party list info from server
     * @param apiKey an apiKey to form query for server
     */
    fun loadPartyListActivity(apiKey: String) {

    }

    /**
     * Shows all parties list in recyclerView
     */
    fun showPartyList() {

    }

    /**
     * Makes transition to full info activity
     * @param messageForNextActivity message to send for next activity via
     * intent extras
     */
    fun goOnFullInfoActivity(messageForNextActivity: String) {

    }
}