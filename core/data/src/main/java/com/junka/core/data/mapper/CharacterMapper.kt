package com.junka.core.data.mapper

import com.junka.core.data.model.CharacterDto
import com.junka.core.domain.character.Character
import com.junka.core.domain.character.StatusEnum

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