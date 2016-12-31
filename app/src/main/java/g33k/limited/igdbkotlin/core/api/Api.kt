package g33k.limited.igdbkotlin.core.api

import g33k.limited.igdbkotlin.core.models.Game
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

/**
 * Created by sambains on 29/12/2016.
 */
interface Api {

    @GET("games/{game_id}?fields=*")
    fun getGame(@Header("X-Mashape-Key") apiKey: String,
                @Path("game_id") gameId: String): Observable<List<Game>>
}