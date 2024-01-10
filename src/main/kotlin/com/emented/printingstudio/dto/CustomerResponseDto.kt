package com.emented.printingstudio.dto

data class CustomerResponseDto(
    val id: Long,
    val user: UserResponseDto,
    val businessInfo: BusinessInfoResponseDto?,
    val socialNetworks: List<SocialNetworkResponseDto>,
)
