package caique.hash.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import caique.hash.presentation.HashApplication
import caique.hash.presentation.ActivityComponent

/**
 * Created by Kanda on 11/06/2017.
 */
open class BaseActivity : AppCompatActivity() {
    private lateinit var component: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initComponent()
    }

    private fun initComponent() {
        component = getMainApplication().hashComponent
                .activityComponent()
    }

    protected fun getMainApplication(): HashApplication {
        return application as HashApplication
    }

    protected fun getComponent(): ActivityComponent {
        return component
    }
}