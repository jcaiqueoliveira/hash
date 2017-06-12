package caique.hash.domain.usecase

import caique.hash.domain.model.Played

/**
 * Created by Kanda on 10/06/2017.
 */
class RobotUseCase : Player() {
    override fun play(player: Played) {

    }

    private fun randomPlayer(): Played {
        return Played()
    }
}