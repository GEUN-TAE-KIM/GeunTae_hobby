package org.cream.geuntae_hobby.repository.productdetail

import org.cream.geuntae_hobby.model.Product
import javax.inject.Inject
import javax.inject.Singleton

class ProductDetailRepository @Inject constructor(
    private val remoteDataSource: ProductDetailRemoteDataSource
) : ProductDetailRepositoryIn {
    override suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}