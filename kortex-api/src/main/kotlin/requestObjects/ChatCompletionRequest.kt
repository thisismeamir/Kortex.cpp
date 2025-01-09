package requestObjects

import kotlinx.serialization.Serializable
import pseudo.request.objects.Audio
import pseudo.request.objects.ResponseFormat
import pseudo.request.objects.StreamOption
import pseudo.request.objects.message.Message
import pseudo.request.objects.tool.Tool
import pseudo.request.objects.tool.ToolChoice

@Serializable
/**
 * Creates a model response for the given conversation.
 * The following parameters are not working for the `TensorRT-LLM` engine,
 * `frequencyPenalty`, `presencePenalty`, `topP`.
 *
 * @param audio Parameters for audio output. Required when audio output is requested.
 * @see Audio
 * @param dynamicTemperatureExponent Dynamic temperature exponent. This parameter is only supported by `llama-cpp` engine.
 * @param dynamicTemperatureRange Dynamic temperature range. This parameter is only supported by `llama-cpp` engine.
 * @param frequencyPenalty Modifies the likelihood of the model repeating the same words or phrases within a single output.
 * @param ignoreEndOfSequence Ignores the end-of-sequence token (true or false). This parameter only supported by `llama-cpp` engine.
 * @param logitBias Modify the likelihood of specified tokens appearing in the completion.
 * Accepts a JSON object that maps tokens (specified by their token ID in the
 * tokenizer) to an associated bias value from -100 to 100. Mathematically,
 * the bias is added to the logits generated by the model prior to sampling.
 * The exact effect will vary per model, but values between -1 and 1 should
 * decrease or increase likelihood of selection; values like -100 or 100
 * should result in a ban or exclusive selection of the relevant token.
 * @param logProbabilities Whether to return log probabilities of the output tokens or not.
 * If true, returns the log probabilities of each output token returned in the content of message.
 * @param maxCompletionTokens Sets the upper limit on the number of tokens the model can generate in a single output.
 * @param maxTokens Sets the upper limit on the number of tokens the model can generate in a single output. This value is now deprecated in favor of maxCompletionTokens.
 * @param messages Array of chat messages to be used for generating the chat completion.
 * @see Message
 * @param metadata Developer-defined tags and values used for filtering completions in the dashboard.
 * @param minimumKeptTokens Minimum number of tokens to keep. This parameter only supported by llama-cpp engine.
 * @param minimumProbabilityThreshold Minimum probability threshold for token sampling. This parameter only supported by llama-cpp engine.
 * @param mirostatSampling Whether to use Mirostat sampling or not. This parameter only supported by llama-cpp engine.
 * @param mirostatETA Learning rate for Mirostat sampling. This parameter only supported by llama-cpp engine.
 * @param mirostatTau Target entropy for Mirostat sampling. This parameter only supported by llama-cpp engine.
 * @param modalities Specifies the modalities (types of input) supported by the model. Currently, cortex only support text modalities.
 * @param model The unique identifier of the model.
 * @param numberOfChoices How many chat completion choices to generate for each input message.
 * Note that you will be charged based on the number of generated tokens across all the choices.
 * @param numberOfProbabilities Number of probabilities to return. This parameter only supported by llama-cpp engine.
 * @param parallelToolCalls Whether to enable parallel function calling during tool use. Cortex support parallel tool calls by default.
 * @param penalizerNewLine Penalizes newline tokens (true or false). This parameter only supported by llama-cpp engine.
 * @param presencePenalty Modifies the likelihood of the model including new tokens that are the same as tokens in the input.
 * @param repeatLastN Number of previous token to penalize for repeating. This parameter is only supported by llama-cpp engine.
 * @param repeatPenalty Penalty for repeating tokens. This parameter only supported by llama-cpp engine.
 * @param responseFormat Format of the response. The default value is TEXT.
 * @see ResponseFormat
 * @param seed Seed for random number generation. This parameter only supported by llama-cpp engine.
 * @param serviceTier Specifies the latency tier to use for processing the request.
 * This parameter is relevant for customers subscribed to the scale tier service:
 * If set to 'auto', and the Project is Scale tier enabled, the system will utilize scale tier credits until they are exhausted.
 * If set to 'auto', and the Project is not Scale tier enabled, the request will be processed using the default service tier with a lower uptime SLA and no latency guarentee.
 * If set to 'default', the request will be processed using the default service tier with a lower uptime SLA and no latency guarentee. When not set, the default behavior is 'auto'. When this parameter is set, the response body will include the service_tier utilized.
 * We are actively working on this feature to bring cortex as fully OpenAI compatible platform.
 * Planning and roadmap for this feature can be found here.
 * @param stop Defines specific tokens or phrases that signal the model to stop producing further output.
 * @param store Whether to store the output of this chat completion request for use in our model distillation or evals products.
 * @param stream Determines the format for output generation.
 * If set true, the output is generated continuously, allowing for real-time streaming of responses.
 * If set false, the output is delivered in a single JSON file.
 * @param streamOption Options for streaming response. Only set this when you set stream: true.
 * @see StreamOption
 * @param temperature Controls the randomness of the model by scaling the logits before sampling.
 * @param tfsZ The z-score used for Typical token sampling. This parameter only supported by llama-cpp engine.
 * @param toolChoice The tool to use for the completion.
 * @see ToolChoice
 * @param tools List of tools to use for the completion.
 * @param topK The number of highest probability vocabulary tokens to keep for top-k sampling.
 * @param topP The cumulative probability threshold for nucleus sampling. This parameter only supported by llama-cpp engine.
 * @param topLogProbabilities Number of log probabilities to return. This parameter only supported by llama-cpp engine.
 * @param typicalP The probability of sampling a typical token. This parameter only supported by llama-cpp engine.
 * @param user The unique identifier of the user.
 */
data class ChatCompletionRequest(
    val audio: pseudo.request.objects.Audio?,
    val dynamicTemperatureExponent: Double?,
    val dynamicTemperatureRange: Double?,
    val frequencyPenalty: Double?,
    val ignoreEndOfSequence: Boolean?,
    val logitBias: Map<String, Double>?,
    val logProbabilities: Boolean? = false,
    val maxCompletionTokens: Double?,
    val maxTokens: Double? = maxCompletionTokens,
    val messages: List<Message>?,
    val metadata: Map<String, String>?,
    val minimumKeptTokens: Int?,
    val minimumProbabilityThreshold: Double?,
    val mirostatSampling: Boolean?,
    val mirostatETA: Double?,
    val mirostatTau: Double?,
    val modalities: List<String>?,
    val model: String,
    val numberOfChoices: Int = 1,
    val numberOfProbabilities: Int?,
    val parallelToolCalls: Boolean?,
    val penalizerNewLine: Boolean?,
    val presencePenalty: Double? = 0.6,
    val repeatLastN: Int?,
    val repeatPenalty: Double?,
    val responseFormat: ResponseFormat = ResponseFormat.TEXT,
    val seed: Int = 123,
    val serviceTier: String?,
    val stop: List<String>?,
    val store: Boolean,
    val stream: Boolean,
    val streamOption: StreamOption,
    val temperature: Double,
    val tfsZ: Double,
    val toolChoice: ToolChoice,
    val tools: List<Tool>,
    val topK: Int,
    val topLogProbabilities: Int,
    val topP: Double,
    val typicalP: Double,
    val user: String
)


