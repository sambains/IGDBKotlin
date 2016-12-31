package g33k.limited.igdbkotlin.core.base

import android.app.Application
import com.facebook.stetho.Stetho
import g33k.limited.igdbkotlin.BuildConfig
import g33k.limited.igdbkotlin.core.dependencies.AppComponent
import g33k.limited.igdbkotlin.core.dependencies.AppModule
import g33k.limited.igdbkotlin.core.dependencies.DaggerAppComponent
import timber.log.Timber

/**
 * Created by sambains on 29/12/2016.
 */
class BaseApplication : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initApplication()

        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
    }

    fun initApplication() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())

            Stetho.initialize(Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                    .build())
        }
    }
}