package com.example.listofshopping.presentation.edit

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.listofshopping.R
import com.example.listofshopping.databinding.FragmentEditBinding
import com.example.listofshopping.domain.ListOfShoppingModel
import com.example.listofshopping.presentation.ListOfShoppingApp
import com.example.listofshopping.presentation.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class EditFragment : Fragment() {

    private val component by lazy {
        (requireActivity().application as ListOfShoppingApp).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[EditViewModel::class.java]
    }
    private var _binding: FragmentEditBinding? = null
    private val binding: FragmentEditBinding
        get() = _binding ?: throw RuntimeException("FragmentEditBinding == null")

    private val args by navArgs<EditFragmentArgs>()



    override fun onAttach(context: Context) {
        component.injectEditFragment(this)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.checkConditionScreen.observe(viewLifecycleOwner) {
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
            getCurrentData(),
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
        findNavController().popBackStack()
    }

    private fun initView() {
        with(binding) {
            etLcd.setText(args.toEdit.lcd)
            edPort.setText(args.toEdit.ports)
            etOthers.setText(args.toEdit.others)
        }
    }

    private fun getCurrentData(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm", Locale.US)
        return sdf.format(Date())
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}