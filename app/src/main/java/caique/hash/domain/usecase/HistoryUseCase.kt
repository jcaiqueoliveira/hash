package caique.hash.domain.usecase

import caique.hash.domain.Result
import caique.hash.domain.boundary.LocalRepository
import caique.hash.domain.model.History
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Kanda on 12/06/2017.
 */
class HistoryUseCase @Inject constructor(var repository: LocalRepository) {
    fun getHistory(): Observable<History> {
        return repository.getHistory().observeOn(Schedulers.io())
    }

    fun updateHistory(result: Result){

    }
}