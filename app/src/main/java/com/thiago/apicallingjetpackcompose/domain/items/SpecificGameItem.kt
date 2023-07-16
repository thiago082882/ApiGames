package com.thiago.apicallingjetpackcompose.domain.items

import com.thiago.apicallingjetpackcompose.data.models.SpecificGameModel

data class SpecificGameItem(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val description: String
)
fun SpecificGameModel.toSpecificGameItem() = SpecificGameItem(id, title, thumbnail, description)