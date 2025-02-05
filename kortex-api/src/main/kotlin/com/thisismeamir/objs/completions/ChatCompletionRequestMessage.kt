package com.thisismeamir.objs.completions

import kotlinx.serialization.Serializable

@Serializable
data class ChatCompletionRequestMessage(
    val content: String,
    val role: String,
    val name: String
)