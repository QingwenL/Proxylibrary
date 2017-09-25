package com.commonlib.lib.handler

import android.content.Context

/**
 * @ClassName:     [com.commonlib.lib.handler.IContext]
 * @Description:   TODO 实现 Context接口
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/5 15:32
 */
open interface IContext<R> {

    /**
     * 拿到当前Context
     */
     fun getContext() : Context

    /**
     * 获取反射目标
     */
     fun getReflectTarget() : R



}