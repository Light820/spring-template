package com.organisation.projectname

import org.springframework.data.domain.PageRequest

internal fun PageInfo.toPage(): PageRequest =
    PageRequest.of(
        page,
        size,
    )
