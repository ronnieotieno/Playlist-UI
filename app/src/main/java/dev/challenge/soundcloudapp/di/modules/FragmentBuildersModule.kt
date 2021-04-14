package dev.challenge.soundcloudapp.di.modules


import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.challenge.soundcloudapp.presentation.views.PlayListFragment


/**
 * A [dagger.Module] to provide the the [PlayListFragment]
 **/
@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributePlayListFragment(): PlayListFragment

}
