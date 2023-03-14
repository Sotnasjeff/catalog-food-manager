package com.manager.food.catalog.core.exception

import java.lang.RuntimeException

open class ResourceNotFoundException(message: String): RuntimeException(message)