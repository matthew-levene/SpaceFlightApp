# Space Flight App
The Space Flight App provides users with a list of Falcon 9 launches detailing the flight name, flight date and mission success. The data shown in the app is retrieved from the SpaceX API. 

![Alt text](app/docs/images/first-launches-screenshot.png?raw=true "First Launches Screenshot") ![Alt text](app/docs/images/second-launches-screenshot.png?raw=true "Second Launches Screenshot")

# Software Development Approach
This software was developed using an Agile and TDD methodology

# Architecture Design
The Project follows a MVVM with Repository pattern architecture. This architecture was chosen for:
- Seperation of Concerns that provides a way to testing the architecture components in isolation and allows for the View classes to be updated without modifying the ViewModel classes.
- Resilience to configuration changes allows the ViewModel classes to store UI data that would otherwise be lost on screen rotation or activity lifecycle changes.
- Communication between fragments using a ViewModel class removes the need for fragments to communicate via an Activity using callbacks.

The View classes use data binding to communicate updates to their respective ViewModel classes. The ViewModel classes communicate with a Repository class using coroutines and receives responses using LiveData. This is then passed back to the View classes observing this LiveData. The Repository class communicates with a RESTful API using Retrofit and caches the response to a local Room database.

![Alt text](app/docs/mvvm_architecture.png?raw=true "MVVM Architecture") 

# Test Cases
Espresso provides End-to-End testing of the application and network calls. Test cases included: 
- Testing the HomeFragment TextView and RecyclerView

Mockito testing provides Unit testing of the ViewModel and Repository dependencies. Test cases included:
- Testing the coroutine launch function in the FlightViewModel and the FlightRepository classes
- Testing the dependency interactions between the FlightViewModel and FlightRepository classes
- Testing the dependency interactions between the FlightRepository and the FlightDao interfaces

# Libraries Used
- Koin to provide constructor dependency injection to classes in the application
- Retrofit to provide access to the backend API endpoints
- WorkManager to retrieve flight data from the API service in the background
- Coroutines to run API network requests on background threads
- AndroidX to provide Lifecycle and LiveData functionality to the app
- Room to store the Flight responses from Retrofit.
- Data binding to bind the inflated layout files to instances running in the application code.
- Espresso to perform instrumentation tests on the user interface
- Mockito to mock the FlightViewModel and FlightRepository classes

*Alternative Libraries*

For instrumentation testing Robolectric could be used and for unit testing the MockK would be ideal since it uses Kotlin DSL to support mocking test cases.
Volley could be used as an alternative networking library for Retrofit and lastly, Dagger Hilt could be used as an alternative dependency injection library.

# Further Improvements
- Refactor project to use Pagination 3 that has been developed with Kotlin coroutines in mind.
- Implement a Bottom Navigation that contains an about SpaceX fragment and a SpaceX news fragment.
