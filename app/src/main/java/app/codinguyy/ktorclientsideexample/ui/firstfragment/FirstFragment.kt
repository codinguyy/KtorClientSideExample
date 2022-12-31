package app.codinguyy.ktorclientsideexample.ui.firstfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import app.codinguyy.ktorclientsideexample.databinding.FragmentFirstBinding
import app.codinguyy.ktorclientsideexample.ui.firstfragment.FirstFragmentViewModel
import app.codinguyy.ktorclientsideexample.util.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<FirstFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButtonListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initButtonListener() {
        binding.buttonFirst.setOnClickListener {
            viewModel.getRandomJoke().observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.NetworkCallSuccess -> {
                        val jokes = it.data
                        binding.textviewFirst.text = jokes.toString()
                        binding.buttonFirst.isClickable = true
                        binding.progressbar.isVisible = false
                    }
                    is Resource.NetworkCallError -> {
                        binding.textviewFirst.text = it.exception.toString()
                        binding.buttonFirst.isClickable = true
                        binding.progressbar.isVisible = false
                    }
                    is Resource.NetworkCallLoading -> {
                        binding.textviewFirst.text = "loading"
                        binding.buttonFirst.isClickable = false
                        binding.progressbar.isVisible = true
                    }
                    else -> {
                    }
                }
            }
        }
    }
}