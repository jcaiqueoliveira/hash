package kanda.hashretry.domain.usecase

import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kanda.hashretry.domain.model.Matrix
import kanda.hashretry.domain.model.Played
import java.util.*

/**
 * Created by Kanda on 10/06/2017.
 */
class RobotUseCase {
    var random: Random = Random()
    lateinit var listFreePositions: ArrayList<Pair<Int, Played>>
    fun play(matrix: Matrix): Observable<Pair<Int, Played>> {
        var position = -1
        listFreePositions = arrayListOf()
        return Observable.create<Pair<Int, Played>> { obs ->
            listFreePositions = arrayListOf()
            for (i in 0..2) {
                for (j in 0..2) {
                    position++
                    if (matrix.matrix[i][j] == 0) {
                        listFreePositions.add(position to Played().apply {
                            x = j
                            y = i
                        })
                    }
                }
            }
            obs.onNext(randomPlayer())
        }.subscribeOn(Schedulers.io())
    }

    private fun randomPlayer(): Pair<Int, Played> {
        return listFreePositions[random.nextInt(listFreePositions.size)]
    }
}