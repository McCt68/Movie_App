package eu.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable

// Need these to use by remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import eu.example.movieapp.model.Movie
import eu.example.movieapp.model.getMovies


// Arguments is a Movie object
// and a Lambda which default to an empty lambda
@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun MovieRow(
	movie: Movie = getMovies()[0], // get the first index
	onItemClick:(String)-> Unit = {}) {

	// Expand movie object if clicked
	var expandedState by remember {
		mutableStateOf(false)
	}

	Card(modifier = Modifier
		.padding(4.dp)
		.fillMaxWidth()
		// .height(130.dp)
		.clickable {
			onItemClick(movie.id)
		},
		shape = RoundedCornerShape(CornerSize(16.dp)),
		elevation = 6.dp
	){
		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Start) {
			Surface(modifier = Modifier
				.padding(12.dp)
				.size(100.dp),
				shape = RectangleShape,
				elevation = 4.dp) {

				// Get image from url with coil library
				Image(
					painter = rememberImagePainter(data = movie.images[0],
						builder = {
							crossfade(true)
							transformations(CircleCropTransformation())
						}),
					contentDescription = "Movie Poster"
				)

				// Showing an Icon
//				Icon(
//					imageVector = Icons.Default.AccountBox,
//					contentDescription = "Movie Image")
			}
			Column(modifier = Modifier.padding(4.dp)) {

				// the string title from the movie object
				Text(text = movie.title, style = MaterialTheme.typography.h6)
				Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.caption)
				Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.caption)

				AnimatedVisibility(visible = expandedState) {
					Column {
						Text(text = buildAnnotatedString {
							withStyle(style = SpanStyle(color = Color.DarkGray,
							fontSize = 13.sp)){
								append("Plot: ")
							}
							withStyle(style = SpanStyle(color = Color.DarkGray,
								fontSize = 13.sp,
							fontWeight = FontWeight.Normal)) {
								append(movie.plot)
							}
						}, modifier = Modifier.padding(top = 6.dp, bottom = 6.dp, end = 6.dp))

						Divider(modifier = Modifier.padding(bottom = 6.dp))
						
						Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.caption)
						Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.caption)
						Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.caption)

					}
				}

//				// This works with if statement
//				Column() {
//					if (expandedState == true) {
//						Text(text = "Hello there")
//					}
//				}

				Icon(
					imageVector = if (expandedState) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
					contentDescription = "Down Arrow",
					modifier = Modifier
						.size(25.dp)
						.clickable {
// Change state to the opposite when we click it, to eather show, or hide expanded
							expandedState = !expandedState
						},
					tint = Color.DarkGray)
			}


		}

	}
}