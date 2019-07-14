package com.norhan.cleanarchitecturedemo.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.norhan.cleanarchitecturedemo.R
import com.norhan.cleanarchitecturedemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = getViewModel(MainViewModel::class.java)

        mainViewModel.initItemList()

        mainViewModel.items.observe(this, Observer {
            tv_status.text = it.responseType.toString()
            tv_response.text = it.data.toString()

        })
    }
}

