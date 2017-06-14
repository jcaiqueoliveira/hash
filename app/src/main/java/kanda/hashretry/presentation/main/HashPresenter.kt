package kanda.hashretry.presentation.main

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import kanda.hashretry.domain.ResultPlay

import kanda.hashretry.domain.model.Matrix
import kanda.hashretry.domain.model.Played
import kanda.hashretry.domain.usecase.HistoryUseCase
import kanda.hashretry.domain.usecase.RobotUseCase
import kanda.hashretry.domain.usecase.WinnerUseCase
import kanda.hashretry.presentation.model.History
import javax.inject.Inject

/**
 * Created by Kanda on 11/06/2017.
 */
class HashPresenter @Inject constructor(var historyUseCase: HistoryUseCase, var robotUseCase: RobotUseCase, var history: History, var matrix: Matrix, var winnerUseCase: WinnerUseCase) : HashContract.Presenter {
    lateinit var played: Played
    private var turn: Int = -1
    var HUMAN = 1
    var ROBOT = -1
    override fun played(position: Int) {
        updateMatrix(position)
        if (turn % 2 == 0) {
            matrix.matrix[played.y][played.x] = HUMAN
            if (turn < 8) {
                robotUseCase.play(matrix)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            matrix.matrix[it.second.y][it.second.x] = ROBOT
                            view.robotPlay(it.first)
                            turn++
                        }
            }
        }

        val result = winnerUseCase.checkWinner(matrix)
       // Log.e("result", result.name)
        if (result == ResultPlay.HUMAN) {
            view.endGame("Parabéns! você venceu! \\o/")
            historyUseCase.updateHistory(ResultPlay.HUMAN)
        } else if (result == ResultPlay.ROBOT) {
            view.endGame("Você perdeu :(")
            historyUseCase.updateHistory(ResultPlay.ROBOT)
        } else if (turn == 8 && result == ResultPlay.NO_WINNER_YET) {
            historyUseCase.updateHistory(ResultPlay.TIE)
            view.endGame("O jogo terminou empatado")
        }
    }


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

    private fun updateMatrix(position: Int) {
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
    }

    override fun detach() {

    }
}