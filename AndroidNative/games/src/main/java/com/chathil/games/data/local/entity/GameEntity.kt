package com.chathil.games.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_entity")
data class GameEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val slug: String?,
    val released: String?,
    val tba: Boolean,
    @ColumnInfo(name = "background_image")
    val backgroundImage: String?,
    val rating: Float,
    @ColumnInfo(name = "rating_top")
    val ratingTop: Float,
    val ratings: List<RatingEntity>?,
    @ColumnInfo(name = "ratings_count")
    val ratingsCount: Int,
    @ColumnInfo(name = "review_text_count")
    val reviewTextCount: Int,
    val added: Int,
    val metacritic: Int,
    val playtime: Int,
    @ColumnInfo(name = "suggestion_count")
    val suggestionCount: Int,
    @ColumnInfo(name = "reviews_count")
    val reviewsCount: Int,
    @ColumnInfo(name = "saturated_color")
    val saturatedColor: String?,
    @ColumnInfo(name = "dominant_color")
    val dominantColor: String?,
    val platforms: List<GamePlatformEntity>?,
    @ColumnInfo(name = "parent_platforms")
    val parentPlatforms: List<ParentPlatformEntity>?,
    val genres: List<GenreEntity>?,
    val stores: List<GameStoreEntity>?,
    val clip: String?,
    val tags: List<TagEntity>?,
    @ColumnInfo(name = "short_screenshots")
    val shortScreenshots: List<ShortScreenshotEntity>?
)