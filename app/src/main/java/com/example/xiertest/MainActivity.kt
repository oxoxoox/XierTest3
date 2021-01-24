//将ViewHolder和Adapter封装成BaseViewHolder和BaseAdapter
package com.example.xiertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val conversationList=ArrayList<Conversation>()
    private var i = R.drawable.pic_1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager=LinearLayoutManager(this)
        manager.orientation=RecyclerView.VERTICAL
        recyclerView.layoutManager=manager
        val adapter=ConversationAdapter(conversationList)
        recyclerView.adapter=adapter
        adapter!!.setOnKotlinItemClickListener(object : BaseAdapter.IKotlinItemClickListener {
            override fun onItemClickListener(position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                var bundle = Bundle()
                bundle.putString("name", conversationList[position].name)
                bundle.putString("holderName", conversationList[position].holderName)
                bundle.putInt("Image", conversationList[position].imageId)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, AddActivity::class.java)
        when (item.itemId) {
            R.id.add_item -> startActivityForResult(intent, 1)
            R.id.delete_item -> deleteItem()
            R.id.quit -> finish()
        }
        return true
    }
    private fun deleteItem() {
        conversationList.clear()
        recyclerView.adapter?.notifyDataSetChanged()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                var bundle = data?.extras
                if (bundle != null) {
                    initItem(bundle.get("name").toString(), bundle.get("holderName").toString())
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            }
        }
    }
    private fun initItem(name: String, holderName: String) {
        conversationList.add(0,Conversation(name, holderName, i++))
    }
}