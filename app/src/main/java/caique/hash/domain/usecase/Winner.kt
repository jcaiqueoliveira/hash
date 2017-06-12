package caique.hash.domain.usecase

import caique.hash.domain.Result
import caique.hash.domain.model.Matrix

/**
 * Created by Kanda on 10/06/2017.
 */
class Winner() {
    lateinit private var matrix: Matrix

    private fun checkRow(): Result {
        (0..2)
                .map { i -> (0..2).sumBy { matrix.matrix[it][i] } }
                .filter { it == 3 || it == -3 }
                .map {
                    return calculateWinner(it)
                }
        return Result.NO_WINNER_YET;
    }

    private fun checkLine(): Result {
        (0..2)
                .map { i -> (0..2).sumBy { matrix.matrix[i][it] } }
                .filter { it == 3 || it == -3 }
                .map {
                    return calculateWinner(it)
                }
        return Result.NO_WINNER_YET;
    }

    private fun checkDiagonal(): Result {
        (2 downTo 0).map { i ->
            (0..2).sumBy { matrix.matrix[i][it] }
        }
                .filter { it == 3 || it == -3 }
                .map { return calculateWinner(it) }

        for (i in 0..2) {
            var total: Int = 0
            total += matrix.matrix[i][i]
            if (total == 3 || total == -3)
                return calculateWinner(total)
        }

        return Result.NO_WINNER_YET
    }

    private fun execute(): Result {
        var resultRow = checkRow()
        var resultLine = checkLine()
        var resultDiagonal = checkDiagonal()
        if (resultRow == Result.HUMAN || resultRow == Result.ROBOT) {
            return resultRow
        }
        if (resultLine == Result.HUMAN || resultLine == Result.ROBOT) {
            return resultLine
        }
        if (resultDiagonal == Result.HUMAN || resultDiagonal == Result.ROBOT) {
            return resultDiagonal
        }

        return Result.NO_WINNER_YET
    }

    fun checkWinner(matrix: Matrix): Result {
        this.matrix = matrix
        return execute()
    }

    fun calculateWinner(total: Int): Result {
        if (total == 3) {
            return Result.HUMAN
        } else {
            return Result.ROBOT
        }
    }

}