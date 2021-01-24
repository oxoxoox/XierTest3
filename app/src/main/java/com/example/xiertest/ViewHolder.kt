package com.example.xiertest

import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ViewHolder(view: View):BaseViewHolder<Conversation>(view) {
    val itemImage:ImageView=getView(R.id.itemImage)
    val itemName:TextView=getView(R.id.itemName)
    val itemHolderName:TextView=getView(R.id.itemHolderName)
    override fun setData(data: Conversation) {
        itemImage.setImageResource(data.imageId)
        itemName.text=data.name
        itemHolderName.text=data.holderName
    }
}