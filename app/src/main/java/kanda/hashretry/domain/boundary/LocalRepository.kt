package kanda.hashretry.domain.boundary

import kanda.hashretry.domain.model.History
import io.reactivex.Observable

/**
 * Created by Kanda on 10/06/2017.
 */

interface LocalRepository {

    fun savePlayed()
    fun getLastMatch()
    fun getHistory(): Observable<History>
    fun saveHistory(history: History)
}