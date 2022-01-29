package eu.example.movieapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import eu.example.movieapp.model.Movie
import eu.example.movieapp.model.getMovies
import eu.example.movieapp.widgets.MovieRow

/// THIS MY OWN TEST TO MAKE A DETAILS SCREEN I CAN CALL FROM HOMESCREEN
// Passing a navController and movieData string
@Composable
fun DetailsScreen(
	navController: NavController,
	movieId: String?){

	//
	val newMovieList = getMovies().filter { movie ->
		movie.id == movieId
	}
	Scaffold(topBar = {
		TopAppBar(
			backgroundColor = Color.Transparent,
			elevation = 0.dp
			) {
			Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.Start) {
				Icon(
					imageVector = Icons.Default.ArrowBack,
					contentDescription = "Go back",
					modifier = Modifier.clickable {

					// calls navController and navigates to route: HomeScreen
					// navController.navigate(route = MovieScreens.HomeScreen.name)

					// Or simply pop the DetailsScreen from the stack, and go back to previous screen
					navController.popBackStack()
				})
				Spacer(modifier = Modifier.width(100.dp))
				Text(text = "Movies") } } }) {
		Surface(modifier = Modifier
				.fillMaxSize()) {
				Column(
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.Top) {

					MovieRow(movie = newMovieList[0]) // same as .first - may need @experimental

					Spacer(modifier = Modifier.height(8.dp))
					Divider()
					
					Text(text = "Movie Images")

					HorizontalScrollableImageView(newMovieList)

				}
			}
	}
}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Movie>) {
	LazyRow {
		items(newMovieList.first().images) { image ->
			Card(
				modifier = Modifier
					.padding(12.dp)
					.size(240.dp),
				elevation = 5.dp
			) {
				Image(
					painter = rememberImagePainter(data = image),
					contentDescription = "Movie Poster"
				)

			}
		}
	}
}
