package caique.hash

import caique.hash.data.repository.local.DataSourceDependencies
import caique.hash.presentation.ActivityComponent
import caique.hash.presentation.dependencies.ApplicationDependencies
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Kanda on 11/06/2017.
 */

@Singleton
@Component(modules = arrayOf( ApplicationDependencies::class,DataSourceDependencies::class))
interface HashComponent {
    fun activityComponent(): ActivityComponent
}