package com.murait.mooramoney.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.murait.mooramoney.R
import com.murait.mooramoney.models.Operation

class OperationAdapter(var mActivity: Activity, var operationList: List<Operation>) :
    RecyclerView.Adapter<OperationAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_operation, viewGroup, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, i: Int) {
        val data = operationList[i]
        viewHolder.ivThumb.setImageDrawable(mActivity.getDrawable(data.img))
        viewHolder.tvOperationName.text = data.name
    }

    override fun getItemCount(): Int {
        return operationList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivThumb: ImageView = itemView.findViewById(R.id.ivThumb)
        var tvOperationName: TextView = itemView.findViewById(R.id.tvOperationName)
    }
}