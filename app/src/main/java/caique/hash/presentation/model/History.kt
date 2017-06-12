package caique.hash.presentation.model

/**
 * Created by Kanda on 11/06/2017.
 */

class History {

    var victory: Int = 0
        set

    var defeat: Int = 0
        set

    var tie: Int = 0
        set

    private fun presentationResult(result: Int, word: String): String {
        if (victory > 0) {
            return "$result ${word}s"
        } else {
            return "$result $word"
        }
    }

    fun getHistoryOfVictories() = presentationResult(victory, "Vitória")
    fun getHistoryOfDefeates() = presentationResult(defeat, "Derrota")
    fun getHistoryOfTies() = presentationResult(tie, "Empate")

}
