package com.norhan.cleanarchitecturedemo.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.norhan.cleanarchitecturedemo.application.ProjectApplication
import com.norhan.cleanarchitecturedemo.di.component.ApplicationComponent
import com.norhan.cleanarchitecturedemo.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

object AppInjector {
    private lateinit var appComponent: ApplicationComponent

    fun init(projectApplication: ProjectApplication) {
        appComponent = DaggerApplicationComponent.builder()
            .application(projectApplication)
            .build()

        appComponent.inject(projectApplication)
        projectApplication.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                //pass
            }

            override fun onActivityResumed(activity: Activity) {
                //pass
            }

            override fun onActivityPaused(activity: Activity) {
                //pass
            }

            override fun onActivityStopped(activity: Activity) {
                //pass
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
                //pass
            }

            override fun onActivityDestroyed(activity: Activity) {
                //pass
            }
        })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(
                        fm: FragmentManager,
                        f: Fragment,
                        savedInstanceState: Bundle?
                    ) {
                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true
            )
        }
    }
}