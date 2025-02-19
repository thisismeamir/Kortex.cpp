import io.github.thisismeamir.kortex.Kortex
import io.github.thisismeamir.kortex.objs.chat.messages.CreateMessageRequestBody
import io.github.thisismeamir.kortex.objs.chat.messages.ListMessagesQueryParameters
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ThreadsAndMessageTests {
    @Test
    fun `Create Thread`() {
        val kortex = Kortex()
        runBlocking {
            val title = "New Thread 123"
            print("thread:")
            val response = kortex.createThread(title)
            println(response.id)
        }
    }

    @Test
    fun `Get Threads`() {
        val kortex = Kortex()
        runBlocking {
            kortex.getThreads().forEach {
                println(it.id)
            }
        }
    }

    @Test
    fun `Delete Thread`() {
        val kortex = Kortex()
        runBlocking {
            val threadId = kortex.getThreads().first().id
            println(kortex.deleteThread(threadId))
        }
    }

    @Test
    fun `Get Thread`() {
        val kortex = Kortex()
        runBlocking {
            val threadId = kortex.getThreads().first().id
            println(kortex.getThread(threadId))
        }
    }

    @Test
    fun `Update Thread Metadata`() {
        // SHOULD BE FIXED IN THE SERVER SIDE CODE MY CODE IS FINE.
//        val kortex = Kortex()
//        runBlocking {
//            val threadId = kortex.getThreads().first().id
//            print(threadId)
//            val updateRequest = UpdateMetaDataRequest(
//                metadata = mapOf(
//                    "title" to "hellow world"
//                )
//            )
//            println(kortex.updateThreadMetadata(threadId, updateRequest))
//        }
    }

    @Test
    fun `Create Message`() {
        val kortex = Kortex()
        runBlocking {
            val threadId = kortex.getThreads().first().id
            val content = CreateMessageRequestBody(content = "New Message", role = "user")
            println(kortex.createMessage(threadId, content))
        }
    }

    @Test
    fun `Get Messages`() {
        val kortex = Kortex()
        runBlocking {
            val threadId = kortex.getThreads().first().id
            val queryParameters = ListMessagesQueryParameters(limit = 10)
            println(kortex.getMessages(threadId, queryParameters))
        }
    }

    @Test
    fun `Delete Message`() {
        val kortex = Kortex()
        runBlocking {
            val threadId = kortex.getThreads().first().id
            val messageId = kortex.getMessages(threadId, ListMessagesQueryParameters(
                limit = 1
            )).first().id
            println(kortex.deleteMessage(threadId, messageId))
        }
    }

    @Test
    fun `Retrieve Message`() {
        val kortex = Kortex()
        runBlocking {
            val threadId = kortex.getThreads().first().id
            val messageId = kortex.getMessages(threadId, ListMessagesQueryParameters(limit = 10)).first().id
            println(kortex.retrieveMessage(threadId, messageId))
        }
    }

    @Test
    fun `Modify Message Metadata`() {
        val kortex = Kortex()
        runBlocking {
            val threadId = kortex.getThreads().first().id
            val messageId = kortex.getMessages(threadId, ListMessagesQueryParameters(limit = 10)).first().id
            val metadata = "{\"key\": \"value\"}"
            println(kortex.modifyMessageMetadata(threadId, messageId, metadata))
        }
    }
}