package mx.edu.itson.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.itson.composepokedex.ui.theme.ComposePokedexTheme

class MainActivity : ComponentActivity() {
    val pokemon = Pokemon("Pikachu", 25,
        "Eléctrico",
        "lorem lorem lorem lorem lorem lorem lorem",
        0.4f, 6f,
        true, "Estática", R.drawable.pikachu)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                PokedexScreen(pokemon)
            }
        }
    }
}

@Composable
fun PokedexScreen(pokemon: Pokemon) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffd50000))
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Cyan, CircleShape)
                )
                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .background(Color.Yellow, CircleShape)
                )
                Box(modifier = Modifier
                    .size(15.dp)
                    .background(Color.Green, CircleShape)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                border = BorderStroke(3.dp, Color.Black)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = pokemon.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Image(
                        painter = painterResource(pokemon.image),
                        contentDescription = pokemon.name,
                        modifier = Modifier.size(80.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text("HP: 35")
                    Text("aTTACK: 55")
                    Text("Defense: 40")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botones inferiores [cite: 422-453]
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Blue, CircleShape)
                )
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(20.dp)
                            .background(Color.Green, RoundedCornerShape(percent = 50))
                    )
                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(20.dp)
                            .background(Color.Yellow, RoundedCornerShape(percent = 50))
                    )
                }
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Red, CircleShape)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Barra de búsqueda [cite: 456-468]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color(0xFFFFC107), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Busca tu pokemon",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color.White
                )
            }
        }
    }
}
//@Composable
//fun PokemonHeader(name: String, number: Int, fav: Boolean) {
//    Row(Modifier.fillMaxWidth().padding(15.dp), Arrangement.SpaceBetween) {
//        Column() {
//            Text(name, )
//            Text("#${number}", modifier = Modifier.align(Alignment.End))
//        }
//        Box {
//            Image(painter = painterResource(R.drawable.pokeball),
//                contentDescription = "pokball image",
//                contentScale = ContentScale.Fit,
//                modifier = Modifier.size(130.dp).offset(30.dp, 20.dp)
//            )
//            Image(painter = painterResource(if (fav)R.drawable.star_filled else R.drawable.star_outline),
//                contentDescription = if (fav) "yellow star filled" else "yello star outlined",
//                modifier = Modifier.align(Alignment.TopEnd)
//            )
//        }
//    }
//}
//
//@Composable
//fun PokemonCard(name: String, weight: Float, height: Float, description: String, ability: String, image: Int) {
//    var showInfo by remember { mutableStateOf(false) }
//
//    Card(
//        modifier = Modifier.padding(16.dp)
//            .clickable {
//                showInfo = !showInfo
//            }
//    ) {
//        Image(painter = painterResource(image), contentDescription = name)
//
//        if (showInfo) {
//            Text(text = "Descripción: $description")
//            Text(text = "Altura: $height m")
//            Text(text = "Peso: $weight kg")
//            Text(text = "Habilidad: $ability")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PokemonHeaderPreview() {
//    ComposePokedexTheme() {
//        PokemonHeader("Pikachu", 25, true)
//    }
//}
//
//@Composable
//fun Greeting(pokemon: Pokemon, modifier: Modifier = Modifier) {
//    Column() {
//        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
//        PokemonCard(pokemon.name, pokemon.weight, pokemon.height, pokemon.description, pokemon.ability, pokemon.image)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPrevieww() {
//    ComposePokedexTheme() {
//        Greeting(Pokemon("Pikachu", 25,
//            "Eléctrico",
//            "lorem lorem lorem lorem lorem lorem",
//            0.4f, 6f,
//            true, "Estática", R.drawable.pikachu))
//    }
//}