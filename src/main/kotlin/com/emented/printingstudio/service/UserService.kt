package com.emented.printingstudio.service

import com.emented.printingstudio.dto.UserLoginRequestDto
import com.emented.printingstudio.dto.UserRegisterRequestDto
import com.emented.printingstudio.dto.UserResponseDto

interface UserService {

    fun register(userRegisterRequestDto: UserRegisterRequestDto)
    fun login(userLoginRequestDto: UserLoginRequestDto): UserResponseDto?
}
