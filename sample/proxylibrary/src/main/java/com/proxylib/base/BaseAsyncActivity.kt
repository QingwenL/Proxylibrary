package com.commonlib.lib.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.commonlib.lib.control.BaseControl
import com.commonlib.lib.helper.ActivityHelper

/**
 * @ClassName:     [com.proxylib.base.BaseAsyncActivity]
 * @Description:   异步Activity
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/25 9:42
 */
open class BaseAsyncActivity< T : BaseControl> : AppCompatActivity() {

    private  var ah: ActivityHelper<T,BaseAsyncActivity<T>>? = null
    protected  var mControl:T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ah = ActivityHelper(this)
        mControl = ah?.getBaseControl()
        mControl?.onCreate()
    }

    override fun onResume() {
        super.onResume()
       mControl?.onResume()
    }
    override fun onStart() {
        super.onStart()
      mControl?.onStart()

    }
    override fun onPause() {
        super.onPause()
      mControl?.onPause()
    }
    override fun onStop() {
        super.onStop()
       mControl?.onStop()
    }
    override fun onDestroy() {
        super.onDestroy()
       mControl?.onDestroy()
    }






}
