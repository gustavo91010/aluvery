package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.sampledata.sampleProducts

@Composable
fun SearchTextField(
    textoDeBusca: String,
    onSearcheChange: (String) -> Unit, // parece que eu posso definir como vai ser a resposta aqui, nos parametros...
) {

    //onValueChange identifica se o valor esta sendo alterado
    OutlinedTextField(value = textoDeBusca,
        onValueChange = { newValue ->
            onSearcheChange(newValue) // o valor de newValue vai para nosso text
        }, Modifier // modificando a caixa do texto
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(100),
        leadingIcon = {
            //No box 1, o incone
            Icon(Icons.Default.Search, contentDescription = "busca")


        },
        //No box 2,a  descrição:

        label = { Text(text = "Produto") },
        // A dica aparece quando se interage com o box
        placeholder = { Text(text = "O que voc procura?") }

    )
}