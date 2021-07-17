package com.tedm.currencyexchanger.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tedm.currencyexchanger.R
import com.tedm.currencyexchanger.data.local.entities.Balance
import kotlinx.android.synthetic.main.item_balance.view.*

class BalanceAdapter : RecyclerView.Adapter<BalanceAdapter.BalancesViewHolder>()  {

    inner class BalancesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<Balance>() {
        override fun areItemsTheSame(oldItem: Balance, newItem: Balance): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Balance, newItem: Balance): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var balances: List<Balance>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BalancesViewHolder {
        return BalancesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_balance,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return balances.size
    }

    override fun onBindViewHolder(holder: BalancesViewHolder, position: Int) {
        val balance = balances[position]
        holder.apply {
            itemView.item_sum.text = balance.sum.toString()
            itemView.item_currency_code.text = balance.currencyCode

            itemView.setOnClickListener {
                onItemClickListener?.let { click ->
                    click(balance)
                }
            }
        }
    }

    private var onItemClickListener: ((Balance) -> Unit)? = null

    fun setOnItemClickListener(onItemClick: (Balance) -> Unit){
        onItemClickListener = onItemClick
    }
}