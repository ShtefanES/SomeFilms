package com.neoanon.somefilms.features.detail.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.neoanon.somefilms.R
import com.neoanon.somefilms.features.detail.presentation.FilmDetailPresenter
import com.neoanon.somefilms.features.detail.presentation.FilmDetailView
import com.neoanon.somefilms.shared.films.domain.entity.FilmDetail
import com.neoanon.somefilms.shared.films.extension.isUnknown
import com.neoanon.somefilms.shared.ui.addBackPressedListener
import kotlinx.android.synthetic.main.fragment_film_detail.description
import kotlinx.android.synthetic.main.fragment_film_detail.image
import kotlinx.android.synthetic.main.fragment_film_detail.originalTitle
import kotlinx.android.synthetic.main.fragment_film_detail.rating
import kotlinx.android.synthetic.main.fragment_film_detail.toolbar
import kotlinx.android.synthetic.main.fragment_film_detail.year
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

class FilmDetailFragment : MvpAppCompatFragment(R.layout.fragment_film_detail), FilmDetailView {

	companion object {
		fun newInstance(filmId: Long): Fragment =
			FilmDetailFragment().apply {
				arguments = Bundle().apply {
					this.filmId = filmId
				}
			}
	}

	@InjectPresenter
	lateinit var presenter: FilmDetailPresenter

	@ProvidePresenter
	fun provide(): FilmDetailPresenter = get()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		addBackPressedListener { presenter.onBackClicked() }
		initToolbar()

		this.arguments?.let { presenter.onFilmIdFetched(it.filmId) }

	}

	private fun initToolbar() {
		toolbar.setNavigationIcon(R.drawable.ic_arrow_white)
		toolbar.setNavigationOnClickListener { presenter.onBackClicked() }
	}

	override fun showFilmDetail(detail: FilmDetail) {
		toolbar.title = detail.title
		originalTitle.text = detail.originalTitle
		year.text = getString(R.string.detail_film_year, detail.year)

		val ratingText = if (detail.rating.isUnknown()) {
			getString(R.string.no_data)
		} else {
			detail.rating.toString()
		}

		rating.text = getString(R.string.detail_film_rating, ratingText)
		description.text = if (detail.description.isBlank()) {
			getString(R.string.no_data)
		} else {
			detail.description
		}

		Glide.with(image)
			.load(detail.imageUrl)
			.centerCrop()
			.error(R.drawable.ic_blank)
			.into(image)
	}

	override fun showErrorInfo() {
		context?.let { Toast.makeText(it, it.getString(R.string.error_stub_message), Toast.LENGTH_LONG).show() }
	}
}