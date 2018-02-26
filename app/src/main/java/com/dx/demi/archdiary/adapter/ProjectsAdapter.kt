package com.dx.demi.archdiary.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dx.demi.archdiary.R
import com.dx.demi.archdiary.bean.Project

/**
 * Created by demi on 2018/2/26.
 */
class ProjectsAdapter : BaseQuickAdapter<Project, BaseViewHolder> {

    constructor() : super(R.layout.item_project, null)

    constructor(list: List<Project>) : super(R.layout.item_project, list)

    override fun convert(helper: BaseViewHolder?, item: Project?) {
      var tv_proj_name =  helper?.getView<TextView>(R.id.tv_proj_name)
      var tv_proj_host =  helper?.getView<TextView>(R.id.tv_proj_host)
      var tv_proj_state =  helper?.getView<TextView>(R.id.tv_proj_state)
      var tv_proj_des =  helper?.getView<TextView>(R.id.tv_proj_des)
        tv_proj_name?.setText(item?.projName)
        tv_proj_host?.setText(item?.projHost)
        tv_proj_state?.setText(item?.projState)
        tv_proj_des?.setText(item?.projDescrib)

    }
}