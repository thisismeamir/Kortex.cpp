package pseudo.response.objects

import kotlinx.serialization.Serializable

@Serializable
data class Logprobs(
    val content: List<Logprob>,
    val refusal: List<Logprob>,
    val topLogprobs: List<Logprob>
)