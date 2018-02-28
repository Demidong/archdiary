package com.dx.demi.archdiary.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.dx.demi.archdiary.R
import com.dx.demi.archdiary.bean.Project
import com.dx.demi.archdiary.bean.Staff

/**
 * Created by demi on 2018/2/26.
 */
class StaffAdapter : BaseQuickAdapter<Staff, BaseViewHolder> {

    constructor() : super(R.layout.item_staff, null)

    constructor(list: List<Staff>) : super(R.layout.item_staff, list)

    override fun convert(helper: BaseViewHolder?, item: Staff?) {
      var tv_staff_name =  helper?.getView<TextView>(R.id.tv_staff_name)
      var tv_staff_age =  helper?.getView<TextView>(R.id.tv_staff_age)
      var tv_staff_level =  helper?.getView<TextView>(R.id.tv_staff_level)
      var tv_staff_salary =  helper?.getView<TextView>(R.id.tv_staff_salary)
        tv_staff_name?.setText(item?.name)
        tv_staff_age?.setText("${item?.age}岁")
        tv_staff_level?.setText(item?.level)
        tv_staff_salary?.setText("${item?.salary}元/日")

    }
}