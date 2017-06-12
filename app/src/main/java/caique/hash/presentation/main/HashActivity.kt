package caique.hash.presentation.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import caique.hash.R
import caique.hash.presentation.base.BaseActivity
import caique.hash.presentation.model.History
import kotlinx.android.synthetic.main.activity_hash.*
import javax.inject.Inject


class HashActivity : BaseActivity(), HashContract.View, HashAdapter.OnItemClickListener {



    lateinit @Inject var presenter: HashContract.Presenter

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hash)
        getComponent().inject(this)
        presenter.attach(this)
        presenter.loadHistory()
        hash.setHasFixedSize(true)
        hash.layoutManager = GridLayoutManager(this, 3)
        hash.adapter = HashAdapter(this)
        hash.isNestedScrollingEnabled = false
    }

    override fun showHistory(history: History) {
        victory.text = history.getHistoryOfVictories()
        defeat.text = history.getHistoryOfDefeates()
        tie.text = history.getHistoryOfTies()
    }

    override fun onItemClick(position: Int) {
        presenter.played(position)
    }
}
