package g33k.limited.igdbkotlin.feature.home

import dagger.Module
import dagger.Provides

/**
 * Created by sambains on 31/12/2016.
 */
@Module
class HomeModule constructor(private var homeView: HomeContract.HomeView) {

    @Provides
    fun providesHomeView(): HomeContract.HomeView {
        return homeView;
    }

    @Provides
    fun providesHomePresenter(homeView: HomeContract.HomeView): HomePresenter {
        return HomePresenter(homeView)
    }
}