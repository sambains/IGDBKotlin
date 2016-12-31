package g33k.limited.igdbkotlin.feature.detail

import dagger.Module
import dagger.Provides
import g33k.limited.igdbkotlin.core.api.Api
import g33k.limited.igdbkotlin.core.utils.SchedulerProvider

/**
 * Created by sambains on 31/12/2016.
 */
@Module
class DetailModule constructor(private var detailView: DetailContract.DetailView) {

    @Provides
    fun providesDetailView(): DetailContract.DetailView {
        return detailView
    }

    @Provides
    fun providesDetailPresenter(detailView: DetailContract.DetailView, detailInteractor: DetailContract.DetailInteractor): DetailContract.DetailPresenter {
        return DetailPresenter(detailView, detailInteractor)
    }

    @Provides
    fun providesDetailInteractor(api: Api, schedulerProvider: SchedulerProvider): DetailContract.DetailInteractor {
        return DetailInteractor(api, schedulerProvider)
    }
}