package eu.example.movieapp.screens.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import eu.example.movieapp.screens.home.MainContent

/// THIS MY OWN TEST TO MAKE A DETAILS SCREEN I CAN CALL FROM HOMESCREEN
@Composable
fun DetailsScreen(navController: NavController){
	Text(text = "HELLO I AM DETAILS SCREEN !")
}