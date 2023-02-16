package com.example.mytask.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mytask.R
import com.example.mytask.databinding.FragmentProfileBinding
import java.util.prefs.Preferences

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding



    var mGetContent: ActivityResultLauncher<String> = registerForActivityResult(
        ActivityResultContracts.GetContent()) { uri ->
        binding.imgProfile.setImageURI(uri)


    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        initViews()
        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.imgProfile.setOnClickListener {
            mGetContent.launch("image/*")

        }
    }

    private fun initViews() {



    }
    }