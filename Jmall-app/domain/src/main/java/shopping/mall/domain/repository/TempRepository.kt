package shopping.mall.domain.repository

import shopping.mall.domain.model.TempModel

interface TempRepository {

    fun getTempModel() : TempModel
}