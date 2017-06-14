package kanda.hashretry.presentation.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import kanda.hashretry.R
import kanda.hashretry.presentation.base.BaseActivity
import kanda.hashretry.presentation.model.History
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

open class MainActivity : BaseActivity(), HashContract.View, HashAdapter.OnItemClickListener {


    @Inject lateinit var presenter: HashContract.Presenter
    lateinit var adapter: HashAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component!!.inject(this)
        presenter.attach(this)
        presenter.loadHistory()
        adapter = HashAdapter(this)
        hash.setHasFixedSize(true)
        hash.layoutManager = GridLayoutManager(this, 3)
        hash.adapter = adapter
        hash.isNestedScrollingEnabled = false
    }

    override fun onItemClick(position: Int) {
        presenter.played(position)
        changeIcon()
    }

    override fun showHistory(history: History) {
        victory.text = history.getHistoryOfVictories()
        defeat.text = history.getHistoryOfDefeates()
        tie.text = history.getHistoryOfTies()
    }

    override fun endGame(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun robotPlay(it: Int) {
        adapter.robotItem(it)
        changeIcon()
    }

    fun changeIcon() {
        if (adapter.drawable == R.drawable.ic_player)
            adapter.drawable = R.drawable.ic_comp_menor
        else
            adapter.drawable = R.drawable.ic_player
    }
}
