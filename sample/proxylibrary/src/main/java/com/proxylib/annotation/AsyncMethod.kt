package com.proxylib.annotation

/**
 * @ClassName:     [commonlib.lib.annotation.AsyncMethod]
 * @Description:   异步注解
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/7 16:04
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
@MustBeDocumented
annotation class AsyncMethod
