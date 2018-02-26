package com.dx.demi.archdiary.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.dx.demi.archdiary.R
import kotlinx.android.synthetic.main.activity_projects.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        setSupportActionBar(toolbar)// 将 Toolbar 的实例传入
    }
}
