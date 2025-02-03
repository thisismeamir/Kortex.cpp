package com.thisismeamir.objs.chat.messages

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("text")
data class TextMessageContent(
    val text: TextMessageValue,
    val type: String
) : MessageContent()