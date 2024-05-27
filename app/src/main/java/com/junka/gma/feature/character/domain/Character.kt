package com.junka.gma.feature.character.domain

data class Character(
    val name : String,
    val id : Int,
    val status : StatusEnum,
    val species : String,
    val type : String,
    val origin : String,
    val lastLocation : String,
    val image : String,
    val episodes : List<String>
){
    val episodesCount = episodes.count()
}