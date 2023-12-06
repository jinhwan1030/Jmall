package shopping.mall.data.datasource

import shopping.mall.domain.model.TempModel
import javax.inject.Inject

class TempDataSource @Inject constructor() {

    fun getTempModel() : TempModel{
        return TempModel("testModel")
    }
}