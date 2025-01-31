package dev.challenge.soundcloudapp.di.modules

import dagger.Module


/**
 *  A [dagger.Module] scoped to the Application class
 */

@Module(
    includes = [
        NetworkModule::class,
        DataModule::class
    ]
)
class ApplicationModule