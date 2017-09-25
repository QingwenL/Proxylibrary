package com.proxylib.proxy

import android.content.Context

import com.commonlib.lib.handler.MessageProxy
import com.google.dexmaker.stock.ProxyBuilder
import java.io.File


/**
 * @ClassName:     [commonlib.lib.proxy.ControlProxy]
 * @Description:   生成动态代理Control类
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/8 10:15
 */
class ControlProxy {

    companion object {

        var dexFile:File? = null

        @JvmStatic  fun init(context:Context){
            dexFile = context.getDir("dx",Context.MODE_PRIVATE)
        }


        @JvmStatic  fun  <T> generateProxy(entityClass : Class<T>, mp:MessageProxy?) :T {
             if(dexFile === null) throw RuntimeException("not initialized")
             var pb:ProxyBuilder<T> = ProxyBuilder.forClass(entityClass)
             pb.constructorArgTypes(mp?.javaClass).constructorArgValues(mp) // 构造器类型/参数
             pb.dexCache(dexFile)
             pb.handler(StandardInvocation(mp))
            var t:T
            try {
                t = pb.build()
            }catch (e:Exception){
                throw RuntimeException("Generate ControlProxy Failed")
            }
            return t
        }
    }

}