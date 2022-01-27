package eu.example.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eu.example.movieapp.navigation.MovieScreens

/// THIS MY OWN TEST TO MAKE A DETAILS SCREEN I CAN CALL FROM HOMESCREEN
// Passing a navController and movieData string
@Composable
fun DetailsScreen(
	navController: NavController,
	movieData: String?){
	Scaffold(topBar = {
		TopAppBar(
			backgroundColor = Color.Transparent,
			elevation = 0.dp
			) {
			Row(horizontalArrangement = Arrangement.Start) {
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
					verticalArrangement = Arrangement.Center) {
					Text(
						text = movieData.toString(),
						style = MaterialTheme.typography.h5)
				}
			}
	}
}
