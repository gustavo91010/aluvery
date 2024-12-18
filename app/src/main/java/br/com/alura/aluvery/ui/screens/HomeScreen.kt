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
import br.com.alura.aluvery.ui.components.SearchTextField
import br.com.alura.aluvery.ui.theme.AluveryTheme
import kotlin.random.Random

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    textoDeBusca: String = ""
) {

    Column {

        var text by remember { mutableStateOf(textoDeBusca) }
        SearchTextField(text, onSearcheChange = { text = it })
        // parece que cada vez que o SearchTextField rodar, ele atualiza o estado...
        //com esse onSearcheChange...

        /*
garantir que esse codigo so seja executadno novamente, (em um anova renderização de tela)
se o texto for outro...
com a configuração do remember, o codigo só vai regair se o valor for outro
 */
        var searcheProducts = remember(text) {

            sampleProducts.filter { product ->
                product.name.contains(text, true)
                        || product.description?.contains(text, true)
                        ?: false
                //Como o descrição pode ser nulo, se tiver, eu pergunto, se não, ja mando umf alse para o filtro
            }
        }
        LazyColumn(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            // vefiicar se foi digitado algum valor do textField:
            if (text.isBlank()) {
                // Apresentar as secoçes de itens:
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title, products = products
                        )
                    }
                }
            } else {
//exibe os cards
                // o sampleProducts tem todos os nossos produtos, seria nosso banco de dados
                items(searcheProducts) { p ->
                    CardProductItem(product = p, Modifier.padding(horizontal = 16.dp))
                }
            }

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