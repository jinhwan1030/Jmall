package shopping.mall.jmall.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import shopping.mall.domain.model.TempModel
import shopping.mall.domain.usecase.TempUseCase
import javax.inject.Inject

@HiltViewModel
class TempViewModel @Inject constructor(private val useCase: TempUseCase): ViewModel() {

    fun getTempModel() : TempModel{
        return useCase.getTempModel()
    }
}