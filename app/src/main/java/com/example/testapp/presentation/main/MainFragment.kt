package com.example.testapp.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.presentation.main.adapter.RecyclerAdapter


// правильно ли я реализовываю передачу данных в ресайклер вью?
//как реализовать onclickListener на recyclerView?


class MainFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerAdapter
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val peopleList = viewModel.peopleListLiveData.observe(viewLifecycleOwner, Observer { it ->
            adapter = RecyclerAdapter(it)
            recyclerView = view.findViewById(R.id.main_fragment_recycler_view)
        })
    }
}