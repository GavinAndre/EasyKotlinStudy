package com.gavinandre.kotlinandroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView
import com.gavinandre.kotlinandroid.model.Todo
import io.realm.Realm

class TodosFragment : Fragment(), TodoAdapter.TodoItemClickListener {

    val MY_TAG = "MY_TODOS"

    // protected val realmRecyclerView: RealmRecyclerView by bindView(R.id.todos_recycler_view)
    // var realmRecyclerView: RealmRecyclerView? = null // var 可变 View
    @BindView(R.id.todos_recycler_view)
    lateinit var realmRecyclerView: RealmRecyclerView

    private var realm: Realm? = null

    companion object {
        fun newInstance(): TodosFragment {
            return TodosFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_todos, container, false)
        ButterKnife.bind(this, v)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        realm = Realm.getDefaultInstance()
    }

    override fun onResume() {
        super.onResume()
        val todos = realm!!.where(Todo::class.java).findAll()
        Log.i(MY_TAG, "onResume: $todos")
        //realmRecyclerView = find(R.id.todos_recycler_view) // 可变 View
        Log.i(MY_TAG, "onResume: realmRecyclerView = ${realmRecyclerView} ")
        val adapter = TodoAdapter(requireContext(), todos, true, true, this)
        realmRecyclerView.setAdapter(adapter)
    }

    override fun onDestroy() {
        super.onDestroy()
        realm!!.close()
    }

    // 点击事项，跳转编辑 EditFragment
    override fun onClick(caller: View, todo: Todo) {
        (activity as MainActivity).hideFab()

        val todoEditFragment = TodoEditFragment.newInstance(todo.id)
        activity?.apply {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content_main, todoEditFragment, todoEditFragment.javaClass.simpleName)
                    .addToBackStack(todoEditFragment.javaClass.simpleName)
                    .commit()
        }
    }
}