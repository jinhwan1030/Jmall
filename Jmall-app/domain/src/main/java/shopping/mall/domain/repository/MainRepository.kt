package shopping.mall.domain.repository

import kotlinx.coroutines.flow.Flow
import shopping.mall.domain.model.Product

interface MainRepository {
    fun getProductList() : Flow<List<Product>>
}