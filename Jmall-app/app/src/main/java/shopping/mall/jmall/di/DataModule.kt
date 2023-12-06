package shopping.mall.jmall.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import shopping.mall.data.repository.MainRepositoryImpl
import shopping.mall.data.repository.TempRepositoryImpl
import shopping.mall.domain.repository.MainRepository
import shopping.mall.domain.repository.TempRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindTempRepository(tempRepositoryImpl: TempRepositoryImpl) : TempRepository

    @Binds
    @Singleton
    fun bindMainRepository(mainRepositoryImpl: MainRepositoryImpl) : MainRepository
}