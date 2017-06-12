package caique.hash.presentation

import android.app.Application
import caique.hash.HashComponent

/**
 * Created by Kanda on 11/06/2017.
 */
class HashApplication : Application() {

    lateinit var hashComponent: HashComponent

    override fun onCreate() {
        super.onCreate()

    }
}