package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.R
import android.arch.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.extensions.observe
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.extensions.withViewModel
import javax.inject.Inject


class ListAirlinesActivity : AppCompatActivity() {
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    private fun setup() {
        withViewModel<ListAirlineViewModel>(viewModelFactory) {
            observe(getAirLines(), ::UpdateAirlines)
            observe(getErrorMessage(), ::UpdateErrorMessage)
        }
    }

    private fun UpdateAirlines(airlines:List<AirlineModel>?){
         Log.d("DebugTag", airlines.toString())
    }

    private fun UpdateErrorMessage(message:String?){
        Log.d("DebugTag", message.toString())
    }


}
