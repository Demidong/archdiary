package com.dx.demi.archdiary.view

import android.app.Activity
import android.content.Context
import android.support.design.widget.BottomSheetDialog
import android.view.View
import android.view.Window
import com.dx.demi.archdiary.R
import com.dx.demi.archdiary.utils.TimeFormatUtils
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.dialog_add_work.*

/**
 * Created by demi on 2018/2/26.
 */
class AddWorkDialog : BottomSheetDialog {

    constructor(context:Context) :super(context){
        this@AddWorkDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val view = layoutInflater.inflate(R.layout.dialog_add_work, null, false)
        setContentView(view)
        tv_cancel.setOnClickListener(View.OnClickListener { dismiss() })
        tv_work_daytime.setText(TimeFormatUtils.getDay(System.currentTimeMillis()))
    }

}