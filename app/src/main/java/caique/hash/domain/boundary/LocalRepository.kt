package caique.hash.domain.boundary

import caique.hash.domain.model.History
import io.reactivex.Observable

/**
 * Created by Kanda on 10/06/2017.
 */

interface LocalRepository {

    fun savePlayed()
    fun getLastMatch()
    fun getHistory(): Observable<History>
    fun setHistory()
}