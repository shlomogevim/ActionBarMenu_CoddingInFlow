package com.example.actionbarmenu_coddinginflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Callable

class MainActivity : AppCompatActivity() {

     var mActionMode: ActionMode?=null

    private val mActionModeCallBack = object : ActionMode.Callback {

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            when (item?.itemId) {
                R.id.option_1 -> {
                    Toast.makeText(this@MainActivity, "Option 1 selected", Toast.LENGTH_SHORT)
                        .show()
                    return true
                }
                R.id.option_2 -> {
                    Toast.makeText(this@MainActivity, "Option 2 selected", Toast.LENGTH_SHORT)
                        .show()
                    return true
                }
                else -> return false
            }
        }

        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.example_menu, menu)
            mode?.setTitle("choose your option")
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
          mActionMode=null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view.setOnLongClickListener {
            if (mActionMode != null) {
                return@setOnLongClickListener false //actionMOde exist
            }
            mActionMode = startActionMode(mActionModeCallBack)
            return@setOnLongClickListener true
        }
    }

}


/*class MainActivity : AppCompatActivity() {

    var mActionMode: ActionMode?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view.setOnLongClickListener {
            if (mActionMode != null) {
                return@setOnLongClickListener false //actionMOde exist
            }
            mActionMode = startActionMode(object :ActionMode.Callback{

                override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDestroyActionMode(mode: ActionMode?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
            return@setOnLongClickListener true
        }
    }

}*/
