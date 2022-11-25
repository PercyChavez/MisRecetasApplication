package com.example.misrecetasapplication

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.Toolbar
import java.util.ArrayList

open class ActivityBase : AppCompatActivity() {

    var pDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pDialog = ProgressDialog(this)
        pDialog!!.setCancelable(false)
        pDialog!!.setCanceledOnTouchOutside(false)
    }

    protected var handler = Handler()
    var run = ArrayList<Runnable>()
    var onPause = false
    protected fun resumeTasks() {
        for (ru in run) {
            handler.post(ru)
        }
        run.clear()
    }

    override fun onPause() {
        super.onPause()
        onPause = true
    }

    override fun onResume() {
        super.onResume()
        onPause = false
        resumeTasks()
    }

    protected fun responseAction(op: Boolean, function: () -> Unit) {
        if(op){
            run.add(Runnable {
                function()
            })
        }else{
            function()
        }
    }

    fun initToolbar(Toolbar: Toolbar){
        setSupportActionBar(Toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun showLoader(msj: String?) {
        pDialog!!.setMessage(msj)
        if (!isFinishing && pDialog != null) pDialog!!.show()
    }

    fun dismissLoader() {
        if (!isFinishing && pDialog != null) pDialog!!.dismiss()
    }

}