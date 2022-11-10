package com.example.roomonsql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.roomonsql.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataBase = MainDataBase.getDataBase(this)

        binding.button.setOnClickListener {
            //нельзя одинаковые id создавать, либо null либо разные
            val item = ItemModel(
                null,
                binding.editTextName.text.toString(),
                binding.editTextSecondName.text.toString(),
                binding.editTextThirdName.text.toString()
            )
            //так как это основной поток, здесь сохранять нельзя, и нужен новый Threat
            Thread{
                dataBase.getDao().insertItem(item)
            }.start()
        }
        //работает так же как LiveData
        dataBase.getDao().getAllItems().asLiveData().observe(this){ list ->
            binding.textList.text = ""
            list.forEach {
                val text = "Id: ${it.id}, " +
                        "Name: ${it.name}, " +
                        "Second: ${it.secondName}, " +
                        "Last: ${it.thirdname}\n"
                binding.textList.append(text)
            }
        }
    }
}