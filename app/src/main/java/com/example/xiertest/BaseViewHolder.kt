package com.example.xiertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


abstract class BaseViewHolder<M>(view : View):RecyclerView.ViewHolder(view) {
    protected fun <T:View> getView(viewId:Int):T{
        return itemView.findViewById<T>(viewId)
    }
    abstract fun setData(data:M)
}