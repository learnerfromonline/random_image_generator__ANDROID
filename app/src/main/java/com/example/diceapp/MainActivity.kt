package com.example.diceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceapp.ui.theme.DiceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceAppTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(R.drawable.old_paper_stained_red),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()

                )
                    DiceApp()
                }
            }
        }
    }
}

@Composable
fun DiceApp(modifier: Modifier = Modifier){
    DiceImage(modifier = modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun DiceImage(modifier: Modifier = Modifier)
{
    var result by remember { mutableStateOf(1) }
    var imageres = when(result){
        1->R.drawable.charminar
        2->R.drawable.gateway_to_india_pd_blog
        3->R.drawable.hawa_mahal_pd_blog
        4->R.drawable.golden_temple_pd_blog
        5->R.drawable.meenakshi_temple_pd_blog
        6->R.drawable.mysore_palace_pd_blog
        7->R.drawable.qutub_minar_pd_blog
        8->R.drawable.red_fort_pd_blog
        9->R.drawable.sanchi_stupi_pd_blog

        else ->R.drawable.taj_mahal_pd_blog
    }
    var textres by remember { mutableStateOf(1) }

    var txtres = when(textres){
        1->R.string.charminar
        2->R.string.gateway_mumbai
        3->R.string.hawa_mahal
        4->R.string.golden_temple
        5->R.string.meenakshi_temple
        6->R.string.mysore_palace
        7->R.string.qutubminar
        8->R.string.redFort
        9->R.string.sachi_stupta
        else ->R.string.taj_mahal

    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(top = 16.dp) // Margin at the top
            .background(color = Color.LightGray)
            .height(60.dp)
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)) // Add border radius to bottom corners
    ) {
        Text(
            text = "Monuments",
            fontSize = 25.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
//                .padding(vertical = 12.dp) // Add padding to Text for better spacing
                .padding(top=25.dp)
        )
    }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = Modifier) {
            Image(painter = painterResource(R.drawable.cement),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .matchParentSize()
                    .width(350.dp)
                    .height(450.dp)
                    .clip(RoundedCornerShape(23.dp)))
            Text(
                stringResource(txtres),
                fontSize = 20.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(start = 38.dp, end = 38.dp, top = 13.dp, bottom = 13.dp),
                fontFamily = FontFamily.SansSerif
            )
        }
        Spacer(Modifier.height(45.dp))
        Image(
            painter = painterResource(imageres),
            contentDescription = result.toString(),
            modifier = Modifier

                .clip(RoundedCornerShape(24.dp)
                )
        )
        Spacer(Modifier.height(60.dp))
        Button(onClick = {result = (1..10).random()
                         textres = (1..10).random()},
            Modifier
                .width(190.dp)
                .height(53.dp)) {
            Text(stringResource(R.string.roll),
                fontSize = 23.sp,
                color = Color.White

                )
        }
    }
}

@Preview
@Composable
fun Dicprev(){
    DiceApp()
}
