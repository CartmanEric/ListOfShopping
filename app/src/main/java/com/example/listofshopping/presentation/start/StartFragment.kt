package com.example.listofshopping.presentation.start

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.listofshopping.R
import com.example.listofshopping.databinding.FragmentStartBinding
import com.example.listofshopping.domain.ListOfShoppingModel
import com.example.listofshopping.presentation.ListOfShoppingAdapter

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding: FragmentStartBinding
        get() = _binding ?: throw RuntimeException("FragmentStartBinding == null")

    lateinit var viewModel: StartViewModel
    lateinit var listOfShoppingAdapter: ListOfShoppingAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        rvSetup()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        viewModel.listOfShopping.observe(viewLifecycleOwner) {
            listOfShoppingAdapter.submitList(it)
        }
        binding.addBt.setOnClickListener {
            navigation()
        }
        setupClickListening()
        setupSwipeListener(binding.rv)
    }

    private fun rvSetup() {
        val manager = GridLayoutManager(requireContext(), 2)
        with(binding.rv) {
            listOfShoppingAdapter = ListOfShoppingAdapter()
            layoutManager = manager
            adapter = listOfShoppingAdapter

        }

    }

    private fun setupClickListening() {
        listOfShoppingAdapter.onItemClickListener = {
            findNavController().navigate(
                StartFragmentDirections.actionStartFragmentToEditFragment(it)
            )
        }

    }

    private fun navigation() {
        findNavController().navigate(R.id.action_startFragment_to_addFragment)
    }

    private fun setupSwipeListener(rvListOfShopping: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = listOfShoppingAdapter.currentList[viewHolder.adapterPosition]
                showDialog(item)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvListOfShopping)
    }

    private fun showDialog(item: ListOfShoppingModel) {

        val listener = DialogInterface.OnClickListener { _, which ->
            when (which) {
                DialogInterface.BUTTON_POSITIVE -> viewModel.deleteItem(item)

            }
        }
        val dialog = AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setMessage("Вы точно хотите удалить?")
            .setPositiveButton("Да", listener)
            .setNegativeButton("Нет", listener)
            .create()
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}