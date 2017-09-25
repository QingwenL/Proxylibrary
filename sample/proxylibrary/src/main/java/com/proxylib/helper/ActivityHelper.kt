package com.commonlib.lib.helper

import com.commonlib.lib.base.BaseAsyncActivity
import com.commonlib.lib.control.BaseControl
import com.commonlib.lib.handler.ActivityHandler

/**
 * @ClassName:     [com.commonlib.lib.helper.ActivityHelper]
 * @Description:  继承顶级帮助类，用来获取目标Activity中的泛型生成动态代理类
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/6 15:48
 */
class ActivityHelper<T : BaseControl, R : BaseAsyncActivity<T>> : BaseHelper<T,R> {

    constructor(r: R) : super(r, ActivityHandler(r))

    fun  getBaseControl() : T?{
            return t
    }

}