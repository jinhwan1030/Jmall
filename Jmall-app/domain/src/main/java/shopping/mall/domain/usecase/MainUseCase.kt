package shopping.mall.domain.usecase

import kotlinx.coroutines.flow.Flow
import shopping.mall.domain.model.Product
import shopping.mall.domain.repository.MainRepository
import javax.inject.Inject

class MainUseCase @Inject constructor(private val mainRepository: MainRepository) {

    fun getProductList() : Flow<List<Product>> {
        return mainRepository.getProductList()
    }
}