package mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.presentation.listairlines

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.R
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.data.airline.model.AirlineModel
import mvvm.demo.abdallaadelessa.demo_mvvmwitharchitecturecomponents.databinding.ListItemAirlineBinding

class ListAirlinesRvAdapter() : ListAdapter<AirlineModel, ListAirlinesRvAdapter.ViewHolder>(AirlineDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_item_airline, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let{ airline ->
            with(holder) {
                itemView.tag = airline.code
                bind(airline)
            }
        }
    }

    class ViewHolder(private val binding: ListItemAirlineBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(airline: AirlineModel) {
            with(binding) {
                viewModel = AirlineViewModel(airline)
                executePendingBindings()
            }
        }
    }

    class AirlineViewModel(val airline: AirlineModel) : ViewModel() {
        val name = ObservableField<String>(airline.name)
        val site = ObservableField<String>(airline.site)
        val phone = ObservableField<String>(airline.phone)
        val imageUrl = ObservableField<String>(airline.logoURL)
    }
}

class AirlineDiffCallback : DiffUtil.ItemCallback<AirlineModel>() {
    override fun areItemsTheSame(oldItem: AirlineModel, newItem: AirlineModel): Boolean =oldItem.code == newItem.code
    override fun areContentsTheSame(oldItem: AirlineModel, newItem: AirlineModel): Boolean = oldItem == newItem
}



