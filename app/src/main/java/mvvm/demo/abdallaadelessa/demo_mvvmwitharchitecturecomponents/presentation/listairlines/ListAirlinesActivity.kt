package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.R
import dagger.android.AndroidInjection
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.databinding.ActivityListAirlinesBinding
import javax.inject.Inject

class ListAirlinesActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var adapter: ListAirlinesRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        val binding: ActivityListAirlinesBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_airlines)
        with(binding) {
            viewModel = ViewModelProviders.of(this@ListAirlinesActivity, viewModelFactory)[ListAirlineViewModel::class.java]
            rvList.adapter = adapter
            setLifecycleOwner(this@ListAirlinesActivity)
        }
    }
}


