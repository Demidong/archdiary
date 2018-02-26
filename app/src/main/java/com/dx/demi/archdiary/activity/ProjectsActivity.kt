package com.dx.demi.archdiary.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.dx.demi.archdiary.R
import com.dx.demi.archdiary.view.AddProjectDialog
import com.dx.demi.archdiary.adapter.ProjectsAdapter
import com.dx.demi.archdiary.bean.Project
import kotlinx.android.synthetic.main.activity_projects.*
import kotlinx.android.synthetic.main.dialog_add_project.*
import java.util.*

/**
 * Created by demi on 2018/2/26.
 */
class ProjectsActivity : AppCompatActivity() {
    private var mAdapter : ProjectsAdapter? = null
    private var mdatas = ArrayList<Project>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        setSupportActionBar(toolbar)
        float_button.setOnClickListener(
                View.OnClickListener {
                    var dialog = AddProjectDialog(this)
                    dialog.tv_do.setOnClickListener(View.OnClickListener {
                        dialog.dismiss()
                        var aProj =  Project(100,dialog.et_proj_name.text.toString(), dialog.spinner_state.selectedItem.toString(), dialog.et_proj_host.text.toString(),  dialog.et_proj_des.text.toString())
                        mdatas.add(0,aProj)
                        mAdapter?.notifyDataSetChanged()
                        recy_view.scrollToPosition(0)
                    })
                    dialog.show()
                }
        )
        initData()
        mAdapter?.setOnItemClickListener {adapter, view, position ->
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    fun Context.toast(mess: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, mess, length).show()
    }

    fun initData() {
        var aProj = Project(0,"大源冲村篮球场", "在建", "董城乡",  "由一帮年轻人捐款建的")
        var bProj = Project(1,"柴坝篮球场", "完成", "董秋平",  "由一帮年轻人捐款建的")
        var cProj = Project(2,"石峡篮球场", "工钱未结清", "董云华",  "由一帮年轻人捐款建的")
        mdatas.add(aProj)
        mdatas.add(bProj)
        mdatas.add(cProj)
        for (i in 3 until 20){
            var aProj = Project(i.toLong(),"大源冲村篮球场", "在建", "董城乡",  "由一帮年轻人捐款建的")
            mdatas.add(aProj)
        }
        mAdapter = ProjectsAdapter(mdatas)
        recy_view.layoutManager = LinearLayoutManager(this)
        recy_view.adapter = mAdapter

    }
}