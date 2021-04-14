package dev.challenge.soundcloudapp.di.modules


import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.challenge.soundcloudapp.presentation.views.MainActivity

/**
 * A [dagger.Module] to provide the the [MainActivity]
 * Member [MainActivityModule.contributeMainActivity] has [FragmentBuildersModule] as a child
 */
@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}
