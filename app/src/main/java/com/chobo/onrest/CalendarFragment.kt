package com.chobo.onrest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chobo.onrest.databinding.CalendarBinding
import com.chobo.onrest.databinding.CommunityBinding

class CalendarFragment : Fragment() {

    private lateinit var binding: CalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CalendarBinding.inflate(inflater, container, false)
        return binding.root
    }
}