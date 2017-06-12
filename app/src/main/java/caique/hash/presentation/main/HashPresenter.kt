package caique.hash.presentation.main

import caique.hash.domain.usecase.HumanUseCase
import caique.hash.presentation.model.History
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Kanda on 11/06/2017.
 */
class HashPresenter @Inject constructor(var humanUseCase: HumanUseCase, var history: History) : HashContract.Presenter {

    override fun loadHistory() {
        humanUseCase.getHistory()
                .subscribeOn(AndroidSchedulers.mainThread())
                .map {
                    history.apply {
                        victory = it.victory
                        defeat = it.defeat
                        tie = it.tie
                    }
                }
                .subscribe({
                    view.showHistory(it)
                }, { t -> t.printStackTrace() })
    }

    lateinit var view: HashContract.View
    override fun attach(view: HashContract.View) {
        this.view = view
    }

    override fun detach() {

    }
}