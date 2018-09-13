package com.gavinandre.kotlinandroid

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.gavinandre.kotlinandroid.model.Todo
import io.realm.RealmBasedRecyclerViewAdapter
import io.realm.RealmResults
import io.realm.RealmViewHolder
import org.jetbrains.anko.textColor

class TodoAdapter(context: Context,
                  realmResults: RealmResults<Todo>,
                  automaticUpdate: Boolean,
                  animateResults: Boolean,
                  private val clickListener: TodoItemClickListener) :
        RealmBasedRecyclerViewAdapter<Todo, TodoAdapter.ViewHolder>(
                context,
                realmResults,
                automaticUpdate,
                animateResults) {

    override fun onCreateRealmViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val v = inflater.inflate(R.layout.todo_item, viewGroup, false)
        return ViewHolder(v, clickListener)
    }

    override fun onBindRealmViewHolder(viewHolder: ViewHolder, position: Int) {
        val todo = realmResults[position]
        viewHolder.run {
            todoTitle.text = todo.title
            todoTitle.fontFeatureSettings = "font-size:12px"
            todoTitle.textColor = Color.argb(255, 69, 106, 124)
            todoContent.text = todo.content
        }
    }

    interface TodoItemClickListener {
        fun onClick(caller: View, todo: Todo)
    }

    inner class ViewHolder(view: View, private val clickListener: TodoItemClickListener?) :
            RealmViewHolder(view), View.OnClickListener {
        // Bind a field to the view for the specified ID. The view will automatically be cast to the field type
        @BindView(R.id.todo_item_todo_title)
        lateinit var todoTitle: TextView
        // val todoTitle: TextView by bindView(R.id.todo_item_todo_title)
        @BindView(R.id.todo_item_todo_content)
        lateinit var todoContent: TextView
        // val todoContent: TextView by bindView(R.id.todo_item_todo_content)

        init {
            // Bind annotated fields and methods
            ButterKnife.bind(this, view)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            clickListener?.onClick(v, realmResults[adapterPosition])
        }
    }

}