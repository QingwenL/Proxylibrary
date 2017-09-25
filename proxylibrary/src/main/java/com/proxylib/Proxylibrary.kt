package com.proxylib

import android.content.Context
import com.proxylib.proxy.ControlProxy

/**
 * @ClassName:     [commonlib.lib.Common]
 * @Description:   初始化异步代理库
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/12 10:42
 */
open class Proxylibrary {
    companion object {
        @JvmStatic fun init(context: Context){
            ControlProxy.init(context)
        }
    }
}