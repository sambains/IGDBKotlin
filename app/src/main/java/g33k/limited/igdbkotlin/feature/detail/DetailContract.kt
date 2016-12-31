package g33k.limited.igdbkotlin.feature.detail

import g33k.limited.igdbkotlin.core.base.BasePresenter
import g33k.limited.igdbkotlin.core.models.Game
import io.reactivex.Observable

/**
 * Created by sambains on 31/12/2016.
 */
class DetailContract {

    interface DetailView {
        fun showProgress()

        fun hideProgress()

        fun showContent()

        fun showGame(game: Game?)

        fun showError(errorMessage: String?)
    }

    interface DetailPresenter : BasePresenter {
        fun getGame(gameId: String)
    }

    interface DetailInteractor {
        fun getGame(gameId: String): Observable<List<Game>>
    }
}