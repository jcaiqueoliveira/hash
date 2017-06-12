package caique.hash.presentation.main

import caique.hash.domain.Result
import caique.hash.domain.model.Matrix
import caique.hash.domain.model.Played
import caique.hash.domain.usecase.HistoryUseCase
import caique.hash.domain.usecase.Winner
import caique.hash.presentation.model.History
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Kanda on 11/06/2017.
 */
class HashPresenter @Inject constructor(var historyUseCase: HistoryUseCase, var history: History, var matrix: Matrix, var winner: Winner) : HashContract.Presenter {
    lateinit var played: Played

    override fun played(position: Int) {
        played = Played()
        turn++
        if (position <= 2) {
            played.x = position
            played.y = 0
        } else if (position <= 5) {
            played.x = position - 3
            played.y = 1
        } else {
            played.x = position - 6
            played.y = 2
        }
        if (turn % 2 == 0) {
            matrix.matrix[played.x][played.y] = 1
        } else {
            matrix.matrix[played.x][played.y] = -1
        }
        var result = winner.checkWinner(matrix)
        if (result == Result.HUMAN) {
            view.endGame("Parabéns! você venceu! \\o/")
            historyUseCase.updateHistory(Result.HUMAN)
        } else if (result == Result.ROBOT) {
            view.endGame("Você perdeu :(")
            historyUseCase.updateHistory(Result.ROBOT)
        } else if (turn == 8 && result == Result.NO_WINNER_YET) {
            historyUseCase.updateHistory(Result.TIE)
            view.endGame("O jogo terminou empatado")
        }
    }

    private var turn: Int = -1
    override fun loadHistory() {
        historyUseCase.getHistory()
                .subscribeOn(AndroidSchedulers.mainThread())
                .map {
                    history.apply {
                        victory = it.victory
                        defeat = it.defeat
                        tie = it.tie
                    }
                }
                .subscribe({
                    view.showHistory(it)
                }, { t -> t.printStackTrace() })
    }

    lateinit var view: HashContract.View
    override fun attach(view: HashContract.View) {
        this.view = view
    }

    override fun detach() {

    }
}