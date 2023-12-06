package shopping.mall.domain.usecase

import shopping.mall.domain.model.TempModel
import shopping.mall.domain.repository.TempRepository
import javax.inject.Inject

class TempUseCase @Inject constructor(private val repository: TempRepository){

    fun getTempModel() : TempModel{
        return repository.getTempModel()
    }
}