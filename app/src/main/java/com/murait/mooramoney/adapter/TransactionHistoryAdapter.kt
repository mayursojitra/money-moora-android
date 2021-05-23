package com.murait.mooramoney.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.murait.mooramoney.R
import com.murait.mooramoney.models.Transaction

class TransactionHistoryAdapter(var mActivity: Activity, var transactionList: List<Transaction>) :
    RecyclerView.Adapter<TransactionHistoryAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_transaction, viewGroup, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, i: Int) {
        val data = transactionList[i]
        viewHolder.tvName.text = data.name
        viewHolder.tvDate.text = data.transDate
        viewHolder.ivThumb.setImageDrawable(mActivity.getDrawable(data.thumb))
        if (data.debitCredit == "-") {
            viewHolder.tvAmount.setTextColor(mActivity.resources.getColor(R.color.purple_700))
            viewHolder.tvAmount.text = "-$" + data.amount
        } else {
            viewHolder.tvAmount.setTextColor(mActivity.resources.getColor(R.color.teal_700))
            viewHolder.tvAmount.text = "+$" + data.amount
        }
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvDate: TextView = itemView.findViewById(R.id.tvDate)
        var ivThumb: ImageView = itemView.findViewById(R.id.ivThumb)
        var tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
    }
}