package com.murait.mooramoney.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.murait.mooramoney.R
import com.murait.mooramoney.models.CreditCard

class CreditCardAdapter(var mActivity: Activity, var creditCardList: List<CreditCard>) :
    RecyclerView.Adapter<CreditCardAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_credit_card, viewGroup, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, i: Int) {
        val data = creditCardList[i]
        viewHolder.tvCardNumber.text = data.cardNumber
        viewHolder.tvCardHolder.text = data.name
        viewHolder.tvExpiryDate.text = data.expiryDate
        if (i % 2 == 0) {
            viewHolder.clCard.background = mActivity.getDrawable(R.drawable.card_primary_bg)
            viewHolder.ivTopCircle.setImageDrawable(mActivity.getDrawable(R.drawable.top_teal_circle))
            viewHolder.ivBottomCircle.setImageDrawable(mActivity.getDrawable(R.drawable.bottom_teal_circle))
        } else {
            viewHolder.clCard.background = mActivity.getDrawable(R.drawable.card_teal_bg)
            viewHolder.ivTopCircle.setImageDrawable(mActivity.getDrawable(R.drawable.top_primary_circle))
            viewHolder.ivBottomCircle.setImageDrawable(mActivity.getDrawable(R.drawable.bottom_primary_circle))
        }
        viewHolder.clCard.clipToOutline = true
    }

    override fun getItemCount(): Int {
        return creditCardList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var clCard: View = itemView.findViewById(R.id.clCard)
        var tvCardNumber: TextView = itemView.findViewById(R.id.tvCardNumber)
        var tvCardHolder: TextView = itemView.findViewById(R.id.tvCardHolder)
        var tvExpiryDate: TextView = itemView.findViewById(R.id.tvExpiryDate)
        var ivTopCircle: ImageView = itemView.findViewById(R.id.ivTopCircle)
        var ivBottomCircle: ImageView = itemView.findViewById(R.id.ivBottomCircle)
    }
}