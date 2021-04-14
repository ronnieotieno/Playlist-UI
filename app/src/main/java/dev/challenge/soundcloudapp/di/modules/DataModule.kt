package dev.challenge.soundcloudapp.di.modules

import dagger.Module
import dagger.Provides
import dev.challenge.soundcloudapp.api.PlayListService
import dev.challenge.soundcloudapp.data.repositories.PlayListRepository
import javax.inject.Singleton

/**
 * A [dagger.Module] to provide the [PlayListRepository]
 */
@Module
object DataModule {
    @Singleton
    @Provides
    fun providesRepository(playListService: PlayListService): PlayListRepository =
        PlayListRepository(playListService)
}