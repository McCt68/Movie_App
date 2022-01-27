package eu.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eu.example.movieapp.model.Movie
import eu.example.movieapp.model.getMovies
import eu.example.movieapp.navigation.MovieScreens
import eu.example.movieapp.screens.details.DetailsScreen
import eu.example.movieapp.widgets.MovieRow

// Passing a navController Object. this is called in MovieNavigation.kt
@Composable
fun HomeScreen(navController: NavController){
	Scaffold(topBar = {
		TopAppBar(
			backgroundColor = Color.LightGray,
			elevation = 0.dp) {
			Text(text = "Movies")
		}
	}) {
		MainContent(navController = navController)


	}
}

// Takes a list of Movie objects, from the data class Movie
@Composable
fun MainContent(
	navController: NavController,
	movieList: List<Movie> = getMovies()){
	Column(modifier = Modifier
		.padding(12.dp)) {
		LazyColumn{
			items(items = movieList){
				MovieRow(movie = it){movie ->

					// just testing onItemClick argument
					Log.d("Movie", "MainContent: $movie")

					// calls navController and navigates to route: DetailsScreen
					navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
				}
			}}
	}
}