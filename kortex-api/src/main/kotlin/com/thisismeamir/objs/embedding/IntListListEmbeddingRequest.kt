package com.thisismeamir.objs.embedding

import kotlinx.serialization.Serializable

@Serializable
data class IntListListEmbeddingRequest(
    override val embeddingFormat: String,
    override val input: List<List<Int>>,
    override val `object`: String
) : CreateEmbeddingRequest