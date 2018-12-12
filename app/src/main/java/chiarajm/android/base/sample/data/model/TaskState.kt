package chiarajm.android.base.sample.data.model

enum class TaskState(val serverId: Int) {
    PLANNED(0),
    WORKING(1),
    PAUSED(2),
    DONE(3),
    ARCHIVED(4),
    DELETED(5)

    ;

    companion object {
        fun fromServerId(serverId: Int?): TaskState? = TaskState.values().find { it.serverId == serverId }
    }
}
