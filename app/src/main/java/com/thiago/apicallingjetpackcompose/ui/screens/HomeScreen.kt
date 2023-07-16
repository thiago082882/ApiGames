package com.thiago.apicallingjetpackcompose.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.thiago.apicallingjetpackcompose.domain.items.GameItem
import com.thiago.apicallingjetpackcompose.ui.nav.Screens
import com.thiago.apicallingjetpackcompose.ui.vm.GameViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(gameViewModel: GameViewModel, navController: NavController) {

    val games = gameViewModel.games.observeAsState(listOf()).value

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(text = "Games App", fontWeight = FontWeight.Bold)

                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                )

            )

        }

    ) {

        LazyColumn {

            items(games) { game ->

                GameCard(game = game, navController = navController)

            }

        }

    }

}

@Composable
fun GameCard(game: GameItem, navController: NavController) {

    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 7.dp, bottom = 7.dp, start = 14.dp, end = 14.dp)
            .clickable {
                navController.navigate(Screens.Detail.route + "/${game.id}")
            }

    ) {

        Row {

            Image(
                painter = rememberImagePainter(game.thumbnail),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(175.dp)
                    .height(115.dp)
            )

            Column(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterVertically)) {

                Text(text = game.title, fontWeight = FontWeight.Bold)
                Text(text = game.short_description, maxLines = 2, overflow = TextOverflow.Ellipsis)

            }

        }

    }

}