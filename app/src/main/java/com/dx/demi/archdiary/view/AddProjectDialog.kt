package com.dx.demi.archdiary.view

import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.Window
import com.dx.demi.archdiary.R
import kotlinx.android.synthetic.main.dialog_add_project.*

/**
 * Created by demi on 2018/2/26.
 */
class AddProjectDialog :Dialog{

    constructor(context:Context) :super(context){
        this@AddProjectDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = layoutInflater.inflate(R.layout.dialog_add_project, null, false)
        setContentView(view)
        tv_cancel.setOnClickListener(View.OnClickListener { dismiss() })
    }

}