package com.example.domain.usecase

import javax.inject.Inject

class TestUseCase @Inject constructor() {
    operator fun invoke(): String {
        return "Domain Hilt Test Complete"
    }
}