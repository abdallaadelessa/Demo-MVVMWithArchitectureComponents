package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.common.model.ViewState

@BindingAdapter("bindViewErrorState")
fun bindViewErrorState(view: TextView, viewState: ViewState<List<AirlineModel>>?) {
    view.visibility = if (viewState is ViewState.Error) View.VISIBLE else View.GONE
    view.text = if (viewState is ViewState.Error) viewState.message else ""
}

@BindingAdapter("bindViewLoadingState")
fun bindViewLoadingState(view: ProgressBar, viewState: ViewState<List<AirlineModel>>?) {
    view.visibility = if (viewState is ViewState.Loading) View.VISIBLE else View.GONE
}

@BindingAdapter("bindViewSuccessState")
fun bindViewSuccessState(view: RecyclerView, viewState: ViewState<List<AirlineModel>>?) {
    val adapter = view.adapter
    if (viewState is ViewState.Success) {
        if (adapter is ListAirlinesRvAdapter) adapter.submitList(viewState.data)
        view.visibility = View.VISIBLE
    }else {
        view.visibility = View.GONE
    }
}