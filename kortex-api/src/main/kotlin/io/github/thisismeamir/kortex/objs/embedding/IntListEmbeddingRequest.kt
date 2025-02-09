package io.github.thisismeamir.kortex.objs.embedding

import kotlinx.serialization.Serializable

@Serializable
data class IntListEmbeddingRequest(
    override val embeddingFormat: String,
    override val input: List<Int>,
    override val `object`: String
) : CreateEmbeddingRequest