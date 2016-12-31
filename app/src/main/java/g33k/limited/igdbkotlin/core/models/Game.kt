package g33k.limited.igdbkotlin.core.models

import com.google.gson.annotations.SerializedName

/**
 * Created by sambains on 29/12/2016.
 */
class Game {

    @SerializedName("name")
    var name: String = ""
    @SerializedName("summary")
    var summary: String = ""
    @SerializedName("storyline")
    var storyline: String = ""
    @SerializedName("rating")
    var rating: Double = 0.0
}