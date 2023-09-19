package com.ani.hexagonal.global.annotation.usecase

import org.springframework.transaction.annotation.Transactional


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Transactional
annotation class UseCase()
