package com.dx.demi.archdiary.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.dx.demi.archdiary.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by demi on 2018/2/26.
 */
class ProjectsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        float_button.setOnClickListener(View.OnClickListener { toast("点击button了") })
    }

    fun Context.toast(mess: String, length : Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, mess, length).show()
    }
}