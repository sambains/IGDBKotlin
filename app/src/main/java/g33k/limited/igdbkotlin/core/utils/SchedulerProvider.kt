package g33k.limited.igdbkotlin.core.utils

import io.reactivex.Scheduler

/**
 * Created by sambains on 29/12/2016.
 */
interface SchedulerProvider {

    fun mainThread(): Scheduler

    fun backgroundThread(): Scheduler
}