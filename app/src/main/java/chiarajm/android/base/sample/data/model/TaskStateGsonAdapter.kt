package chiarajm.android.base.sample.data.model

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class TaskStateGsonAdapter : JsonAdapter<TaskState>() {

    override fun fromJson(reader: JsonReader?): TaskState? = TaskState.fromServerId(reader?.nextInt())


    override fun toJson(writer: JsonWriter?, value: TaskState?) {
        writer?.value(value?.serverId)
    }

}
