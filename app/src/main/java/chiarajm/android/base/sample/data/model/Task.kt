package chiarajm.android.base.sample.data.model

class Task (
        val what: String,
        val time: Long,
        var state: TaskState = TaskState.PLANNED) {

    var id: String? = null
}
