package com.example.sharedprefstest

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import com.example.sharedprefstest.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefs = requireActivity().getSharedPreferences("test", Context.MODE_PRIVATE)
        for(i in 0..1000) {
            prefs.edit(commit = true) {
                putString(i.toString(), i.toString())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val prefs = requireActivity().getSharedPreferences("test", Context.MODE_PRIVATE)
        for(i in 0..1000) {
            prefs.edit(commit = true) {
                putString(i.toString(), i.toString())
            }
        }
    }

    override fun onStop() {
        super.onStop()
        val prefs = requireActivity().getSharedPreferences("test", Context.MODE_PRIVATE)
        for(i in 0..10000) {
            prefs.edit(commit = true) {
                putString(i.toString(), i.toString())
            }
        }
        requireActivity().supportFragmentManager.beginTransaction()
            .remove(this@BlankFragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val prefs = requireActivity().getSharedPreferences("test", Context.MODE_PRIVATE)
        for(i in 0..10000) {
            prefs.edit(commit = true) {
                putString(i.toString(), i.toString())
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}