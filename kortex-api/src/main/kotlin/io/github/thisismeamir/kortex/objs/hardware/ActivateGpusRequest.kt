package io.github.thisismeamir.kortex.objs.hardware

import kotlinx.serialization.Serializable

@Serializable
data class ActivateGpusRequest (
    val gpus: List<Int>
)

