package com.junka.gma.feature.character.data.mapper

import com.junka.gma.feature.character.data.model.CharacterDto
import com.junka.gma.feature.character.domain.Character
import com.junka.gma.feature.character.domain.StatusEnum

fun CharacterDto.toCharacter() = Character(
    name = name,
    id = id,
    status = StatusEnum.valueOf(status.uppercase()),
    species = species,
    type = type,
    origin = origin.name,
    lastLocation = location.name,
    image = image,
    episodes = episodes
)