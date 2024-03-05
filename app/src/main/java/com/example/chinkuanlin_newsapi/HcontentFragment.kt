package com.example.chinkuanlin_newsapi

import androidx.fragment.app.Fragment
import android.os.Bundle
import androidx.navigation.fragment.navArgs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.findNavController
import com.example.chinkuanlin_newsapi.databinding.FragmentHcontentBinding
import com.example.chinkuanlin_newsapi.databinding.FragmentHeadlineBinding

class HcontentFragment : Fragment() {
    private var _binding: FragmentHcontentBinding? = null
    private val binding get() = _binding!!

    // 使用 navArgs 获取传递的参数
    private val args: HcontentFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // 初始化 ViewBinding
        _binding = FragmentHcontentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 使用 args 更新 UI
        binding.headlineTitle.text = args.title
        binding.headlineContext.text = args.content
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 避免内存泄漏
    }
}