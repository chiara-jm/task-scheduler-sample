package chiarajm.android.common

sealed class Result<out R> {

    class Err(val error: Exception) : Result<Nothing>()

    class Ok<out R>(val result: R) : Result<R>()
}

sealed class EmptyResult {

    class Err(val error: Exception) : EmptyResult()

    object Ok : EmptyResult()
}