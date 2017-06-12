package caique.hash.presentation.main

import caique.hash.presentation.model.History

/**
 * Created by Kanda on 11/06/2017.
 */
interface HashContract {
    interface View {
        fun showHistory(history:History)
    }

    interface Presenter {
        fun attach(view: View)
        fun detach()
        fun loadHistory()
    }
}