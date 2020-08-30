package com.okan.mvi_repository_pattern_with_hilt.room

import com.okan.mvi_repository_pattern_with_hilt.model.Blog
import com.okan.mvi_repository_pattern_with_hilt.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<BlogCacheEntity, Blog> {

    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogCacheEntity>): List<Blog> {
        return entities.map { blogCacheEntity ->
            mapFromEntity(blogCacheEntity)
        }
    }

}