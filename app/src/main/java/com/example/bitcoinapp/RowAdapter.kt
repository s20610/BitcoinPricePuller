package com.example.bitcoinapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bitcoinapp.databinding.TableRowItemBinding

class RowAdapter(var bitcoinRows: List<BitcoinRow>) :
    RecyclerView.Adapter<RowAdapter.RowViewHolder>() {

    class RowViewHolder(
        private var binding: TableRowItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(row: BitcoinRow) {
            binding.price.text = row.price
            binding.timestamp.text = row.updatedTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        return RowViewHolder(
            TableRowItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        val bitcoinRow = bitcoinRows[position]
        holder.bind(bitcoinRow)
    }

    override fun getItemCount(): Int {
        return bitcoinRows.size
    }
}