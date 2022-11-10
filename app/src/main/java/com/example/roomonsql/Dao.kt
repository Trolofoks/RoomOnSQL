package com.example.roomonsql
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//это не обычный а Dao
@Dao
interface Dao {
    //Insert указывает если получаем item значит хотим записать его в БД
    @Insert
    fun insertItem(item: ItemModel)
    //создает запрос на получения item'ов (* значит ВСЁ)
    //Flow (НЕ ИЗ ROOM) автоматический обновляет Инфу из БД
    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<ItemModel>>
}