package shopping.mall.data.repository

import shopping.mall.data.datasource.TempDataSource
import shopping.mall.domain.model.TempModel
import shopping.mall.domain.repository.TempRepository
import javax.inject.Inject

class TempRepositoryImpl @Inject constructor(private val dataSource : TempDataSource): TempRepository {
    override fun getTempModel(): TempModel {
        return dataSource.getTempModel()
    }
}