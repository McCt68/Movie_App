package eu.example.movieapp.navigation

//enum is a class that holds Constants, we can reference too and use them with logic
// The Constants should uasely be written in Uppercase ( they are not in this example)

// This enum will hold all the UI screens i can navigate too

enum class MovieScreens {
	HomeScreen,
	DetailsScreen;

	// companion object means we can refer to a member without instantiating a object of the class ??
	// I Think i can call this function without instantiating a MovieScreens object first
	// I should be able to say something like MovieScreens.fromRoute(route = String?) in my mian function
	companion object{
		fun fromRoute(route: String?): MovieScreens
		= when (route?.substringBefore("/")) {
			HomeScreen.name -> HomeScreen
			DetailsScreen.name -> DetailsScreen
			null -> HomeScreen
			else -> throw IllegalArgumentException("Route $route is not recognized")
		}
	}

}