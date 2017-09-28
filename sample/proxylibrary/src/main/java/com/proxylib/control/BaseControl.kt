package com.commonlib.lib.control

import android.os.Bundle
import android.os.Message
import android.util.Log
import com.commonlib.lib.handler.MessageProxy
import com.commonlib.lib.handler.What

/**
 * @ClassName:     [com.commonlib.lib.control.BaseControl]
 * @Description:   顶级控制类
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/6 14:57
 */
open class BaseControl(private  var  mp: MessageProxy)  {

    fun onCreate() {
    }
    fun onStart() {

    }
    fun onResume() {

    }
    fun onPause() {

    }
    fun onStop() {

    }

    fun onDestroy(){
        removeMessages(What.SHOW_PROGRESS)
        removeMessages(What.SHOW_CANCELABLE_PROGRESS)
        removeMessages(What.HIDE_DIALOG)
        removeMessages(What.REFLEX)
        removeMessages(What.NO_PARAMETERS_REFLEX)
        removeCallbacksAndMessages()
    }



    fun obtionMessage(what: Int): Message {
        return mp.obtionMessage(what)
    }


    /**
     * 执行成功有参反射
     * @param method 方法
     * @param bundle 参数
     */
    fun callMethod(method:String,any: Any){
        mp.callMethod(method,any)
    }


    /**
     * 执行无参 反射
     * @param method
     */
    fun callMethod(method:String){
        mp.callMethod(method)
    }


    fun sendMessage(msg: Message) {
        mp.sendMessage(msg)
    }

    fun sendMessageDelayed(msg: Message, delayMillis: Long) {
        mp.sendMessageDelayed(msg, delayMillis)
    }

    fun postRunnableDelayed(runnable: Runnable, delayMillis: Long) {
        mp.postRunnableDelayed(runnable, delayMillis)
    }

    fun postRunnable(runnable: Runnable) {
        mp.postRunnable(runnable)
    }

    fun removeRunnable(r: Runnable) {
        mp.removeRunnable(r)
    }

    fun removeCallBack(runnable: Runnable) {
        mp.removeCallBack(runnable)
    }
    fun removeMessages(what:Int) {
        mp.removeMessages(what)
    }

    fun  removeCallbacksAndMessages(){
        mp.removeCallbacksAndMessages()
    }

    /**
     * 显示可取消Dialog
     * @param text
     */
    fun showCancelabledialog(text:String){
        mp.showCancelabledialog(text)
    }

    /**
     * 显示Dialog
     * @param text
     */
    fun showDialog(text:String){
        mp.showDialog(text)
    }

    /**
     * 隐藏Dialog
     */
    fun hideDialog(){
        mp.hideDialog()
    }

    
    

}