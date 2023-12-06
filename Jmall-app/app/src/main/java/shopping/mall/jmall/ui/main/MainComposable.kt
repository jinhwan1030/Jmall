package shopping.mall.jmall.ui.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import shopping.mall.jmall.ui.common.ProductCard
import shopping.mall.jmall.viewmodel.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainInsideScreen(viewModel: MainViewModel) {
    val productList by viewModel.productList.collectAsState(initial = listOf())
    val columnCount by viewModel.columnCount.collectAsState()

    LazyVerticalGrid(cells = GridCells.Fixed(columnCount)){
        items(productList.size) {
            ProductCard(product = productList[it]) {
                //상세화면 개발시 추가.
            }
        }
    }
}