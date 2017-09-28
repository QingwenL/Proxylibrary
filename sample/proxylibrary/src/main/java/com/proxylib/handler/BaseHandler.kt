package com.commonlib.lib.handler

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import java.lang.ref.WeakReference
import java.lang.reflect.Method
/**
 * @ClassName:     [com.commonlib.lib.handler.BaseHandler]
 * @Description:   封装的Handler
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/5 14:20
 */
open abstract  class BaseHandler<R : Any>(var r: R) : Handler() , IContext<R>  {

    /**
     * 使用软引用来避免内存泄露“会出现Handle一直持有Activity引用 ”
     */
     var wr = WeakReference<R>(r)

    override fun handleMessage(msg: Message?) {
        super.handleMessage(msg)
           var  r: R  = getReflectTarget()
        when(msg?.what){
             //  What.SHOW_PROGRESS  -> showProgress(false,"$msg.obj") TODO 未实现
            //  What.SHOW_CANCELABLE_PROGRESS  -> showProgress(true,"$msg.obj") TODO 未实现
               What.REFLEX  -> invoke(r,msg)
               What.NO_PARAMETERS_REFLEX  -> invokeNoParam(r,msg)
        }
    }






    /**
     * 反射R
     * @param r
     * @param msg 参数
     */
    private  fun  invokeNoParam(r : R, msg: Message){
        val mClass: Class<out R> = r::class.java //r.javaClass.kotlin
        val method:Method
        try{
            method = mClass.getMethod(msg.obj.toString())
            method.isAccessible = true // 提高反射速度
            method.invoke(r)
        }catch (e:Exception){ // 直接跑出异常
            throw  RuntimeException("Reflex failed")
        }
    }


    /**
     * 反射R
     * @param r
     * @param msg 参数
     */
    private   fun  invoke(r : R, msg: Message){
        var mClass: Class<out R> = r::class.java //r.javaClass.kotlin
        var bundle:Bundle = msg.data
        var method:Method
        var any:Any
        try{
            any = bundle.getSerializable("name")
            method = mClass.getMethod(msg.obj.toString(),any.javaClass)
            method.isAccessible = true // 提高反射速度
            method.invoke(r,any)
      }catch (e:Exception){ // 直接跑出异常
            e.printStackTrace()
//            throw  RuntimeException("Reflex failed")
      }
    }


}