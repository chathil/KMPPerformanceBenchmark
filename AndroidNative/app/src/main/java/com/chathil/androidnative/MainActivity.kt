package com.chathil.androidnative

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.chathil.games.presentation.GetGamesPresenter
import com.chathil.games.utils.TimeMeasurementUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var getGamesPresenter: GetGamesPresenter



    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text: TextView = findViewById(R.id.text_view1)
        text.setOnClickListener {
            getGamesPresenter.getTimes()
        }
        getGamesPresenter.getList()
    }



}