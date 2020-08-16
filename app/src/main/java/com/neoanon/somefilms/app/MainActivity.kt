package com.neoanon.somefilms.app

import android.os.Bundle
import com.neoanon.somefilms.R
import com.neoanon.somefilms.app.navigation.CinemaHallScreen
import moxy.MvpAppCompatActivity
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace

class MainActivity : MvpAppCompatActivity() {

	private val navigatorHolder: NavigatorHolder by inject()

	private val navigator = object : SupportAppNavigator(this, R.id.content) {
		override fun applyCommands(commands: Array<Command>) {
			super.applyCommands(commands)
			supportFragmentManager.executePendingTransactions()
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		if (savedInstanceState == null) {
			navigator.applyCommands(arrayOf(Replace(CinemaHallScreen)))
		}
	}

	override fun onResumeFragments() {
		super.onResumeFragments()
		navigatorHolder.setNavigator(navigator)
	}

	override fun onPause() {
		navigatorHolder.removeNavigator()
		super.onPause()
	}
}