package com.organisation.projectname

sealed interface OpCollectorError {
    data object DatabaseOpCollectorError : OpCollectorError
}
