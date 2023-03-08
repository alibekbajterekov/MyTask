package com.example.mytask.ui.home.NewTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentNewTaskBinding
import com.example.mytask.App
import com.example.mytask.ui.home.TaskModel

class NewTaskFragment : Fragment() {
    private lateinit var binding: FragmentNewTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTaskBinding.inflate(inflater,container,false)
        initViews()
        initListeners()
        return binding.root
    }
    private fun initViews() {
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener{
            /*setFragmentResult("new_task", bundleOf(
                "title" to binding.etTitle.text.toString(),
                "desc" to binding.etDesc.text.toString()
            ))*/
            App.database.taskDao()?.insert(
                TaskModel(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.text.toString()
            )
            )
            findNavController().navigateUp()
        }
    }
}