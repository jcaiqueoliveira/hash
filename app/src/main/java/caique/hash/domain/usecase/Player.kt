package caique.hash.domain.usecase

import caique.hash.domain.model.Played

/**
 * Created by Kanda on 10/06/2017.
 */

abstract class Player {

    abstract fun play(player: Played)
}