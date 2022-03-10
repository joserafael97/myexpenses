package br.com.jrafael.myexpenses.common.extension

import br.com.jrafael.myexpenses.controller.dto.SpentDto
import br.com.jrafael.myexpenses.domain.models.Spent

fun Spent.toDto() = SpentDto(
    id = id,
    name = name,
    description = description
)

fun SpentDto.toEntity() = Spent(
    id = id,
    name = name,
    description = description
)