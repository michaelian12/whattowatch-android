package com.michaelagustian.whattowatch.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by Michael Agustian on 21/10/18.
 */

abstract class BaseFragment : Fragment(), BaseView {

    protected var contextFragment: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contextFragment = activity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(getResourceLayout(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onViewReady(savedInstanceState)
    }

    protected abstract fun getResourceLayout(): Int

    protected abstract fun onViewReady(savedInstanceState: Bundle?)

    override fun showMessage(message: String?) {
        if (message != null) {
            if (message.isNotBlank())
                Toast.makeText(contextFragment, message, Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(contextFragment, "An error occurred", Toast.LENGTH_SHORT).show()
    }
}