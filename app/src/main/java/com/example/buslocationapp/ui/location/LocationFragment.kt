package com.example.buslocationapp.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.buslocationapp.databinding.FragmentLocationBinding
import com.example.buslocationapp.ui.location.LocationViewModel

class LocationFragment : Fragment() {

private var _binding: FragmentLocationBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val locationViewModel =
            ViewModelProvider(this).get(LocationViewModel::class.java)

    _binding = FragmentLocationBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.location
    locationViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}