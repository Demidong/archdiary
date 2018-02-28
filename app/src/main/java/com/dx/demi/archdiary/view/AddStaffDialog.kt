package com.dx.demi.archdiary.view

import android.content.Context
import android.support.design.widget.BottomSheetDialog
import android.view.View
import android.view.Window
import com.dx.demi.archdiary.R
import kotlinx.android.synthetic.main.dialog_add_project.*

/**
 * Created by demi on 2018/2/26.
 */
class AddStaffDialog : BottomSheetDialog {

    constructor(context:Context) :super(context){
        this@AddStaffDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = layoutInflater.inflate(R.layout.dialog_add_staff, null, false)
        setContentView(view)
        tv_cancel.setOnClickListener(View.OnClickListener { dismiss() })
    }

}