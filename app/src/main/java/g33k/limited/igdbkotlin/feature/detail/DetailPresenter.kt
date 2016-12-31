package g33k.limited.igdbkotlin.feature.detail

import g33k.limited.igdbkotlin.core.models.Game
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by sambains on 31/12/2016.
 */
class DetailPresenter @Inject constructor(private var detailView: DetailContract.DetailView?, private var detailInteractor: DetailContract.DetailInteractor?)
    : DisposableObserver<List<Game>>(), DetailContract.DetailPresenter {

    private var disposable: Disposable = Disposables.empty()

    override fun detachView() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }

        detailView = null

        detailInteractor = null
    }

    override fun getGame(gameId: String) {
        detailView?.showProgress()

        disposable = detailInteractor!!.getGame(gameId).subscribeWith(this)
    }

    override fun onError(e: Throwable?) {
        detailView!!.showError(e?.message)
        detailView!!.hideProgress()
    }

    override fun onComplete() {

    }

    override fun onNext(t: List<Game>?) {
        detailView!!.showGame(t?.get(0))
        detailView!!.hideProgress()
        detailView!!.showContent()
    }
}