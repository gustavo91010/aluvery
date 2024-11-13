package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.R
import br.com.alura.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun productSection() {
    Column {
        Text(
            text = "Promoções",
            Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(top = 8.dp)
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

@Preview(showBackground = true)
@Composable
private fun productSectionPreview() {
    Column {
        productSection()
        productSection()
        productSection()
    }
}