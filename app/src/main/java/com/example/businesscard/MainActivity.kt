package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFD2E7D4)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NameBox(
            imagePainter = painterResource(R.drawable.android_logo),
            name = stringResource(R.string.name),
            title = stringResource(R.string.title),
            Modifier.weight(1f)
        )
        ContactBox(
            phoneNumber = stringResource(R.string.phone_number),
            media = stringResource(R.string.social_media_account),
            email = stringResource(R.string.email),
            Modifier.weight(1f)
        )
    }
}

@Composable
fun NameBox(imagePainter: Painter, name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            Modifier
                .background(Color(0xFF073042))
                .size(width = 150.dp, height = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "Android logo",
                modifier = Modifier.padding(8.dp)
            )
        }
        Text(
            text = name,
            fontSize = 35.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006837),
        )

    }
}

@Composable
fun ContactBox(phoneNumber: String, media: String, email: String, modifier: Modifier = Modifier) {
    val MyAppIcons = Icons.Filled
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 70.dp, bottom = 4.dp),
        ) {
            Icon(
                modifier = Modifier.padding(end = 16.dp),
                imageVector = MyAppIcons.Phone,
                tint = Color(0xFF006837),
                contentDescription = "Phone Icon",
            )
            Text(
                text = phoneNumber,
                fontWeight = FontWeight.Bold,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 70.dp, bottom = 4.dp),
        ) {
            Icon(
                modifier = Modifier.padding(end = 16.dp),
                imageVector = MyAppIcons.Share,
                tint = Color(0xFF006837),
                contentDescription = "Social Media Icon"
            )
            Text(
                text = media,
                fontWeight = FontWeight.Bold,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 70.dp, bottom = 4.dp),
        ) {
            Icon(
                modifier = Modifier.padding(end = 16.dp),
                imageVector = MyAppIcons.Email,
                tint = Color(0xFF006837),
                contentDescription = "Email Icon",
            )
            Text(
                text = email,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardScreen()

    }
}