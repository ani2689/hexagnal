package com.ani.hexagonal.global.config

import com.ani.hexagonal.global.annotation.service.DomainService
import com.ani.hexagonal.global.annotation.usecase.ReadOnlyUseCase
import com.ani.hexagonal.global.annotation.usecase.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.ani.hexagonal"],
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = [
                DomainService::class,
                UseCase::class,
                ReadOnlyUseCase::class
            ]
        )
    ]
)
class ComponentScanConfig