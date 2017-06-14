package kanda.hashretry.presentation

import kanda.hashretry.data.repository.local.DataSourceDependencies
import dagger.Component
import kanda.hashretry.presentation.dependencies.ApplicationDependencies
import javax.inject.Singleton

/**
 * Created by Kanda on 11/06/2017.
 */

@Singleton
@Component(modules = arrayOf(ApplicationDependencies::class, DataSourceDependencies::class))
interface HashComponent {
    fun activityComponent(): ActivityComponent
}