package chiarajm.android.base.sample.presentation

import chiarajm.android.base.injection.FragmentScope
import chiarajm.android.base.sample.presentation.create.TaskCreateModule
import chiarajm.android.base.sample.presentation.create.TaskCreateView
import chiarajm.android.base.sample.presentation.detail.TaskDetailModule
import chiarajm.android.base.sample.presentation.detail.TaskDetailView
import chiarajm.android.base.sample.presentation.list.TaskListModule
import chiarajm.android.base.sample.presentation.list.TaskListView
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsInjectorModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [TaskCreateModule::class])
    internal abstract fun taskCreateViewInjector(): TaskCreateView

    @FragmentScope
    @ContributesAndroidInjector(modules = [TaskDetailModule::class])
    internal abstract fun taskDetailViewInjector(): TaskDetailView

    @FragmentScope
    @ContributesAndroidInjector(modules = [TaskListModule::class])
    internal abstract fun taskListView(): TaskListView
}
