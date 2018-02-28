package com.dx.demi.archdiary.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.dx.demi.archdiary.BaseApplication
import com.dx.demi.archdiary.R
import com.dx.demi.archdiary.adapter.ProjectsAdapter
import com.dx.demi.archdiary.bean.Project
import com.dx.demi.archdiary.view.AddProjectDialog
import kotlinx.android.synthetic.main.activity_projects.*
import kotlinx.android.synthetic.main.dialog_add_project.*

/**
 * Created by demi on 2018/2/26.
 */
class ProjectsActivity : AppCompatActivity() {
    private var mAdapter: ProjectsAdapter? = null
    private var mdatas = ArrayList<Project>()
    private var lastTime: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        setSupportActionBar(toolbar)
        float_button.setOnClickListener(
                View.OnClickListener {
                    var dialog = AddProjectDialog(this)
                    dialog.tv_do.setOnClickListener(View.OnClickListener {
                        dialog.dismiss()
                        var aProj = Project(dialog.et_proj_name.text.toString(), dialog.spinner_state.selectedItem.toString(), dialog.et_proj_host.text.toString(), dialog.et_proj_des.text.toString())
                        mdatas.add(0, aProj)
                        mAdapter?.notifyDataSetChanged()
                        recy_view.scrollToPosition(0)
                        BaseApplication.getDaoInstant().insert(aProj)
                    })
                    dialog.show()
                }
        )
        initData()
        mAdapter?.setOnItemClickListener { adapter, view, position ->
            var intent = Intent(this, StaffActivity::class.java)
            var project: Project = adapter.getItem(position) as Project
            intent.putExtra("proj", project)
            startActivity(intent)
        }
    }

    fun Context.toast(mess: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, mess, length).show()
    }

    fun initData() {
        var list: List<Project> = BaseApplication.getDaoInstant().queryBuilder(Project::class.java).list().reversed()
        mdatas.addAll(list)
        mAdapter = ProjectsAdapter(mdatas)
        recy_view.layoutManager = LinearLayoutManager(this)
        recy_view.adapter = mAdapter
        swip_layout.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            mdatas.clear()
            var list: List<Project> = BaseApplication.getDaoInstant().queryBuilder(Project::class.java).list().reversed()
            mdatas.addAll(list)
            mAdapter!!.notifyDataSetChanged()
            swip_layout.isRefreshing = false
        })
    }

    override fun onBackPressed() {
        var time: Long = System.currentTimeMillis()

        if (time - lastTime > 2_000) {
            toast("再按一次退出程序")
        } else {
            finish()
        }
        lastTime = time
    }
}