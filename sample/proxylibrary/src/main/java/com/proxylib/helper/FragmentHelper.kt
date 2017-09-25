package com.proxylib.helper

import com.commonlib.lib.control.BaseControl
import com.commonlib.lib.helper.BaseHelper
import com.proxylib.base.BaseAsyncFragment
import com.proxylib.handler.FragmentHandler

/**
 * @ClassName:     [com.proxylib.helper.FragmentHelper]
 * @Description:    继承顶级帮助类，用来获取目标Fragment中的泛型生成动态代理类
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/25 9:35
 */
class FragmentHelper<T : BaseControl, R : BaseAsyncFragment<T>> : BaseHelper<T,R> {

    constructor(r: R) : super(r, FragmentHandler(r))

    fun  getBaseControl() : T?{
        return t
    }
}