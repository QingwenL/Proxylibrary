package com.proxylib.handler

import android.content.Context
import android.support.v4.app.Fragment
import com.commonlib.lib.handler.BaseHandler

/**
 * @ClassName:     [com.proxylib.handler.FragmentHandler]
 * @Description:    继承BaseHandler
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/25 9:37
 */
class FragmentHandler : BaseHandler<Fragment>{

    constructor(r: Fragment) : super(r)

    override fun getContext(): Context {
        return  wr.get()?.activity as Context
    }

    override fun getReflectTarget(): Fragment {
        val mFragment:Fragment? =  wr.get()
        if(mFragment == null || mFragment.isRemoving){
            throw RuntimeException("mFragment Not allowed to be empty")
        }
        return mFragment
    }
}