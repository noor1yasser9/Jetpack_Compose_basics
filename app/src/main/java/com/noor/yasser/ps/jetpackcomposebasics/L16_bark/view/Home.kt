package com.noor.yasser.ps.jetpackcomposebasics.L16_bark.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.noor.yasser.ps.jetpackcomposebasics.L16_bark.component.ItemDogCard
import com.noor.yasser.ps.jetpackcomposebasics.L16_bark.component.TopBar
import com.noor.yasser.ps.jetpackcomposebasics.L16_bark.model.Dog

@Composable
fun Home(
    navController: NavHostController,
    dogList: List<Dog>, toggleTheme: () -> Unit
) {
    LazyColumn {
        item {
            TopBar(onToggle = toggleTheme)
            Spacer(
                modifier = Modifier.height(8.dp)
            )

        }

        items(dogList) { item ->
            ItemDogCard(dog = item,
                onItemClicked = { dog ->
                    navController.navigate(
                        "details/${
                            dog.id
                        }/${dog.name}/${
                            dog.location
                        }"
                    )
                })
        }
    }
}