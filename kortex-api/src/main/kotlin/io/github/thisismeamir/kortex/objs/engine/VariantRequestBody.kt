package io.github.thisismeamir.kortex.objs.engine

import kotlinx.serialization.Serializable

@Serializable
data class VariantRequestBody(
    val variant: String,
    val version: String
)