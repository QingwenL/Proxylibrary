package com.commonlib.lib.handler

import android.app.Activity
import android.content.Context

/**
 * @ClassName:     [com.commonlib.lib.handler.ActivityHandler]
 * @Description:   BaseHandler 继承类 ActivityHandler
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/6 14:47
 */
open class ActivityHandler : BaseHandler<Activity>{

    constructor(r: Activity) : super(r)


    override fun getContext(): Context {
        return wr.get() as Context
    }

    override fun getReflectTarget(): Activity {
         val activity:Activity? =  wr.get()
        if(activity == null || activity.isFinishing){
            throw RuntimeException("Activity Not allowed to be empty")
        }
        return activity
    }



}