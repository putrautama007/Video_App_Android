package com.example.videoapp.model

import com.google.gson.annotations.SerializedName

data class ChannelModel(

	@field:SerializedName("kind")
	val kind: String,

	@field:SerializedName("pageInfo")
	val pageInfo: PageInfo,

	@field:SerializedName("etag")
	val etag: String,

	@field:SerializedName("items")
	val items: List<ItemsItem>
)

data class Medium(

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("height")
	val height: Int
)

data class Statistics(

	@field:SerializedName("videoCount")
	val videoCount: String,

	@field:SerializedName("subscriberCount")
	val subscriberCount: String,

	@field:SerializedName("viewCount")
	val viewCount: String,

	@field:SerializedName("hiddenSubscriberCount")
	val hiddenSubscriberCount: Boolean
)

data class ItemsItem(

	@field:SerializedName("snippet")
	val snippet: Snippet,

	@field:SerializedName("kind")
	val kind: String,

	@field:SerializedName("etag")
	val etag: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("contentDetails")
	val contentDetails: ContentDetails,

	@field:SerializedName("statistics")
	val statistics: Statistics
)

data class High(

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("height")
	val height: Int
)

data class Snippet(

	@field:SerializedName("customUrl")
	val customUrl: String,

	@field:SerializedName("country")
	val country: String,

	@field:SerializedName("publishedAt")
	val publishedAt: String,

	@field:SerializedName("localized")
	val localized: Localized,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("thumbnails")
	val thumbnails: Thumbnails
)

data class Thumbnails(

	@field:SerializedName("default")
	val jsonMemberDefault: JsonMemberDefault,

	@field:SerializedName("high")
	val high: High,

	@field:SerializedName("medium")
	val medium: Medium
)

data class RelatedPlaylists(

	@field:SerializedName("likes")
	val likes: String,

	@field:SerializedName("uploads")
	val uploads: String
)

data class Localized(

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("title")
	val title: String
)

data class JsonMemberDefault(

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("height")
	val height: Int
)

data class PageInfo(

	@field:SerializedName("totalResults")
	val totalResults: Int,

	@field:SerializedName("resultsPerPage")
	val resultsPerPage: Int
)

data class ContentDetails(

	@field:SerializedName("relatedPlaylists")
	val relatedPlaylists: RelatedPlaylists
)
