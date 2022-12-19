package com.example.listofshopping.presentation.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.listofshopping.R
import com.example.listofshopping.databinding.FragmentAddBinding
import com.example.listofshopping.databinding.FragmentEditBinding
import com.example.listofshopping.domain.ListOfShoppingModel


class EditFragment : Fragment() {
    private var _binding: FragmentEditBinding? = null
    private val binding: FragmentEditBinding
        get() = _binding ?: throw RuntimeException("FragmentEditBinding == null")
    lateinit var viewModel: EditViewModel
    private val args by navArgs<EditFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[EditViewModel::class.java]
        viewModel.checkConditionScreen.observe(viewLifecycleOwner){
            navigation()
        }
        initView()
        toolBarSetup()
    }


    private fun deleteItem() {
        viewModel.deleteItem(args.toEdit)
    }

    private fun saveItem() {
        val currentItem = ListOfShoppingModel(
            binding.etLcd.text.toString(),
            binding.etOthers.text.toString(),
            binding.edPort.text.toString(),
            args.toEdit.id
        )
        viewModel.editItem(currentItem)
    }

    private fun toolBarSetup() {
        binding.editToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.delete_bt -> deleteItem()
                R.id.save_bt -> saveItem()
            }
            true
        }
    }

    private fun navigation() {
        findNavController().navigate(R.id.action_editFragment_to_startFragment)
    }

    private fun initView() {
        with(binding) {
            etLcd.setText(args.toEdit.lcd)
            edPort.setText(args.toEdit.ports)
            etOthers.setText(args.toEdit.others)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}