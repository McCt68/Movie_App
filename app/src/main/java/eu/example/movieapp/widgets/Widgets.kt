package eu.example.movieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import eu.example.movieapp.model.Movie
import eu.example.movieapp.model.getMovies


// Arguments is a Movie object
// and a Lambda which default to an empty lambda
@Preview
@Composable
fun MovieRow(
	movie: Movie = getMovies()[0], // get the first index
	onItemClick:(String)-> Unit = {}) {
	Card(modifier = Modifier
		.padding(4.dp)
		.fillMaxWidth()
		.height(130.dp)
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
			}

		}
	}
}