package com.commonlib.lib.handler

/**
 * @ClassName:     [com.commonlib.lib.handler.Constant]
 * @Description:    Message What 类型枚举
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/5 16:41
 */
class  What {

    /**
     * 静态常量
     */
    companion object  {
        const  val SHOW_PROGRESS :Int  = 2     // 显示不可取消对话框
        const   val SHOW_CANCELABLE_PROGRESS :Int  = 3 // 显示可取消对话框
        const  val HIDE_DIALOG :Int  = 4 //  隐藏对话框
        const  val REFLEX  :Int  = 5      //  反射
        const  val NO_PARAMETERS_REFLEX  :Int  = 6      //  无参反射
    }



}