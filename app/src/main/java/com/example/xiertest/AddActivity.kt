package com.example.xiertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        editFinish.setOnClickListener(this)
    }
    override fun onClick(v: View?){
        when(v?.id){
            R.id.editFinish ->{
                val inputText1=editName.text.toString()
                val inputText2=editHolder.text.toString()
                var bundle =  Bundle()
                bundle.putString("name",inputText1)
                bundle.putString("holderName",inputText2)
                val intent = Intent()
                intent.putExtras(bundle)
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}