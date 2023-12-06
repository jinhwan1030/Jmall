package shopping.mall.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import shopping.mall.data.db.converter.BasketConverter
import shopping.mall.domain.model.Category
import shopping.mall.domain.model.Price
import shopping.mall.domain.model.Product
import shopping.mall.domain.model.Shop

@Entity(tableName = "basket")
@TypeConverters(BasketConverter::class)
data class BasketProductEntity(
    @PrimaryKey
    val productId: String,
    val productName: String,
    val imageUrl: String,
    val price: Price,
    val category: Category,
    val shop: Shop,
    val isNew: Boolean,
    val isFreeShipping: Boolean,
    val isLike: Boolean,
)

fun BasketProductEntity.toDomainModel() : Product {
    return Product(
        productId = productId,
        productName = productName,
        imageUrl = imageUrl,
        price = price,
        category = category,
        shop = shop,
        isNew = isNew,
        isFreeShipping = isFreeShipping,
        isLike = isLike
    )
}

