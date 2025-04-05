import java.time.LocalDateTime
import java.util.*

enum class Tags{WORK,PERSONAL,IDEAS,UNKNOWN}


data class NotesData(
    val notes_id: Int,
    val timespan: String = LocalDateTime.now().toString(),
    var notes:String,
    var tags:String?,
)
