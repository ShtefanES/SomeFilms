package com.neoanon.somefilms.features.cinemahall.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.neoanon.somefilms.R
import com.neoanon.somefilms.features.cinemahall.presentation.CinemaHallPresenter
import com.neoanon.somefilms.features.cinemahall.presentation.CinemaHallView
import com.neoanon.somefilms.features.cinemahall.presentation.FilmInfoItem
import com.neoanon.somefilms.shared.ui.addBackPressedListener
import com.neoanon.somefilms.shared.ui.setup
import kotlinx.android.synthetic.main.fragment_cinema_hall.filmInfoRecycleView
import kotlinx.android.synthetic.main.fragment_cinema_hall.progress
import kotlinx.android.synthetic.main.fragment_cinema_hall.swipeContainer
import kotlinx.android.synthetic.main.fragment_cinema_hall.toolbar
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class CinemaHallFragment : MvpAppCompatFragment(R.layout.fragment_cinema_hall), CinemaHallView {

	companion object {
		fun newInstance(): Fragment = CinemaHallFragment()

		private const val ONE_SPAN = 1
		private const val TWO_SPAN = 2
	}

	@InjectPresenter
	lateinit var presenter: CinemaHallPresenter

	@ProvidePresenter
	fun provide(): CinemaHallPresenter = get()

	private lateinit var adapter: FilmInfoAdapter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		addBackPressedListener { presenter.onBackClicked() }
		toolbar.setup(titleId = R.string.cinema_hall_title)

		initFilmInfoRecycleView()

		swipeContainer.setOnRefreshListener {
			presenter.onRefresh()
		}
	}

	private fun initFilmInfoRecycleView() {
		adapter = FilmInfoAdapter(
			presenter::onGenreItemClicked,
			presenter::onPosterItemClicked
		)

		val mLayoutManager = GridLayoutManager(requireContext(), TWO_SPAN)
		mLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
			override fun getSpanSize(position: Int): Int =
				if (adapter.getItemViewType(position) == FilmInfoAdapter.ITEM_TYPE_POSTER) {
					ONE_SPAN
				} else {
					TWO_SPAN
				}
		}
		filmInfoRecycleView.layoutManager = mLayoutManager
		filmInfoRecycleView.adapter = adapter
	}

	override fun showProgress() {
		progress.isVisible = true
		swipeContainer.isRefreshing = false
	}

	override fun hideProgress() {
		progress.isVisible = false
		swipeContainer.isRefreshing = false
	}

	override fun showFilmInfoList(filmInfoItems: List<FilmInfoItem>) {
		adapter.setData(filmInfoItems)
	}

	override fun showErrorInfo() {
		context?.let { Toast.makeText(it, it.getString(R.string.error_stub_message), Toast.LENGTH_LONG).show() }
	}
}