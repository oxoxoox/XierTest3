package com.example.xiertest

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter <M,H:BaseViewHolder<M>>(val dataList:List<M>)
: RecyclerView.Adapter<H>() {
    protected var itemClickListener: IKotlinItemClickListener? = null
    interface IKotlinItemClickListener {
        fun onItemClickListener(position: Int)
    }
    fun setOnKotlinItemClickListener(itemClickListener: IKotlinItemClickListener) {
        this.itemClickListener = itemClickListener
    }
    override fun getItemCount() =dataList.size

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.setData(dataList[position])
        holder.itemView.setOnClickListener{
            itemClickListener?.onItemClickListener(position)
        }
    }

}