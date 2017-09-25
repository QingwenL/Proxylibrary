package com.proxylib.proxy

import android.os.Process
import com.commonlib.lib.handler.MessageProxy
import com.google.dexmaker.stock.ProxyBuilder
import com.proxylib.annotation.AsyncMethod
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * @ClassName:     [commonlib.lib.proxy.StandardInvocation]
 * @Description:   这是调用处理器接口，它自定义了一个 invoke 方法，用于集中处理在动态代理类对象上的方法调用，通常在该方法中实现对委托类的代理访问。
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/7 15:38
 */
class StandardInvocation(private val mMessageProxy:MessageProxy?) : InvocationHandler{

    /**
     * Executors.newCachedThreadPool 自动回收不使用的线程（终止并从缓存中移除那些已有 60 秒钟未被使用的线程），（在无可用线程的情况下）自动的为新来的task创建新线程。
     */
    private val  pool:ExecutorService = Executors.newCachedThreadPool()

    private  var  result: Any?  = null

    override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any? {
         val sm  = method?.getAnnotation(AsyncMethod::class.java)
        if(sm === null) return ProxyBuilder.callSuper(proxy,method,*args)

        /**
         * lambda 表达式
         * 一开始觉得lambda很高级完全看不懂，其实很简单的就是把接口名、方法名和参数类型省掉不写再加个->罢了，明白这点了很好理解。
         * // 无参数无返回值
         * Thread(Runnable {
         * sleep(1000)
         * }).start()
         * // 单参数不带返回值
         * view.setOnClickListener { v ->
         * Log.e("tag", "${v.tag}")
         * }
        // 多参数带返回值
         * view.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
         *  Log.e("tag", "keyCode$keyCode, ${event.keyCode}")
         *
         * return@OnKeyListener true
         * false
        })*/
        pool.execute{ Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)
                      result =  ProxyBuilder.callSuper(proxy,method,*args)
        }
        return result

    }




}