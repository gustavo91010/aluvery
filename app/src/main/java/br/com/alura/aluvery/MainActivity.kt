package br.com.alura.aluvery

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.ui.theme.AluveryTheme
import br.com.alura.aluvery.ui.theme.Purple200
import br.com.alura.aluvery.ui.theme.Purple500
import br.com.alura.aluvery.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    productItem()
                }
            }
        }
    }
}

@Preview
@Composable
fun productItem() {
    Column(
        Modifier
            .height(250.dp)
            .width(250.dp)
            .background(Color.White)) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Purple500, Teal200
                        )
                    )
                )
        ) {
        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "deixa aqui a descrição da imagem do produto",
            Modifier.size(100.dp)// é bom usar o size quando altura e largura são do mesmo tamanho
                .offset( y=(-50).dp)
                .clip(shape = CircleShape)
                .align(Alignment.CenterHorizontally) //existem algusn metodos do modifier que saõ disponovel e  outros que não, dependendo do escopo/componente

        )
        Text("Texto 01!")
        Text("Texto 012!")
    }
}