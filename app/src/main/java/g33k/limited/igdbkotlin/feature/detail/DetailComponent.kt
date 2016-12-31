package g33k.limited.igdbkotlin.feature.detail

import dagger.Subcomponent

/**
 * Created by sambains on 31/12/2016.
 */
@Subcomponent(modules = arrayOf(DetailModule::class))
interface DetailComponent {

    fun inject(detailActivity: DetailActivity)
}