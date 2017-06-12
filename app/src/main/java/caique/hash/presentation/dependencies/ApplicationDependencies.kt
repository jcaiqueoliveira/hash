package caique.hash.presentation.dependencies

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by Kanda on 11/06/2017.
 */
@Module
class ApplicationDependencies(internal var application: Application) {

    @Provides
    @Reusable
    fun providesContext(): Context {
        return application.baseContext
    }
}
