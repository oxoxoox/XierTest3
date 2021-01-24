package com.example.xiertest

import android.view.LayoutInflater
import android.view.ViewGroup

class ConversationAdapter(val conversationList: List<Conversation>):
        BaseAdapter<Conversation, ViewHolder>(conversationList)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
                .inflate(R.layout.item_linear,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount()=conversationList.size
}