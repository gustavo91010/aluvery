package br.com.alura.aluvery

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.extentions.toBrazilianCurrency
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.ui.theme.AluveryTheme
import br.com.alura.aluvery.ui.theme.Purple200
import br.com.alura.aluvery.ui.theme.Purple500
import br.com.alura.aluvery.ui.theme.Teal200
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
//                    productItem()
                    productSection()
                }
            }
        }
    }
}

@Composable
fun productSection() {
    Column {
        Text(
            text = "Promoções",
            Modifier.padding(16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),// garante a possibilidade de scroll e mantem os elementos do tamanho normal, respeitando o fim da tela
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)// um espacamento inicial no inicil da linha
            productItem(
                Product(
                    name = "Hamburguer", price = BigDecimal("23.99"), image = R.drawable.burger
                )
            )
            productItem(
                Product(
                    name = "Baatata fritas", price = BigDecimal("12.99"), image = R.drawable.fries
                )
            )
            productItem(
                Product(
                    name = "Pizza", price = BigDecimal("45.00"), image = R.drawable.pizza
                )
            )
        }
    }

}

@Composable
fun productItem(product: Product) {
    Surface(
        // Modifier.padding(8.dp),//espaço entre componentes
        shape = RoundedCornerShape(15.dp),// O RoundedCornerShape ajuda a manter a borda
        elevation = 4.dp// mantem a borda
    ) {
        //Colocamos tudo dentro do surface, pois ele tem uma gama maior de meétodos de personalização
        Column(
            Modifier
                .heightIn(250.dp, 300.dp) // altura minima e maxima
                .width(250.dp)
                .background(Color.White)
        ) {
            val imageSize = 100.dp;
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
            ) {

                Image(
                    painter = painterResource(id = product.image),
//                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "deixa aqui a descrição da imagem do produto",
                    Modifier
                        .size(imageSize)// é bom usar o size quando altura e largura são do mesmo tamanho
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter), //existem algusn metodos do modifier que saõ disponovel e  outros que não, dependendo do escopo/componente
                    contentScale = ContentScale.Crop // ele não diminui a imagem tentando por ela no espaço selecioando, ele coloca o que da pra ver pelo esapço
//                            contentScale = ContentScale.Fit // por padrão ele usa o fit, que é incaixando o eapço
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2)) // esse compose é só para manter um espacamento
            Column(Modifier.padding(16.dp)) {
                Text(
                    product.name,
//              Modifier.padding(16.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    product.price.toBrazilianCurrency(),
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500
                )
            }
        }
    }
}


// preview
@Preview(showBackground = true)
@Composable
private fun productSectionPreview() {
    productSection();
}

//@Preview(showBackground = true)
@Composable
private fun productItemPreview() {
    productItem(
        Product(
            name = LoremIpsum(50).values.first(),
            price = BigDecimal("15.78"),
            image = R.drawable.ic_launcher_background
        )
    )
}