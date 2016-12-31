package g33k.limited.igdbkotlin.feature.detail

import g33k.limited.igdbkotlin.BuildConfig
import g33k.limited.igdbkotlin.core.api.Api
import g33k.limited.igdbkotlin.core.models.Game
import g33k.limited.igdbkotlin.core.utils.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by sambains on 31/12/2016.
 */
class DetailInteractor @Inject constructor(private var api: Api, private var schedulerProvider: SchedulerProvider) : DetailContract.DetailInteractor {

    override fun getGame(gameId: String): Observable<List<Game>> {
        return api.getGame(BuildConfig.API_KEY, gameId)
                .subscribeOn(schedulerProvider.backgroundThread())
                .observeOn(schedulerProvider.mainThread())
    }
}