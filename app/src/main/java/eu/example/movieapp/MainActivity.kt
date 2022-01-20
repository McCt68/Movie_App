package eu.example.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.example.movieapp.navigation.MovieNavigation
import eu.example.movieapp.ui.theme.MovieAppTheme

/* First setContent, calls myApp, which takes a @Composable function as parameter -
The parameter is MovieNavigation, which is a function that handles navigation between screens -
In MovieNavigation we set routes, to our destinations -
The startDestination is HomeScreen -
From HomeScreen we can call MovieNavigation with onClick to take another route to DetailsScreen.

 */

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MyApp {
				MovieNavigation()
			}

		}
	}
}

// The parameter content is another composable function. Here content is a container function
@Composable
fun MyApp(content: @Composable () -> Unit) {
	MovieAppTheme {
		content()
	}
}



// Arguments is a Movie Title in a string
// and a Lambda which default to an empty lambda
@Composable
fun MovieRow(movie: String, onItemClick:(String)-> Unit = {}) {
	Card(modifier = Modifier
		.padding(4.dp)
		.fillMaxWidth()
		.height(130.dp)
		.clickable {
			onItemClick(movie)
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
				Icon(
					imageVector = Icons.Default.AccountBox,
					contentDescription = "Movie Image")
			}
			Text(text = movie)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	MyApp {
		MovieNavigation()
	}
}
