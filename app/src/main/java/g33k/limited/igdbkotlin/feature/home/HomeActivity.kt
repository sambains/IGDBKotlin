package g33k.limited.igdbkotlin.feature.home

import android.os.Bundle
import butterknife.OnClick
import g33k.limited.igdbkotlin.R
import g33k.limited.igdbkotlin.core.base.BaseActivity
import g33k.limited.igdbkotlin.core.dependencies.AppComponent
import g33k.limited.igdbkotlin.feature.detail.DetailActivity
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeContract.HomeView {

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()

        homePresenter.detachView()
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(HomeModule(this))
                .inject(this)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_home
    }

    override fun navigationToDetailScreen() {
        DetailActivity().startActivity(this)
    }

    @OnClick(R.id.show_detail)
    fun onShowDetailPressed() {
        homePresenter.onShowDetailButtonClicked()
    }
}
