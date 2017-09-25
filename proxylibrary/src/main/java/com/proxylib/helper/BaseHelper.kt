package com.commonlib.lib.helper

import com.commonlib.lib.control.BaseControl
import com.commonlib.lib.handler.BaseHandler
import com.proxylib.proxy.ControlProxy
import java.lang.reflect.ParameterizedType
import com.commonlib.lib.handler.MessageProxy
import java.lang.reflect.Type


/**
 * @ClassName:     [com.commonlib.lib.helper.BaseHelper]
 * @Description:   顶级帮助类，用来获取目标中的泛型生成动态代理类
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/6 15:17
 */
open class BaseHelper<T : BaseControl,  R : Any>( r: R,private var bh: BaseHandler<*>){

    /**
     * BaseControl
     */
    var t: T?  = null
    var mp:MessageProxy? = null

    init {
        initClass(r.javaClass.genericSuperclass)
        if(t == null ){
            initClass(r.javaClass.superclass.genericSuperclass)
        }
    }

   private fun initClass(superClass:Type){
        if(superClass is  ParameterizedType){
            var typeArguments  =  superClass.actualTypeArguments
            for ( type in typeArguments){
                if(type is Class<*>){
                    var  entityClass  =  type as  Class<T>
                    mp =  MessageProxy(bh)
                    t =  ControlProxy.generateProxy(entityClass,mp)
                }
            }
        }
    }

   open fun onCreate() {
         t?.onCreate()
   }
    open fun onStart() {
        t?.onStart()
    }
    open fun onResume() {
       t?.onResume()
    }
    open fun onPause() {
        t?.onPause()
    }
    open fun onStop() {
         t?.onStop()
    }
    open fun onDestroy() {
        t?.onDestroy()
    }



}