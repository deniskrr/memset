package com.citizenwarwick.memset.features.home

import MemsetMainTemplate
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.Button
import com.citizenwarwick.memset.router.Composer
import com.citizenwarwick.memset.router.goto

class HomeScreenComposer : Composer() {
    override fun compose() {
        MemsetMainTemplate {
            Container {
                Column {
                    Button(text = "Go to Card Editor", onClick = {
                        goto("http://memset.com/cardeditor")
                    })
                }
            }
        }
    }
}
