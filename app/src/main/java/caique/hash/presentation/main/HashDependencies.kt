package caique.hash.presentation.main

import caique.hash.domain.boundary.LocalRepository
import caique.hash.domain.usecase.HumanUseCase
import caique.hash.presentation.model.History
import dagger.Module
import dagger.Provides
import dagger.Reusable

/**
 * Created by Kanda on 11/06/2017.
 */
@Module
class HashDependencies {

    @Provides
    @Reusable
    fun provideHumanUseCase(localRepository: LocalRepository): HumanUseCase {
        return HumanUseCase(localRepository);
    }

    @Provides
    @Reusable
    fun provideHistory(): History {
        return History()
    }

    @Provides
    @Reusable
    fun providePresenter(humanUseCase: HumanUseCase, history: History): HashContract.Presenter {
        return HashPresenter(humanUseCase, history)
    }

}