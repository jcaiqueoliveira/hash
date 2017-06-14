package kanda.hashretry.presentation

import kanda.hashretry.presentation.main.HashDependencies
import dagger.Subcomponent
import kanda.hashretry.presentation.main.MainActivity

/**
 * Created by Kanda on 11/06/2017.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(HashDependencies::class))
interface ActivityComponent {
    fun inject(activity: MainActivity)
}