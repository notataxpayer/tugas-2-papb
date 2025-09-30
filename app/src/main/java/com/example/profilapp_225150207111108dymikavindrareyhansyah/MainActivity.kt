package com.example.profilapp_225150207111108dymikavindrareyhansyah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilapp_225150207111108dymikavindrareyhansyah.ui.theme.ProfilApp_225150207111108DymiKavindraReyhansyahTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilApp_225150207111108DymiKavindraReyhansyahTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    // 1) State untuk Follow / Unfollow — menggunakan rememberSaveable supaya bertahan saat rotasi
    val isFollowing = rememberSaveable { mutableStateOf(false) }

    // 2) Semua konten dipusatkan di layar
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        // 3) Container profil dengan background berbeda, padding, dan rounded corner
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = MaterialTheme.colorScheme.secondaryContainer,
            tonalElevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .wrapContentHeight()
                .padding(12.dp)
        ) {
            // 4) Column terpusat horizontal (Alignment.CenterHorizontally)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(20.dp)
            ) {
                // Foto profil (bundar) — sesuaikan nama drawable: R.drawable.mekap
                Image(
                    painter = painterResource(id = R.drawable.gambar),
                    contentDescription = "Foto Profil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )

                // Jarak antar komponen menggunakan Spacer
                Spacer(modifier = Modifier.height(16.dp))

                // Nama lengkap
                Text(
                    text = "Dymi Kavindra R",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )

                Spacer(modifier = Modifier.height(8.dp))

                // NIM
                Text(
                    text = "225150207111108",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.85f)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Deskripsi singkat
                Text(
                    text = "Mahasiswa Teknik Informatika",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.9f)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Tombol Follow/Unfollow — state mengatur teks & warna
                Button(
                    onClick = { isFollowing.value = !isFollowing.value },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isFollowing.value) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .width(160.dp)
                        .height(48.dp)
                ) {
                    Text(
                        text = if (isFollowing.value) "Unfollow" else "Follow",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Opsional: indikator kecil yang menunjukkan status follow (visual feedback)
                if (isFollowing.value) {
                    Text(
                        text = "Kamu sedang mengikuti",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.9f)
                    )
                }
            }
        }
    }
}
