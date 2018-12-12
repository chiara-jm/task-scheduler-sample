package chiarajm.android.base.sample.presentation

interface Navigation {

    fun showTaskListScreen()

    fun showCreateTaskScreen()

    fun showTaskDetailScreen(taskId: String)

    fun closeCurrentScreen()

    fun showError(message: String?)
}
