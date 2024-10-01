package com.organisation.projectname

import com.organisation.projectname.PageInfo
import org.springframework.data.domain.PageRequest

internal fun PageInfo.toPage(): PageRequest {
    return PageRequest.of(
        page,
        size,
    )
}