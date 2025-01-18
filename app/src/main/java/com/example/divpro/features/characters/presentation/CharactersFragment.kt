package com.example.divpro.features.characters.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.divpro.R
import com.example.divpro.databinding.FragmentCharactersBinding
import com.example.divpro.features.characters.presentation.adapter.CharactersAdapter
import com.example.divpro.utils.ViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment: Fragment(R.layout.fragment_characters) {

    private val viewBinding: FragmentCharactersBinding by viewBinding(FragmentCharactersBinding::bind)
    private val viewModel: CharactersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observe()
    }

    private fun initViews(){
        viewBinding.rvCharacters.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun observe() {
        viewModel.character.observe(viewLifecycleOwner){
            when(it){
                ViewState.Empty -> {
                    Toast.makeText(requireContext(),
                        getString(R.string.response_empty), Toast.LENGTH_SHORT).show()
                }
                is ViewState.Error -> {
                    Log.d("CharactersFragment", "observe: ${it.throwable}")
                    Toast.makeText(requireContext(),
                        getString(R.string.response_error), Toast.LENGTH_SHORT).show()
                }
                is ViewState.Show -> {
                    Log.d("CharactersFragment", "observe: ${it.data.results}")
                    viewBinding.rvCharacters.adapter = CharactersAdapter(it.data.results, requireContext())
                }
            }
        }
        viewModel.isVisible.observe(viewLifecycleOwner){
            viewBinding.progress.isVisible = it
            viewBinding.rvCharacters.isVisible = !it
            viewBinding.tvTitle.isVisible = !it
        }
    }

}