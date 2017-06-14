package kanda.hashretry.presentation.main

import dagger.Module
import dagger.Provides
import dagger.Reusable
import kanda.hashretry.domain.boundary.LocalRepository
import kanda.hashretry.domain.model.Matrix
import kanda.hashretry.domain.usecase.HistoryUseCase
import kanda.hashretry.domain.usecase.RobotUseCase
import kanda.hashretry.domain.usecase.WinnerUseCase
import kanda.hashretry.presentation.model.History

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
    fun provideWinner(): WinnerUseCase {
        return WinnerUseCase()
    }

    @Provides
    @Reusable
    fun providesRobotUseCase(): RobotUseCase {
        return RobotUseCase()
    }

    @Provides
    @Reusable
    fun providePresenter(historyUseCase: HistoryUseCase, robotUseCase: RobotUseCase, history: History, matrix: Matrix, winnerUseCase: WinnerUseCase): HashContract.Presenter {
        return HashPresenter(historyUseCase,robotUseCase, history, matrix, winnerUseCase)
    }

}