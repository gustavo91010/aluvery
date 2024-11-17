package br.com.alura.aluvery.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleProducts
import br.com.alura.aluvery.sampledata.sampleSections
import br.com.alura.aluvery.ui.components.CardProductItem
import br.com.alura.aluvery.ui.components.ProductsSection
import br.com.alura.aluvery.ui.theme.AluveryTheme
import kotlin.random.Random

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {

    Column {
        //remember vai manter o ultimo estado salvo
        var text by remember { mutableStateOf("") }


        //onValueChange identifica se o valor esta sendo alterado
        OutlinedTextField(value = text,
            onValueChange = { newValue ->
                text = newValue // o valor de newValue vai para nosso text
            }, Modifier // modificando a caixa do texto
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(100),
            leadingIcon = {
                //No box 1, o incone
                Icon(Icons.Default.Search, contentDescription = "busca")
                //No box 2,a  descrição:


            },
            label = { Text(text = "Produto") },
            // A dica aparece quando se interage com o box
            placeholder = { Text(text = "O que voc procura?") }

        )
        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            items(sampleProducts){
                p -> CardProductItem(product = p, Modifier.padding(horizontal = 16.dp))
            }
//            // Apresentar as secoçes de itens:
//            for (section in sections) {
//                val title = section.key
//                val products = section.value
//                item {
//                    ProductsSection(
//                        title = title, products = products
//                    )
//                }
//            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}