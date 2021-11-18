package dev.challenge.soundcloudapp.di

import android.app.Application

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dev.challenge.soundcloudapp.SoundCloudApp
import dev.challenge.soundcloudapp.di.modules.ApplicationModule
import dev.challenge.soundcloudapp.di.modules.FragmentBuildersModule
import dev.challenge.soundcloudapp.di.modules.MainActivityModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        MainActivityModule::class,
        FragmentBuildersModule::class
    ]
)
/**
 * Generates [dagger.Component] which is install in the [Application] class.
 */
interface ApplicationComponent : AndroidInjector<SoundCloudApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(soundCloudApp: SoundCloudApp)
}
