package dev.challenge.soundcloudapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import dev.challenge.soundcloudapp.presentation.viewmodels.PlayListViewModel
import dev.challenge.soundcloudapp.presentation.viewmodels.ViewModelFactory
import kotlin.reflect.KClass


/**
 * A [dagger.Module] to provide the the [PlayListViewModel]
 * That is created by [ViewModelFactory]
 * */
@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PlayListViewModel::class)
    abstract fun bindsMainViewModel(playListViewModel: PlayListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
