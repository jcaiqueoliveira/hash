package caique.hash.domain.usecase

import caique.hash.domain.boundary.LocalRepository
import caique.hash.domain.model.History
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Kanda on 10/06/2017.
 */

class HumanUseCase @Inject constructor(var repository: LocalRepository) : Player() {


    fun getHistory(): Observable<History> {
        return repository.getHistory().observeOn(Schedulers.io())
    }
}
