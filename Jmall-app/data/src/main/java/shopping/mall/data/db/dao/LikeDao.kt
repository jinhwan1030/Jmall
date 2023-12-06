package shopping.mall.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import shopping.mall.data.db.entity.BasketProductEntity
import shopping.mall.data.db.entity.LikeProductEntity

@Dao
interface LikeDao {

    @Query("SELECT * FROM like")
    suspend fun getAll() : List<LikeProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : LikeProductEntity)

    @Query("DELETE FROM like WHERE productId=:id")
    suspend fun delete(id: String)
}