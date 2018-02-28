package com.dx.demi.archdiary.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dx.demi.archdiary.R
import com.dx.demi.archdiary.bean.Project
import com.dx.demi.archdiary.bean.Staff
import com.dx.demi.archdiary.bean.Work

/**
 * Created by demi on 2018/2/26.
 */
class WorkAdapter : BaseQuickAdapter<Work, BaseViewHolder> {

    constructor() : super(R.layout.item_work, null)

    constructor(list: List<Work>) : super(R.layout.item_work, list)

    override fun convert(helper: BaseViewHolder?, item: Work?) {
      var tv_work_daytime =  helper?.getView<TextView>(R.id.tv_work_daytime)
      var tv_work_duration =  helper?.getView<TextView>(R.id.tv_work_duration)
      var tv_work_salary =  helper?.getView<TextView>(R.id.tv_work_salary)
        tv_work_daytime?.setText(item?.daytime)
        tv_work_duration?.setText(item?.duration)
        tv_work_salary?.setText("${item?.money}元")

    }
}