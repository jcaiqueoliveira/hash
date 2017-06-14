package kanda.hashretry.domain.usecase

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kanda.hashretry.domain.ResultPlay
import kanda.hashretry.domain.boundary.LocalRepository
import kanda.hashretry.domain.model.History
import javax.inject.Inject

/**
 * Created by Kanda on 12/06/2017.
 */
class HistoryUseCase @Inject constructor(var repository: LocalRepository) {
    fun getHistory(): Observable<History> {
        return repository.getHistory().observeOn(Schedulers.io())
    }

    fun updateHistory(resultPlay: ResultPlay) {
        repository.getHistory()
                .subscribe({ history ->
                    repository.saveHistory(changeHistory(history, resultPlay))
                }, { t -> t.printStackTrace() })

    }

    private fun changeHistory(history: History, resultPlay: ResultPlay): History {
        when (resultPlay) {
            ResultPlay.HUMAN -> {
                history.victory++
            }

            ResultPlay.TIE -> {
                history.tie++
            }

            ResultPlay.ROBOT -> {
                history.defeat++
            }

            else -> {

            }
        }
        return history
    }
}