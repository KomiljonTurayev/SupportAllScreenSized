package com.example.supportallscreensized

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supportallscreensized.Todo
import com.example.supportallscreensized.TodoAdapter
import kotlinx.android.synthetic.main.activity_todo.*
import kotlinx.android.synthetic.main.item_layout.*

class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val todoList = mutableListOf(
            Todo("Follow AndroidDevs1", false),
            Todo("Follow AndroidDevs2", true),
            Todo("Follow AndroidDevs3", false),
            Todo("Follow AndroidDevs4", false),
            Todo("Follow AndroidDevs5", true),
            Todo("Follow AndroidDevs6", false),
            Todo("Follow AndroidDevs7", false),
            Todo("Follow AndroidDevs8", false),
        )

        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
            etTodo.text.clear()
        }
    }
}