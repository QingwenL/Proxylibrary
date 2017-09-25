package com.commonlib.lib.handler

import android.os.Bundle
import android.os.Message


/**
 * @ClassName:     [com.commonlib.lib.handler.MessageProxy]
 * @Description:   Handler 代理
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/5 15:41
 */
class MessageProxy(private  var mBaseHandler: BaseHandler<*>){




    /**
     * 显示可取消Dialog
     * @param text
     */
    fun showCancelabledialog(text:String){
        var ms  = mBaseHandler.obtainMessage()
        ms.what = What.SHOW_CANCELABLE_PROGRESS
        ms.obj  = text
        mBaseHandler.sendMessage(ms)
    }


    /**
     * 执行成功有参反射
     * @param method 方法
     * @param bundle 参数
     */
    fun callMethod(method:String, bundle: Bundle){
        var ms  = mBaseHandler.obtainMessage()
        ms.what = What.REFLEX
        ms.obj  = method
        ms.data = bundle
        mBaseHandler.sendMessage(ms)
    }


    /**
     * 执行无参 反射
     * @param method
     */
    fun callMethod(method:String){
        var ms  = mBaseHandler.obtainMessage()
        ms.what = What.NO_PARAMETERS_REFLEX
        ms.obj  = method
        mBaseHandler.sendMessage(ms)
    }





    /**
     * 显示Dialog
     * @param text
     */
    fun showDialog(text:String){
        var ms  = mBaseHandler.obtainMessage()
        ms.what = What.SHOW_PROGRESS
        ms.obj  = text
        mBaseHandler.sendMessage(ms)
    }


    /**
     * 隐藏Dialog
     */
    fun hideDialog(){
        var ms  = mBaseHandler.obtainMessage()
        ms.what = What.HIDE_DIALOG
        mBaseHandler.sendMessage(ms)
    }


    fun obtionMessage(what: Int): Message {
        return mBaseHandler.obtainMessage(what)
    }

    fun sendMessage(msg: Message) {
        mBaseHandler.sendMessage(msg)
    }

    fun sendMessageDelayed(msg: Message, delayMillis: Long) {
        mBaseHandler.sendMessageDelayed(msg, delayMillis)
    }

    fun postRunnableDelayed(runnable: Runnable, delayMillis: Long) {
        mBaseHandler.postDelayed(runnable, delayMillis)
    }

    fun postRunnable(runnable: Runnable) {
        mBaseHandler.post(runnable)
    }

    fun removeRunnable(r: Runnable) {
        mBaseHandler.removeCallbacks(r)
    }

    fun removeCallBack(runnable: Runnable) {
        mBaseHandler.removeCallbacks(runnable)
    }

    fun removeMessages(what:Int) {
        mBaseHandler.removeMessages(what)
    }

    fun removeCallbacksAndMessages() {
        mBaseHandler.removeCallbacksAndMessages(null)
    }







}