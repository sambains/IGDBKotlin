package g33k.limited.igdbkotlin.core.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by sambains on 29/12/2016.
 */
class AppSchedulerProvider : SchedulerProvider {

    @Inject
    fun AppSchedulerProvider() {

    }

    override fun mainThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun backgroundThread(): Scheduler {
        return Schedulers.io()
    }
}