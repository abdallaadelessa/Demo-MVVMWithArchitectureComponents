package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.arch.lifecycle.ViewModelProvider
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.R
import dagger.android.AndroidInjection
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.databinding.ActivityListAirlinesBinding
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.common.model.ViewState
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.common.extensions.observe
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.common.extensions.withViewModel
import timber.log.Timber
import javax.inject.Inject

class ListAirlinesActivity : AppCompatActivity() {
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var adapter :ListAirlinesRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        val binding : ActivityListAirlinesBinding= DataBindingUtil.setContentView(this, R.layout.activity_list_airlines)

        with(binding){
            setLifecycleOwner(this@ListAirlinesActivity)
        }

        withViewModel<ListAirlineViewModel>(viewModelFactory) {
            binding.viewModel = this
        }
    }
}

@BindingAdapter("bindViewErrorState")
fun bindViewErrorState(view: TextView, viewState: ViewState<List<AirlineModel>>?) {
    view.visibility=if(viewState is ViewState.Error ) View.VISIBLE else View.GONE
    view.text=if(viewState is ViewState.Error ) viewState.message else ""
}

@BindingAdapter("bindViewLoadingState")
fun bindViewLoadingState(view: ProgressBar, viewState: ViewState<List<AirlineModel>>?) {
    view.visibility=if(viewState is ViewState.Loading ) View.VISIBLE else View.GONE
}

@BindingAdapter("bindViewSuccessState")
fun bindViewSuccessState(view: SwipeRefreshLayout, viewState: ViewState<List<AirlineModel>>?) {
    view.visibility=if(viewState is ViewState.Success ) View.VISIBLE else View.GONE
}
