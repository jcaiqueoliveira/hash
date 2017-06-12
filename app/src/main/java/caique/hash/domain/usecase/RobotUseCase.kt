package caique.hash.domain.usecase

import caique.hash.domain.model.Played

/**
 * Created by Kanda on 10/06/2017.
 */
class RobotUseCase : Player(){
    fun play(){
        super.play(randomPlayer())
    }

    private fun randomPlayer(): Played{
        return Played(0,0,this)
    }
}