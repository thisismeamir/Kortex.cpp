package io.github.thisismeamir.kortex.objs.completions

import kotlinx.serialization.Serializable

@Serializable
data class ChatCompletionResponseMessageAudio(
    val data: String,
    val expiresAt: Long,
    val id: String,
    val transcript: String
)