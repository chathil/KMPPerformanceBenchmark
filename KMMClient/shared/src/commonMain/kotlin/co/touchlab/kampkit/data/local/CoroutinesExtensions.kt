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
