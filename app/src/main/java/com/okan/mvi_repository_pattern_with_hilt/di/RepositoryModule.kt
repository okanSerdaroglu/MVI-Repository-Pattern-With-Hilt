package com.okan.mvi_repository_pattern_with_hilt.di

import com.okan.mvi_repository_pattern_with_hilt.repository.MainRepository
import com.okan.mvi_repository_pattern_with_hilt.retrofit.BlogRetrofit
import com.okan.mvi_repository_pattern_with_hilt.retrofit.NetworkMapper
import com.okan.mvi_repository_pattern_with_hilt.room.BlogDao
import com.okan.mvi_repository_pattern_with_hilt.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(
            blogDao = blogDao,
            blogRetrofit = retrofit,
            cacheMapper = cacheMapper,
            networkMapper = networkMapper
        )
    }

}