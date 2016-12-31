package g33k.limited.igdbkotlin.core.dependencies

import dagger.Component
import g33k.limited.igdbkotlin.feature.detail.DetailComponent
import g33k.limited.igdbkotlin.feature.detail.DetailModule
import g33k.limited.igdbkotlin.feature.home.HomeComponent
import g33k.limited.igdbkotlin.feature.home.HomeModule
import javax.inject.Singleton

/**
 * Created by sambains on 29/12/2016.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun plus(homeModule: HomeModule): HomeComponent

    fun plus(detailModule: DetailModule): DetailComponent
}