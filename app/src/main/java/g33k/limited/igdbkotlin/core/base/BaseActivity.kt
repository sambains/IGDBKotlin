package g33k.limited.igdbkotlin.core.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import g33k.limited.igdbkotlin.core.dependencies.AppComponent

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var unbinder: Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResourceId())
        unbinder = ButterKnife.bind(this)

        injectDependencies(BaseApplication.appComponent)
    }

    override fun onDestroy() {
        super.onDestroy()

        unbinder.unbind()
    }

    protected abstract fun injectDependencies(appComponent: AppComponent)

    protected abstract fun getLayoutResourceId(): Int
}
