package io.github.thisismeamir.kortex.objs.chat.threads

import kotlinx.serialization.Serializable

@Serializable
data class UpdateMetaDataRequest(
    val metadata: Map<String,String>
)