package com.example.misrecetasapplication

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle

class Application : android.app.Application(), ActivityLifecycleCallbacks {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
        //Cookie Manager
    }

    /**
     * Adds session cookie to headers if exists.
     *
     * @param headers
     */

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    override fun onActivityStarted(activity: Activity) {}
    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}


}