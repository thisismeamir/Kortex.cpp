package objs.embedding

interface CreateEmbeddingRequest {
    val embeddingFormat: String
    val input: Any
    val `object`: String
}