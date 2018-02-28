package com.dx.demi.archdiary.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.dx.demi.archdiary.BaseApplication
import com.dx.demi.archdiary.R
import com.dx.demi.archdiary.adapter.StaffAdapter
import com.dx.demi.archdiary.bean.Project
import com.dx.demi.archdiary.bean.Staff
import com.dx.demi.archdiary.bean.Work
import com.dx.demi.archdiary.view.AddStaffDialog
import kotlinx.android.synthetic.main.activity_staff.*
import kotlinx.android.synthetic.main.dialog_add_staff.*

class StaffActivity : AppCompatActivity() {
    private var mAdapter: StaffAdapter? = null
    private var mdatas = ArrayList<Staff>()
    private var proj: Project? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff)
        proj = intent.extras["proj"] as Project
        toolbar.title = proj!!.projName
        setSupportActionBar(toolbar)// 将 Toolbar 的实例传入
        float_button.setOnClickListener(
                View.OnClickListener {
                    var dialog = AddStaffDialog(this)
                    dialog.tv_do.setOnClickListener(View.OnClickListener {
                        dialog.dismiss()
                        var name = dialog.et_staff_name.text.toString()
                        var salary: Double = dialog.et_staff_salary.text.toString().toDouble()
                        var age: Int = dialog.et_staff_age.text.toString().toInt()
                        var level = dialog.spinner_level.selectedItem.toString()
                        var aStaff = Staff(name, proj!!.id, age, salary, level, 0.00)
                        mdatas.add(aStaff)
                        mAdapter?.notifyDataSetChanged()
                        BaseApplication.getDaoInstant().insert(aStaff)
                    })
                    dialog.show()
                }
        )
        initData()
        mAdapter?.setOnItemClickListener { adapter, view, position ->
            var intent = Intent(this, WorkActivity::class.java)
            var staff: Staff = adapter.getItem(position) as Staff
            intent.putExtra("staff", staff)
            startActivity(intent)
        }
    }

    fun initData() {
        var list: List<Staff> = BaseApplication.getDaoInstant().queryBuilder(Staff::class.java).where(BaseApplication.getDaoInstant().staffDao.properties[1].eq(proj!!.id)).list()
        mdatas.addAll(list)
        mAdapter = StaffAdapter(mdatas)
        recy_view.layoutManager = LinearLayoutManager(this)
        recy_view.adapter = mAdapter
        swip_layout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            mdatas.clear()
            var list: List<Staff> = BaseApplication.getDaoInstant().queryBuilder(Staff::class.java).where(BaseApplication.getDaoInstant().staffDao.properties[1].eq(proj!!.id)).list()
            mdatas.addAll(list)
            mAdapter!!.notifyDataSetChanged()
            swip_layout.isRefreshing = false
        })
    }
}
