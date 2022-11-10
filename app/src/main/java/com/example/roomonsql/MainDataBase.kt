package com.example.roomonsql

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//ВАЖНО, анотация
@Database(entities = [ItemModel::class], version = 1)
// чтобы не просило методы делаем абстрактным
//обязательно наследование от RoomDatabase
abstract class MainDataBase : RoomDatabase() {
    //Dao не должен быть зеленого цвета, его не import
    abstract fun getDao(): Dao
    //промежуточное звено
    companion object{
        //наследования от нашего класса
        fun getDataBase(context: Context): MainDataBase{
            //получаем ответ
            return Room.databaseBuilder(
                context.applicationContext,
                MainDataBase::class.java,
                "Test.Database"
            ).build()
        }
    }
}