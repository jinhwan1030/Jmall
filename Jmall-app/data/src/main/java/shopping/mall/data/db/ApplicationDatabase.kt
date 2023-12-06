package shopping.mall.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import shopping.mall.data.db.dao.BasketDao
import shopping.mall.data.db.dao.LikeDao
import shopping.mall.data.db.dao.PurchaseDao
import shopping.mall.data.db.entity.BasketProductEntity
import shopping.mall.data.db.entity.LikeProductEntity
import shopping.mall.data.db.entity.PurchaseProductEntity

@Database(
    entities = [
        PurchaseProductEntity::class,
        LikeProductEntity::class,
        BasketProductEntity::class,
    ],
    version = 1
)

abstract class ApplicationDatabase : RoomDatabase(){
    companion object{
        const val DB_NAME = "ApplicationDatabase.db"
    }

    abstract fun purchaseDao() : PurchaseDao

    abstract fun likeDao() : LikeDao

    abstract fun basketDao() : BasketDao
}