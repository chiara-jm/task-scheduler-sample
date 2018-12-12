package chiarajm.android.base.sample.presentation.detail

import android.os.Bundle
import chiarajm.android.base.injection.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class TaskDetailModule {

    @Binds
    @FragmentScope
    internal abstract fun viewModel(viewModel: TaskDetailViewModel): TaskDetailContract.ViewModel

    @Binds
    @FragmentScope
    internal abstract fun presenter(presenter: TaskDetailPresenter): TaskDetailContract.Presenter

    @Module
    companion object {

        const val TASK_ID = "TaskDetailModule.task-id"

        fun createView(taskId: String): TaskDetailView {
            val args = Bundle()
            args.putString(TASK_ID, taskId)

            val view = TaskDetailView()
            view.arguments = args

            return view
        }

        @JvmStatic
        @Provides
        @Named(TASK_ID)
        internal fun getTaskId(view: TaskDetailView): String {
            return view.arguments!!.getString(TASK_ID)
        }
    }
}
