package kanda.hashretry.presentation.main

import kanda.hashretry.presentation.model.History

/**
 * Created by Kanda on 11/06/2017.
 */
interface HashContract {
    interface View {
        fun showHistory(history: History)
        fun endGame(message: String)
        fun  robotPlay(it: Int)
    }

    interface Presenter {
        fun attach(view: View)
        fun detach()
        fun loadHistory()
        fun played(position: Int)
    }
}