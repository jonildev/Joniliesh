package me.jonildev.client.errors

class CommandError(message: String, cause: Throwable) : Error(message, cause)