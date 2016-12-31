package g33k.limited.igdbkotlin.feature.home

import javax.inject.Inject

/**
 * Created by sambains on 31/12/2016.
 */
class HomePresenter @Inject constructor(private var homeView: HomeContract.HomeView?) : HomeContract.HomePresenter {

    override fun detachView() {
        homeView = null
    }

    override fun onShowDetailButtonClicked() {
        homeView!!.navigationToDetailScreen()
    }
}