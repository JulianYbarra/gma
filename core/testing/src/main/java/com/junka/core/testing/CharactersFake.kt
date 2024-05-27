package com.junka.core.testing

import com.junka.core.domain.character.Character
import com.junka.core.domain.character.StatusEnum


val fakeCharacters = listOf<Character>(
    Character(
        id = 1,
        name = "Ricky Sanchez",
        status = StatusEnum.ALIVE,
        species = "Human",
        type = "-",
        origin = "Earth",
        lastLocation = "Earth",
        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        episodes = emptyList()
    ),
    Character(
        id = 2,
        name = "Morty Smith",
        status = StatusEnum.ALIVE,
        species = "Human",
        type = "-",
        origin = "Unknown",
        lastLocation = "Citadel of Ricks",
        image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        episodes = emptyList()
    ),
    Character(
        id = 3,
        name = "Summer Smith",
        status = StatusEnum.ALIVE,
        species = "Human",
        type = "-",
        origin = "Earth (Replacement Dimension)",
        lastLocation = "Earth (Replacement Dimension)",
        image = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
        episodes = emptyList()
    ),
    Character(
        id = 4,
        name = "Beth Smith",
        status = StatusEnum.ALIVE,
        species = "Human",
        type = "-",
        origin = "Earth (Replacement Dimension)",
        lastLocation = "Earth (Replacement Dimension)",
        image = "https://rickandmortyapi.com/api/character/avatar/4.jpeg",
        episodes = emptyList()
    ),
    Character(
        id = 5,
        name = "Jerry Smith",
        status = StatusEnum.ALIVE,
        species = "Human",
        type = "-",
        origin = "Earth (Replacement Dimension)",
        lastLocation = "Earth (Replacement Dimension)",
        image = "https://rickandmortyapi.com/api/character/avatar/5.jpeg",
        episodes = emptyList()
    )
)