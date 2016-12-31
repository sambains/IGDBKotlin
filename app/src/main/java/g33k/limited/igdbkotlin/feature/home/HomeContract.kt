package g33k.limited.igdbkotlin.feature.home

import g33k.limited.igdbkotlin.core.base.BasePresenter

/**
 * Created by sambains on 31/12/2016.
 */
class HomeContract {

    interface HomeView {
        fun navigationToDetailScreen()
    }

    interface HomePresenter : BasePresenter {
        fun onShowDetailButtonClicked()
    }
}