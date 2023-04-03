package com.ivankljun.pekautomotive.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.ivankljun.pekautomotive.databinding.FragmentFormBinding


class FormFragment : Fragment() {
    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FormViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btSubmit.setOnClickListener {
            submitString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun submitString() {
        val stringToSubmit = binding.etStringForm.text.toString()
        if (stringToSubmit.isBlank()) {
            alertDialog()
        } else {
            viewModel.postString(stringToSubmit)
        }
    }

    private fun alertDialog() {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("You must enter a message")
        builder.setTitle("Error")
        builder.setPositiveButton(android.R.string.ok, null)
        builder.show()
    }
}