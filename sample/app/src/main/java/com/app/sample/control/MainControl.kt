package com.example.control

import android.os.Bundle
import com.app.sample.entity.TestClass

import com.commonlib.lib.control.BaseControl
import com.commonlib.lib.handler.MessageProxy
import com.proxylib.annotation.AsyncMethod
import junit.framework.TestCase

/**
 * @ClassName:     [com.app.sample.mian.MainActivity]
 * @Description:   代理类
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/12 10:42
 */
open class MainControl(mMessageProxy: MessageProxy) : BaseControl(mMessageProxy){

    /**
     * 异步方法
     */
    @AsyncMethod()
    open fun asyncMethod(){
        var ts = TestClass()
        ts.account = "18576787887"
        ts.name = "Lemon Tree"
        Thread.sleep(5000)
        callMethod("asyncMethod",ts)
    }

    /**
     * 同步方法
     */
    open fun syncMethod(){
        callMethod("syncMethod")
    }

}
