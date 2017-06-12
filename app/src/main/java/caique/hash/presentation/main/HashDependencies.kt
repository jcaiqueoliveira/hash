package caique.hash.presentation.main

import caique.hash.domain.boundary.LocalRepository
import caique.hash.domain.model.Matrix
import caique.hash.domain.usecase.HistoryUseCase
import caique.hash.domain.usecase.Winner
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
    fun provideHistoryUseCase(localRepository: LocalRepository): HistoryUseCase {
        return HistoryUseCase(localRepository);
    }

    @Provides
    @Reusable
    fun provideHistory(): History {
        return History()
    }

    @Provides
    @Reusable
    fun provideMatrix(): Matrix {
        return Matrix()
    }

    @Provides
    @Reusable
    fun provideWinner(): Winner {
        return Winner()
    }

    @Provides
    @Reusable
    fun providePresenter(historyUseCase: HistoryUseCase, history: History, matrix: Matrix, winner: Winner): HashContract.Presenter {
        return HashPresenter(historyUseCase, history, matrix, winner)
    }

}