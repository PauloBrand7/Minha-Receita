package br.com.minhareceita.core

interface NetworkCallback<T> {
    fun onSuccess(response: T)
    fun onError(t: Throwable)
}