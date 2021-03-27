package co.touchlab.kampkit.data.local

import co.touchlab.kampkit.data.local.entity.RatingEntity
import com.squareup.sqldelight.ColumnAdapter
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.TransactionWithoutReturn
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

// TODO: If at some point a Core Module exist. Move this extension there.
suspend fun Transacter.transactionWithContext(
    coroutineContext: CoroutineContext,
    noEnclosing: Boolean = false,
    body: TransactionWithoutReturn.() -> Unit
) {
    withContext(coroutineContext) {
        this@transactionWithContext.transaction(noEnclosing) {
            body()
        }
    }
}
// Use kotlinx.serialization to parse it back to POJ
val listOfRatingsAdapter = object : ColumnAdapter<List<RatingEntity>, String> {
    override fun decode(databaseValue: String): List<RatingEntity> =
        listOf()
    override fun encode(value: List<RatingEntity>): String = value.joinToString(separator = ",")
}

//val queryWrapper: Database = Database(
//    driver = driver,
//    hockeyPlayerAdapter = hockeyPlayer.Adapter(
//        cup_winsAdapter = listOfStringsAdapter
//    )
//)

