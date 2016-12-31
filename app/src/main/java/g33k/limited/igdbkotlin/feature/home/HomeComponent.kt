package g33k.limited.igdbkotlin.feature.home

import dagger.Subcomponent

/**
 * Created by sambains on 31/12/2016.
 */
@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {

    fun inject(homeActivity: HomeActivity)
}