package com.app.sample.mian

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.app.sample.entity.TestClass
import com.commonlib.lib.base.BaseAsyncActivity

import com.example.R
import com.example.control.MainControl
import com.proxylib.annotation.AsyncMethod
import com.afollestad.materialdialogs.MaterialDialog



/**
 * @ClassName:     [com.app.sample.mian.MainActivity]
 * @Description:   首页
 * @author          Liqingwen
 * @version         V1.0
 * @Date            2017/9/12 10:42
 */
class MainActivity : BaseAsyncActivity<MainControl>() {

    var button1:Button? = null
    var button2:Button? = null
    var loadingDialog:MaterialDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.button1) as Button
        button2= findViewById(R.id.button2) as Button

        loadingDialog = MaterialDialog.Builder(this)
                .content("正在加载...")
                .progress(true, 0)
                .progressIndeterminateStyle(true)
                .build()

        button1?.setOnClickListener(View.OnClickListener {
                mControl?.asyncMethod()
            loadingDialog?.show()
        })

        button2?.setOnClickListener(View.OnClickListener {
                mControl?.syncMethod()
        })
    }

    /**
     * 异步方法
     */
    open fun asyncMethod(mTestClass: TestClass){
        Toast.makeText(this,"我是异步有参方法, 我名字是${mTestClass.name}" ,Toast.LENGTH_LONG).show()
        loadingDialog?.dismiss()
    }

    /**
     * 同步方法
     */
    open fun syncMethod(){
        Toast.makeText(this,"我是同步方法",Toast.LENGTH_LONG).show()
    }


}
