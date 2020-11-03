package com.ml.spaceflightapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ml.spaceflightapp.R
import com.ml.spaceflightapp.util.LoadingState
import com.ml.spaceflightapp.view.adapter.FlightAdapter
import com.ml.spaceflightapp.viewmodel.FlightViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Class is used to display flight data to the user
 */
class HomeFragment : Fragment(){

    private val flightViewModel: FlightViewModel by viewModel()
    private lateinit var flightAdapter: FlightAdapter

    /**
     * When the class is initialised, inflate the fragment_home.xml layout
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    /**
     * Once the class has been inflated, initialise the RecyclerView and ViewModel observers
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseRecyclerView(view)
        setupObservers()
    }

    /**
     * Function is used to intialise the RecyclerView and its Adapter
     * @param view
     */
    private fun initialiseRecyclerView(view: View){
        flightAdapter = FlightAdapter()
        view.findViewById<RecyclerView>(R.id.flight_data_recyclerview).apply {
            adapter = flightAdapter
        }
    }

    /**
     * Function is used to listen for changes in state in the FlightViewModel class
     */
    private fun setupObservers(){

        flightViewModel.flightData.observe(viewLifecycleOwner, {
            flightAdapter.flightDataList = it.flightReponse
        })

        flightViewModel.loadingState.observe(viewLifecycleOwner, {
            when(it.status){
                LoadingState.Status.RUNNING -> showSnackBar("Loading Flight Data")
                LoadingState.Status.SUCCESS -> showSnackBar("Data Loaded Successfully")
                LoadingState.Status.FAILED -> showSnackBar("Unable to Load Flight Data")
            }
        })
    }

    /***
     * Function is used to display a message to the user
     * @param text
     */
    private fun showSnackBar(text: String){
        Snackbar.make(requireView(), text, Snackbar.LENGTH_LONG).show()
    }

}