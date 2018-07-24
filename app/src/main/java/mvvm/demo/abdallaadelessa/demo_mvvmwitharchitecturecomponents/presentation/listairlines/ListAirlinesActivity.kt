package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.R
import android.arch.lifecycle.ViewModelProviders



class ListAirlinesActivity : AppCompatActivity() {
    private var viewModel: ListAirlineViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ListAirlineViewModel::class.java)

        viewModel!!.getAirLines().observe(this, Observer {
            Log.d("DebugTag",it.toString())
        })

        viewModel!!.getErrorMessage().observe(this, Observer {
            Log.d("DebugTag",it.toString())
        })

    }
}
