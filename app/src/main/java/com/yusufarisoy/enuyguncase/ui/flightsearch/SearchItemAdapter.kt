package com.yusufarisoy.enuyguncase.ui.flightsearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yusufarisoy.enuyguncase.databinding.RecyclerItemFlightBinding
import com.yusufarisoy.enuyguncase.domain.model.FlightUiModel

class SearchItemAdapter(
    private val onClicked: (String) -> Unit
) : RecyclerView.Adapter<SearchItemAdapter.SearchItemViewHolder>() {

    private val differ = AsyncListDiffer(
        this,
        diffCallback
    )

    fun setData(items: List<FlightUiModel>) {
        differ.submitList(items)
    }

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        val flight = differ.currentList[position]
        holder.bind(flight, onClicked)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        return SearchItemViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<FlightUiModel>() {
            override fun areItemsTheSame(
                oldItem: FlightUiModel,
                newItem: FlightUiModel
            ): Boolean {
                return oldItem.enuid == newItem.enuid
            }

            override fun areContentsTheSame(
                oldItem: FlightUiModel,
                newItem: FlightUiModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class SearchItemViewHolder(
        private val binding: RecyclerItemFlightBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            flight: FlightUiModel,
            onClicked: (String) -> Unit
        ) {
            binding.flight = flight
            binding.executePendingBindings()

            binding.buttonNavigate.setOnClickListener {
                onClicked(flight.enuid)
            }
        }

        companion object {
            fun from(parent: ViewGroup): SearchItemViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RecyclerItemFlightBinding.inflate(inflater, parent, false)

                return SearchItemViewHolder(binding)
            }
        }
    }
}
