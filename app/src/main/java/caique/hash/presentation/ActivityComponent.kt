package caique.hash.presentation

import caique.hash.ActivityScope
import caique.hash.presentation.main.HashActivity
import caique.hash.presentation.main.HashDependencies
import dagger.Subcomponent

/**
 * Created by Kanda on 11/06/2017.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(HashDependencies::class))
interface ActivityComponent {
    fun inject(activity: HashActivity)
}