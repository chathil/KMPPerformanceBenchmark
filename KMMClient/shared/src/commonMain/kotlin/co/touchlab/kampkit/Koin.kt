package co.touchlab.kampkit

import co.touchlab.kampkit.data.GetGamesRepository
import co.touchlab.kampkit.data.local.GetGamesLocalDataSource
import co.touchlab.kampkit.data.remote.GetGamesRemoteDataSource
import co.touchlab.kampkit.domain.usecase.GamesInteractor
import co.touchlab.kampkit.domain.usecase.GamesUseCase
import co.touchlab.kampkit.presentation.GetGamesPresenter
import co.touchlab.kermit.Kermit
import kotlinx.coroutines.Dispatchers
import kotlinx.datetime.Clock
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            platformModule,
            coreModule
        )
    }

    // Dummy initialization logic, making use of appModule declarations for demonstration purposes.
    val koin = koinApplication.koin
    val doOnStartup = koin.get<() -> Unit>() // doOnStartup is a lambda which is implemented in Swift on iOS side
    doOnStartup.invoke()

    val kermit = koin.get<Kermit> { parametersOf(null) }
    val appInfo = koin.get<AppInfo>() // AppInfo is a Kotlin interface with separate Android and iOS implementations
    kermit.v { "App Id ${appInfo.appId}" }

    return koinApplication
}

private val coreModule = module {
    single {
        GetGamesLocalDataSource(
            get(),
            getWith("GetGamesLocalDataSource"),
            Dispatchers.Default
        )
    }
    single {
        GetGamesRemoteDataSource(log = getWith("GetGamesRemoteDataSource"))
    }
    single { GetGamesRepository(get(), get()) }
    single { GamesInteractor(get()) }
    single { GetGamesPresenter(get()) }
    single<GamesUseCase> {GamesInteractor(get())}
    single<Clock> {
        Clock.System
    }
}

internal inline fun <reified T> Scope.getWith(vararg params: Any?): T {
    return get(parameters = { parametersOf(*params) })
}

expect val platformModule: Module
