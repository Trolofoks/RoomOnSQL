package com.example.roomonsql

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//указываем что это Entity а не обычный Model и даем название таблице
@Entity (tableName = "items")
data class ItemModel (
    //автогениратор ключа(записывает его на строчку ниже)
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    //отсюда начинаются те саммые колонны(записывают как и ключ)
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "second")
    var secondName: String,
    @ColumnInfo(name = "third")
    var thirdname: String
)