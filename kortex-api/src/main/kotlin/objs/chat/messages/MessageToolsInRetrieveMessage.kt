package objs.chat.messages

import kotlinx.serialization.Serializable

@Serializable
data class MessageToolsInRetrieveMessage(
    val type: String
)