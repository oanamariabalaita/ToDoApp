package com.example.todoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class Task  @JvmOverloads constructor(
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @PrimaryKey @ColumnInfo(name = "entryid") var id: String = UUID.randomUUID().toString()
){
    @ColumnInfo(name = "completed") var isCompleted = false

    val titleForList: String
        get() = if (title.isNotEmpty()) title else description


    val isActive
        get() = !isCompleted

    val isEmpty
        get() = title.isEmpty() && description.isEmpty()

}