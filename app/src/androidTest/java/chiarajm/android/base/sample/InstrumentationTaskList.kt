package chiarajm.android.base.sample

import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import chiarajm.android.base.sample.data.TaskDataSource
import chiarajm.android.base.sample.data.model.Task
import chiarajm.android.base.sample.presentation.RootActivity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class InstrumentationTaskList {

    internal var mTask: Task

    @Rule
    var mTasksActivityTestRule: ActivityTestRule<RootActivity> = object : ActivityTestRule<RootActivity>(RootActivity::class.java) {
        override fun beforeActivityLaunched() {
            val `when` = System.currentTimeMillis()
            mTask = sTaskDataSource!!.save(Task(TEST_WHAT, `when`))
        }
    }

    @Test
    @Throws(Exception::class)
    fun taskDetailScreen() {
        onView(withText(mTask.what)).check(matches(isDisplayed()))
        onView(withText(mTask.what)).perform(click())
        onView(withId(R.id.task_detail_what)).check(matches(withText(mTask.what)))

        onView(withId(R.id.task_detail_move_back)).check(matches(withText(R.string.task_action_delete)))
        onView(withId(R.id.task_detail_move_forward)).check(matches(withText(R.string.task_action_start)))
    }

    companion object {
        private val TEST_WHAT = "TEST WHAT"

        private var sTaskDataSource: TaskDataSource? = null

        @BeforeClass
        fun inject() {
            sTaskDataSource = Injection.provideTaskDataSource()
        }
    }

}
