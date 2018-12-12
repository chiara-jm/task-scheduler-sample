package chiarajm.android.base.sample.presentation.list

import chiarajm.android.base.injection.FragmentScope
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.presentation.utils.recyclerview.RecyclerViewAdapter
import chiarajm.android.base.sample.presentation.utils.recyclerview.RecyclerViewContract
import dagger.Binds
import dagger.Module

@Module
abstract class TaskListModule {

    @Binds
    @FragmentScope
    internal abstract fun viewModel(viewModel: TaskListViewModel): TaskListContract.ViewModel

    @Binds
    @FragmentScope
    internal abstract fun presenter(presenter: TaskListPresenter): TaskListContract.Presenter

    @Binds
    @FragmentScope
    internal abstract fun rowPresenter(rowPresenter: TaskRowPresenter): RecyclerViewContract.Presenter<Task>

    @Binds
    @FragmentScope
    internal abstract fun adapter(adapter: TaskListAdapter): RecyclerViewAdapter<Task>
}
