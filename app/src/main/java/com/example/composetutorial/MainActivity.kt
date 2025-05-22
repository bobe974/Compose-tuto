package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(com.example.composetutorial.Message("Android","Jetpack compose"))
                }
            }

        }
    }
}

data class  Message(val author: String, val body: String)
@Composable
fun MessageCard(msg : com.example.composetutorial.Message){
    Row {
        Image(painter = painterResource(R.drawable.rsa),
            contentDescription = "Rsa dream",
            modifier = Modifier.size(40.dp).clip(CircleShape).border(1.5.dp, MaterialTheme.colorScheme.primary,
                CircleShape), contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(2.dp))

        Column() {
            Text(text = msg.author, color = MaterialTheme.colorScheme.secondary, style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(5.dp))
            Surface (shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp){
                Text(text = msg.body, modifier = Modifier.padding(all = 4.dp), style = MaterialTheme.typography.bodyMedium )
            }

        }
    }

}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun MessageCardPreview() {
    ComposeTutorialTheme {
        Surface {
            MessageCard(com.example.composetutorial.Message("Etienne","J-14 avant de toucher le saint Rsa"))
        }
    }

}