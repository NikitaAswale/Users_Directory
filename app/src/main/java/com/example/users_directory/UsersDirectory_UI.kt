package com.example.users_directory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersDirectory_UI(viewModel: UsersViewModel = hiltViewModel()) {

    val users by viewModel.users.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Users Directory",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )

                        Spacer(Modifier.width(8.dp))

                        Text(
                            text = "248",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray,
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color(0xFFB3E5FC))
                                .padding(horizontal = 12.dp, vertical = 1.dp)
                        )

                        Spacer(Modifier.weight(1f))

                        Icon(
                            painter = painterResource(android.R.drawable.ic_menu_search),
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier.size(25.dp)
                        )

                        Spacer(Modifier.width(8.dp))

                        Icon(
                            painter = painterResource(android.R.drawable.ic_menu_save),
                            tint = Color.White,
                            contentDescription = "Notes Header Icon",
                            modifier = Modifier
                                .clip(RoundedCornerShape(50.dp))
                                .background(Color.Blue)
                                .padding(6.dp)
                                .size(25.dp)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 12.dp)
        ) {

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Row(modifier = Modifier.fillMaxWidth()) {

                        Icon(
                            painter = painterResource(android.R.drawable.ic_menu_search),
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier.size(25.dp)
                        )

                        Spacer(Modifier.width(8.dp))

                        Text(
                            text = "Search colleagues by name, role, department",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                        )
                    }
                }
            )

            Spacer(Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = "All(8)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFB3E5FC))
                        .padding(horizontal = 12.dp, vertical = 1.dp)
                )

                Spacer(Modifier.width(8.dp))

                val category = listOf<String>(
                    "Engineering",
                    "Design",
                    "Product",
                    "People",
                    "Finance",
                    "Marketing"
                )
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(category) { categoty ->
                        RowItems(categoty)
                    }
                }

            }

            Spacer(Modifier.height(16.dp))

            LazyColumn() {
                items(users){
                    users->
                    CardView(users)
                }
            }

        }
    }
}

@Composable
fun RowItems(
    category: String
) {
    Text(
        text = category,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Color.DarkGray,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFB3E5FC))
            .padding(horizontal = 12.dp, vertical = 1.dp)
    )

    Spacer(Modifier.width(8.dp))
}

@Composable
fun CardView(users: Users) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                painter = painterResource(
                    R.drawable.ic_launcher_foreground
                ),
                contentDescription = "users",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = Color.Black)
                    .size(50.dp),
                tint = Color.White

            )

            Spacer(Modifier.width(8.dp))

            Column(modifier = Modifier) {
                Text(
                    text = "${users.name}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

                Text(
                    text = "Lead Product Designer",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                )

                Spacer(Modifier.height(4.dp))

                Row(modifier = Modifier) {
                    Text(
                        text = "Design",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFFB3E5FC))
                            .padding(horizontal = 12.dp, vertical = 1.dp)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(android.R.drawable.ic_menu_compass),
                            tint = Color.Black,
                            contentDescription = "Search Icon",
                            modifier = Modifier.size(25.dp)
                        )
                        Text(
                            text = "${users.address.city}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(android.R.drawable.ic_dialog_email),
                        tint = Color.Black,
                        contentDescription = "email",
                        modifier = Modifier.size(15.dp)
                    )

                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = "${users.email}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                    )

                    Spacer(Modifier.weight(1f))

                    Icon(
                        painter = painterResource(android.R.drawable.ic_media_previous),
                        tint = Color.Black,
                        contentDescription = "back",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

//            Text(
//                text = "Active",
//                fontSize = 14.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Green,
//                modifier = Modifier
//                    .clip(RoundedCornerShape(20.dp))
//                    .background(Color(0XFFE8F5E9))
//                    .padding(horizontal = 12.dp, vertical = 1.dp)
//            )

        }
    }
}