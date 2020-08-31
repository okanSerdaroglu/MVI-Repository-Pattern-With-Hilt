package com.okan.mvi_repository_pattern_with_hilt.repository

import com.okan.mvi_repository_pattern_with_hilt.model.Blog
import com.okan.mvi_repository_pattern_with_hilt.retrofit.BlogRetrofit
import com.okan.mvi_repository_pattern_with_hilt.retrofit.NetworkMapper
import com.okan.mvi_repository_pattern_with_hilt.room.BlogDao
import com.okan.mvi_repository_pattern_with_hilt.room.CacheMapper
import com.okan.mvi_repository_pattern_with_hilt.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000) // delay is just seeing the progress
        try {
            // retrieve from network
            val networkBlogList = blogRetrofit.get()
            val blogList = networkMapper.mapFromEntityList(networkBlogList)

            // send to cache
            for (blog in blogList) {
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }

            // read from the cache
            val cachedBlogList = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogList)))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

}