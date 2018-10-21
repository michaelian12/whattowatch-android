package com.michaelagustian.whattowatch.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast

/**
 * Created by Michael Agustian on 21/10/18.
 */

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResourceLayout())
        onViewReady(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    protected abstract fun getResourceLayout(): Int

    protected abstract fun onViewReady(savedInstanceState: Bundle?)

    protected fun setupToolbar(toolbar: Toolbar, needHomeButton: Boolean = false) {
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.apply {
                setHomeButtonEnabled(true)
                setDisplayHomeAsUpEnabled(needHomeButton)
                setDisplayShowTitleEnabled(false)
            }
        }
    }

    override fun showMessage(message: String?) {
        if (message != null) {
            if (message.isNotBlank())
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show()
    }
}