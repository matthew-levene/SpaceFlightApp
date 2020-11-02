package com.ml.spaceflightapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ml.spaceflightapp.repository.FlightRepository
import com.ml.spaceflightapp.util.LoadingState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * Class is used to provide communications between the Repository and View classes
 */
class FlightViewModel(
    private val flightRepository: FlightRepository
) : ViewModel()
{
    /**
     * Listen for updates from the FlightRepository class
     */
    val flightData = flightRepository.flightData

    /**
     * Listen for changes in the API call loading state
     */
    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
    get() = _loadingState

    /**
     * Create a coroutine scoped to this ViewModel class
     */
    val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    /**
     * On initialisation, request updated flight data from the FlightRepository
     */
    init {
        getFlightData()
    }

    /**
     * Function requests the FlightRepository to update its data sources
     */
    fun getFlightData(){
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                flightRepository.getFlights()
                _loadingState.value = LoadingState.LOADED
            }
            catch (exception: HttpException){
                _loadingState.value = LoadingState.logError(exception.message())
            }
        }
    }
}
