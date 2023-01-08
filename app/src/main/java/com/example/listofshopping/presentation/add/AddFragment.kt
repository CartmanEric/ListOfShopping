package com.example.listofshopping.presentation.add

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.listofshopping.R
import com.example.listofshopping.databinding.FragmentAddBinding
import com.example.listofshopping.domain.ListOfShoppingModel
import com.example.listofshopping.presentation.ListOfShoppingApp
import com.example.listofshopping.presentation.ViewModelFactory
import javax.inject.Inject


class AddFragment : Fragment() {

    private val component by lazy {
        (requireActivity().application as ListOfShoppingApp).component}

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by  lazy {
        ViewModelProvider(this,viewModelFactory)[AddViewModel::class.java]
    }

    private var _binding: FragmentAddBinding? = null
    private val binding: FragmentAddBinding
        get() = _binding ?: throw RuntimeException("FragmentAddBinding == null")

    override fun onAttach(context: Context) {
        component.injectAddFragment(this)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBarSetup()
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
        }

    }

    private fun saveItem() {
        val currentItem = ListOfShoppingModel(
            binding.etLcd.text.toString(),
            binding.etOthers.text.toString(),
            binding.edPort.text.toString(),

            )
        viewModel.addItem(currentItem)
    }

    private fun toolBarSetup() {
        binding.toolbar.menu.removeItem(R.id.delete_bt)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.save_bt -> saveItem()
            }
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
