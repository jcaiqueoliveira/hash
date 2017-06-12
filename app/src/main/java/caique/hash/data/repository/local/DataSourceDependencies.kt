package caique.hash.data.repository.local

import android.content.Context
import caique.hash.domain.boundary.LocalRepository
import com.google.gson.Gson
import com.jgabrielfreitas.datacontroller.DataController
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by Kanda on 11/06/2017.
 */
@Module
class DataSourceDependencies {

    @Provides
    @Reusable
    fun provideDataSource(context: Context): DataController {
        return DataController(context)
    }

    @Provides
    @Reusable
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Reusable
    fun providesRepository(dataController: DataController, gson: Gson): LocalRepository {
        return DataSource(dataController, gson)
    }



}