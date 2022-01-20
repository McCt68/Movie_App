package eu.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eu.example.movieapp.screens.details.DetailsScreen
// import eu.example.movieapp.screens.home.DetailsScreen
import eu.example.movieapp.screens.home.HomeScreen

// The job of the NavHost is basically just to show each Composable function when we call it ??
// So if its showing one screen and we call another one, -
// it just navigates to the new one, and pass any arguemnts we provided to the the new destination screen
// We can say we are build the navGraph here
// This function is passed to myApp as content, when we start the application
@Composable
fun MovieNavigation() {

	// Creating a navHost object, this will host all the nav graph
	// Instantiating a navController Object, so we can use navController class members on our new object
	val navController = rememberNavController()

	// NavHost is a composable function which help to host and -
	// navigate navGraph destinations in Jetpack Compose.
	// Will goto start destination when called first time
	NavHost(
		navController = navController,
		startDestination =  MovieScreens.HomeScreen.name) {

		// Here we pass where this should lead to - HomeScreen()
		composable(MovieScreens.HomeScreen.name) {
			HomeScreen(navController = navController)
		}

		// Here we pass which route to goto - DetailsScreen()
		composable(MovieScreens.DetailsScreen.name) {
			DetailsScreen(navController = navController)
		}

		// We could add many more routes here
	}
}