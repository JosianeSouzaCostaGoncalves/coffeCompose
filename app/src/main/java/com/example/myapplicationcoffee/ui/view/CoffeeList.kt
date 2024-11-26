package com.example.myapplicationcoffee.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.myapplicationcoffee.data.remote.model.Coffee
import com.example.myapplicationcoffee.viewModel.CoffeeViewModel

@Composable
fun CoffeeScreen(coffeeViewModel: CoffeeViewModel) {
    val hotCoffees = coffeeViewModel.hotCoffees
    val coldCoffees = coffeeViewModel.coldCoffees

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Cafés Quentes",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
            modifier = Modifier.padding(16.dp)
        )
        CoffeeList(coffees = hotCoffees)

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Cafés Gelados",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
            modifier = Modifier.padding(16.dp)
        )
        CoffeeList(coffees = coldCoffees)
    }
}

@Composable
fun CoffeeList(coffees: List<Coffee>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(coffees) { coffee ->
            CoffeeItem(coffee)
        }
    }
}

@Composable
fun CoffeeItem(coffee: Coffee) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = coffee.name,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = coffee.description,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = rememberImagePainter(coffee.image),
            contentDescription = coffee.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeScreenPreview() {
    CoffeeScreen(coffeeViewModel = CoffeeViewModel())
}