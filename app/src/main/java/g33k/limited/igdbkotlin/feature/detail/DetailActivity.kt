package g33k.limited.igdbkotlin.feature.detail

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import g33k.limited.igdbkotlin.R
import g33k.limited.igdbkotlin.core.base.BaseActivity
import g33k.limited.igdbkotlin.core.dependencies.AppComponent
import g33k.limited.igdbkotlin.core.models.Game
import javax.inject.Inject

/**
 * Created by sambains on 31/12/2016.
 */
class DetailActivity : BaseActivity(), DetailContract.DetailView {

    fun startActivity(activity: BaseActivity) {
        ActivityCompat.startActivity(activity, Intent(activity, DetailActivity::class.java), null)
    }

    @Inject
    lateinit var detailPresenter: DetailContract.DetailPresenter

    @BindView(R.id.progress)
    lateinit var progressBar: ProgressBar
    @BindView(R.id.content)
    lateinit var content: LinearLayout
    @BindView(R.id.name)
    lateinit var name: TextView
    @BindView(R.id.summary)
    lateinit var summary: TextView
    @BindView(R.id.storyline)
    lateinit var storyline: TextView
    @BindView(R.id.rating)
    lateinit var rating: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailPresenter.getGame("1020")
    }

    override fun onDestroy() {
        super.onDestroy()

        detailPresenter.detachView()
    }

    override fun injectDependencies(appComponent: AppComponent) {
        appComponent.plus(DetailModule(this))
                .inject(this)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_detail
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showContent() {
        content.visibility = View.VISIBLE
    }

    override fun showGame(game: Game?) {
        name.text = game?.name
        summary.text = game?.summary
        storyline.text = game?.storyline
        rating.text = game?.rating.toString()
    }

    override fun showError(errorMessage: String?) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}