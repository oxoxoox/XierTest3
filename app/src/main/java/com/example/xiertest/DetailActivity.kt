package com.example.xiertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val bundle=intent.extras
        if (bundle != null) {
            itemName.text=bundle.get("name").toString()
            itemHolderName.text=bundle.get("holderName").toString()
            itemImage.setImageResource(bundle.get("Image") as Int)
        }
    }
}