package com.proxylib.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.commonlib.lib.control.BaseControl
import com.proxylib.helper.FragmentHelper

/**
 * @ClassName:     [com.proxylib.base.BaseAsyncFragment]
 * @Description:   异步Frgament
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/25 9:42
 */
class BaseAsyncFragment<T : BaseControl> : Fragment{

    private  var fH:FragmentHelper<T,BaseAsyncFragment<T>>? = null
    protected  var mControl:T? = null

    constructor() : super()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fH = FragmentHelper(this)
        mControl = fH?.getBaseControl()
        mControl?.onCreate()
    }


    override fun onResume() {
        super.onResume()
        mControl?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mControl?.onResume()
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