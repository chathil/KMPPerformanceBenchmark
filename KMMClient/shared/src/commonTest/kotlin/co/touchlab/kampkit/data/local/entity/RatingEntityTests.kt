package co.touchlab.kampkit.data.local.entity

import co.touchlab.kampkit.BaseTest
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class RatingEntityTests: BaseTest() {
    val ratings = "[\n" +
            "        {\n" +
            "          \"id\": 5,\n" +
            "          \"title\": \"exceptional\",\n" +
            "          \"count\": 2722,\n" +
            "          \"percent\": 59.14\n" +
            "        },\n" +
            "        {\n" +
            "          \"id\": 4,\n" +
            "          \"title\": \"recommended\",\n" +
            "          \"count\": 1519,\n" +
            "          \"percent\": 33\n" +
            "        },\n" +
            "        {\n" +
            "          \"id\": 3,\n" +
            "          \"title\": \"meh\",\n" +
            "          \"count\": 288,\n" +
            "          \"percent\": 6.26\n" +
            "        },\n" +
            "        {\n" +
            "          \"id\": 1,\n" +
            "          \"title\": \"skip\",\n" +
            "          \"count\": 74,\n" +
            "          \"percent\": 1.61\n" +
            "        }\n" +
            "      ]"
    @Test
    fun decodeJson() {
        val result = Json.decodeFromString<List<RatingEntity>>(ratings)
        assertEquals(true, result.isNotEmpty())
        print(result.toString())
    }

}
