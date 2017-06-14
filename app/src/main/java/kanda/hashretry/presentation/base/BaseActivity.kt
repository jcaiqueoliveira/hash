package kanda.hashretry.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kanda.hashretry.presentation.ActivityComponent
import kanda.hashretry.presentation.MainApplication

/**
 * Created by Kanda on 11/06/2017.
 */
open class BaseActivity : AppCompatActivity() {
    var component: ActivityComponent? = null
        get() {
            return getMainApplication().component
                    .activityComponent()
        }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }


    protected fun getMainApplication(): MainApplication {
        return application as MainApplication
    }

}