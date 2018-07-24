package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.R
import android.arch.lifecycle.ViewModelProviders
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.app.application.MyApplication
import javax.inject.Inject


class ListAirlinesActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private var viewModel: ListAirlineViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.appComponent.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ListAirlineViewModel::class.java)
        ObserveViewModel()
    }

    private fun ObserveViewModel() {
        viewModel!!.getAirLines().observe(this, Observer {
            Log.d("DebugTag", it.toString())
        })

        viewModel!!.getErrorMessage().observe(this, Observer {
            Log.d("DebugTag", it.toString())
        })
    }
}
