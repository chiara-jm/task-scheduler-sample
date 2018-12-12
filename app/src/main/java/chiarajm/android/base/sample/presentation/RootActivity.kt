package chiarajm.android.base.sample.presentation

import android.os.Bundle
import android.widget.Toast
import chiarajm.android.base.sample.R
import chiarajm.android.base.sample.presentation.create.TaskCreateView
import chiarajm.android.base.sample.presentation.detail.TaskDetailModule
import chiarajm.android.base.sample.presentation.detail.TaskDetailView
import chiarajm.android.base.sample.presentation.list.TaskListView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.root_activity.*


class RootActivity : DaggerAppCompatActivity(), Navigation {

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_activity)
        setSupportActionBar(toolbar)

        showTaskListScreen()
    }

    //region Navigation Implementation
    override fun showTaskListScreen() {
        val current = supportFragmentManager.findFragmentById(R.id.content)
        if (current != null && current is TaskListView) return

        val listFragment = TaskListView()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, listFragment)
        //transaction.addToBackStack("task-list");
        transaction.commit()
    }

    override fun showCreateTaskScreen() {
        val current = supportFragmentManager.findFragmentById(R.id.content)
        if (current != null && current is TaskCreateView) return

        val createFragment = TaskCreateView()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, createFragment)
        transaction.addToBackStack("task-create")
        transaction.commit()
    }

    override fun showTaskDetailScreen(taskId: String) {
        val current = supportFragmentManager.findFragmentById(R.id.content)
        if (current != null && current is TaskDetailView) return

        val detailFragment = TaskDetailModule.createView(taskId)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, detailFragment)
        transaction.addToBackStack("task-detail")
        transaction.commit()
    }
    //endregion

    override fun closeCurrentScreen() {
        supportFragmentManager.popBackStack()
    }
}
