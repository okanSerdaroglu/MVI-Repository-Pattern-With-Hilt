package com.okan.mvi_repository_pattern_with_hilt.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogCacheEntity: BlogCacheEntity): Long

    @Query("SELECT * FROM blogs")
    suspend fun get(): List<BlogCacheEntity>

}