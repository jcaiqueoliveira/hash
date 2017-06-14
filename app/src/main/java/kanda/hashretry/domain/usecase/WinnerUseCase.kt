package kanda.hashretry.domain.usecase

import android.util.Log
import kanda.hashretry.domain.ResultPlay
import kanda.hashretry.domain.model.Matrix

/**
 * Created by Kanda on 10/06/2017.
 */
class WinnerUseCase {
    lateinit private var matrix: Matrix

    private fun checkRow(): ResultPlay {
        var total: Int = 0
        for (i in 0..2) {
            for (j in 0..2) {
                total += matrix.matrix[i][j]
            }
            if (total == 3 || total == -3) {
                return calculateWinner(total)
            }
            total = 0
        }
        return ResultPlay.NO_WINNER_YET
    }

    private fun checkLine(): ResultPlay {
        var total: Int = 0
        for (i in 0..2) {
            for (j in 0..2) {
                total += matrix.matrix[j][i]
            }
            if (total == 3 || total == -3) {
                return calculateWinner(total)
            }
            total = 0
        }
        return ResultPlay.NO_WINNER_YET
    }

    private fun checkDiagonal(): ResultPlay {
        var principal: Int = 0
        var second: Int = 0
        for (i in 0..2) {
            principal += matrix.matrix[i][i]
            second += matrix.matrix[i][2 - i]
        }
        if (principal == 3 || principal == -3)
            return calculateWinner(principal)

        if (second == 3 || second == -3)
            return calculateWinner(second)
        
        return ResultPlay.NO_WINNER_YET
    }

    private fun execute(): ResultPlay {
        var resultRow = checkRow()
        var resultLine = checkLine()
        var resultDiagonal = checkDiagonal()
        if (resultRow == ResultPlay.HUMAN || resultRow == ResultPlay.ROBOT) {
            return resultRow
        }
        if (resultLine == ResultPlay.HUMAN || resultLine == ResultPlay.ROBOT) {
            return resultLine
        }
        if (resultDiagonal == ResultPlay.HUMAN || resultDiagonal == ResultPlay.ROBOT) {
            return resultDiagonal
        }

        return ResultPlay.NO_WINNER_YET
    }

    fun checkWinner(matrix: Matrix): ResultPlay {
        this.matrix = matrix
        return execute()
    }

    fun calculateWinner(total: Int): ResultPlay {
        Log.e("total", total.toString())
        if (total == 3) {
            return ResultPlay.HUMAN
        } else {
            return ResultPlay.ROBOT
        }
    }

}