package co.touchlab.kampkit.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import co.touchlab.kampkit.android.databinding.ActivityMainBinding
import co.touchlab.kampkit.presentation.GamesPresenter
import co.touchlab.kampkit.utils.TimeMeasurementUtils
import co.touchlab.kermit.Kermit
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.get

class MainActivity : AppCompatActivity(), KoinComponent {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val log: Kermit by inject { parametersOf("MainActivity") }
    private val presenter: GamesPresenter by inject()

    private var parsingTimeStart = 0L
    private var parsingTime = 0

    private var responseToEntityMappingTimeStart = 0L
    private var responseToEntityMappingTime = 0

    private var entityWritingTimeStart = 0L
    private var entityWritingTime = 0

    private var entityReadingTimeStart = 0L
    private var entityReadingTime = 0

    private var entityToDomainModelMappingTimeStart = 0L
    private var entityToDomainModelMappingTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.getList(true, timeMeasurementUtils, {}, {}, {}, {})
    }

    private val timeMeasurementUtils = TimeMeasurementUtils(
        parsingTimeStart = { parsingTimeStart = it },
        parsingTimeEnd = { parsingTime = (it - parsingTimeStart).toInt() },
        responseToEntityMappingTimeStart = { responseToEntityMappingTimeStart = it },
        responseToEntityMappingTimeEnd = {
            responseToEntityMappingTime = (it - responseToEntityMappingTimeStart).toInt()
        },
        entityWritingTimeStart = { entityWritingTimeStart = it },
        entityWritingTimeEnd = { entityWritingTime = (it - entityWritingTimeStart).toInt() },
        entityReadingTimeStart = { entityReadingTimeStart = it },
        entityReadingTimeEnd = { entityReadingTime = (it - entityReadingTimeStart).toInt() },
        entityToDomainModelMappingTimeStart = { entityToDomainModelMappingTimeStart = it },
        entityToDomainModelMappingTimeEnd = {
            entityToDomainModelMappingTime = (it - entityToDomainModelMappingTime).toInt()
            getTimes()
        }
    )

    private fun getTimes() {
        log.d {
            "-------Times-------\n" +
                    "Parsing Time ${parsingTime}\n" +
                    "Response to Entity Mapping Time ${responseToEntityMappingTime}\n" +
                    "Entity Writing Time ${entityWritingTime}\n" +
                    "Entity Reading Time ${entityReadingTime}\n" +
                    "Entity to Domain Model Mapping Time ${entityToDomainModelMappingTime}"
        }
    }
}

//Parsing Time 3600
//Response to Entity Mapping Time 14
//Entity Writing Time 1275
//Entity Reading Time 1687
//Entity to Domain Model Mapping Time 6645

//Parsing Time 1822
//Response to Entity Mapping Time 10
//Entity Writing Time 581
//Entity Reading Time 1333
//Entity to Domain Model Mapping Time 3772

//Parsing Time 1445
//Response to Entity Mapping Time 45
//Entity Writing Time 948
//Entity Reading Time 1186
//Entity to Domain Model Mapping Time 3612

//Parsing Time 1783
//Response to Entity Mapping Time 14
//Entity Writing Time 577
//Entity Reading Time 1048
//Entity to Domain Model Mapping Time 3445

//Parsing Time 1593
//Response to Entity Mapping Time 21
//Entity Writing Time 410
//Entity Reading Time 1147
//Entity to Domain Model Mapping Time 3190



