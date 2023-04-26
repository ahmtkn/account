package com.springProject.account.dto

data class CustomerDto(
    val id: String?,
    val nane: String?,
    val surname: String?,
    val account: Set<CustomerAccountDto>
)
