package com.dx.demi.archdiary.activity

import android.app.Activity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Spinner
import com.dx.demi.archdiary.BaseApplication
import com.dx.demi.archdiary.R
import com.dx.demi.archdiary.adapter.WorkAdapter
import com.dx.demi.archdiary.bean.Staff
import com.dx.demi.archdiary.bean.Work
import com.dx.demi.archdiary.view.AddWorkDialog
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.activity_staff.*
import kotlinx.android.synthetic.main.dialog_add_work.*

class WorkActivity : AppCompatActivity() {
    private var mAdapter: WorkAdapter? = null
    private var mdatas = ArrayList<Work>()
    private var staff: Staff? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        staff = intent.extras["staff"] as Staff
        toolbar.title = staff!!.name
        setSupportActionBar(toolbar)// 将 Toolbar 的实例传入
        float_button.setOnClickListener(
                View.OnClickListener {
                    var dialog = AddWorkDialog(this)
                    dialog.tv_do.setOnClickListener(View.OnClickListener {
                        dialog.dismiss()
                        var daytime = dialog.tv_work_daytime.text.toString()
                        var money: Double = dialog.tv_work_money.text.substring(0,dialog.tv_work_money.text.length-1).toDouble()
                        var level = dialog.spinner_duration.selectedItem.toString()
                        var work: Work = Work(staff!!.id, daytime, level, money)
                        mdatas.add(work)
                        mAdapter?.notifyDataSetChanged()
                        BaseApplication.getDaoInstant().insert(work)
                    })
                    dialog.tv_work_daytime.setOnClickListener(View.OnClickListener {
                        var timeDialog = DatePickerDialog()
                        timeDialog.show(getFragmentManager(),"dsad")
                        timeDialog.setOnDateSetListener( DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                            val date = "${year}年${monthOfYear + 1}月${dayOfMonth}日"
                            dialog.tv_work_daytime.setText(date)
                        })
                    })
                    dialog.spinner_duration.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {

                        override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                            if(i == 0){
                                dialog.tv_work_money.setText("${staff!!.salary}元")
                            }else{
                                dialog.tv_work_money.setText("${staff!!.salary/2}元")
                            }

                        }

                        override fun onNothingSelected(adapterView: AdapterView<*>) {
                            dialog.tv_work_money.setText("${staff!!.salary}元")
                        }
                    })
                    dialog.show()
                }
        )
        initData()
    }

    fun initData() {
        var list: List<Work> = BaseApplication.getDaoInstant().queryBuilder(Work::class.java).where(BaseApplication.getDaoInstant().workDao.properties[1].eq(staff!!.id)).list()
        mdatas.addAll(list)
        mAdapter = WorkAdapter(mdatas)
        recy_view.layoutManager = LinearLayoutManager(this)
        recy_view.adapter = mAdapter
        swip_layout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            mdatas.clear()
            var list: List<Work> = BaseApplication.getDaoInstant().queryBuilder(Work::class.java).where(BaseApplication.getDaoInstant().workDao.properties[1].eq(staff!!.id)).list()
            mdatas.addAll(list)
            mAdapter!!.notifyDataSetChanged()
            swip_layout.isRefreshing = false
        })
    }
}
