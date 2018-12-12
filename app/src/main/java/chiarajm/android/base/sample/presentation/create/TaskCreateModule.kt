package chiarajm.android.base.sample.presentation.create

import chiarajm.android.base.injection.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class TaskCreateModule {

    @Binds
    @FragmentScope
    internal abstract fun viewModel(viewModel: TaskCreateViewModel): TaskCreateContract.ViewModel

    @Binds
    @FragmentScope
    internal abstract fun presenter(presenter: TaskCreatePresenter): TaskCreateContract.Presenter
}
