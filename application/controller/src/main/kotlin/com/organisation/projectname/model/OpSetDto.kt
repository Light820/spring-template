package com.organisation.projectname.model

import com.organisation.projectname.Card
import com.organisation.projectname.OpSet

data class OpSetDto(
    val setInfo: OpSet,
    val cards: List<Card>,
)
