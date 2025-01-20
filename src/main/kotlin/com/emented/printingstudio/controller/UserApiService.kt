package com.emented.printingstudio.controller

import com.emented.printingstudio.api.UserApiDelegate
import com.emented.printingstudio.dto.StatusResponseDto
import com.emented.printingstudio.dto.StatusResponseDto.Status
import com.emented.printingstudio.dto.UserLoginRequestDto
import com.emented.printingstudio.dto.UserRegisterRequestDto
import com.emented.printingstudio.dto.UserResponseDto
import com.emented.printingstudio.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserApiService(
    private val userService: UserService,
) : UserApiDelegate {

    override fun register(userRegisterRequestDto: UserRegisterRequestDto): ResponseEntity<StatusResponseDto> {
        return try {
            userService.register(userRegisterRequestDto)
            ResponseEntity.ok(
                StatusResponseDto(
                    status = Status.SUCCESS,
                ),
            )
        } catch (exception: IllegalStateException) {
            ResponseEntity(
                StatusResponseDto(
                    status = Status.ERROR,
                    message = exception.message,
                ),
                HttpStatus.BAD_REQUEST,
            )
        } catch (e: Exception) {
            log.error("Error during registration", e)
            ResponseEntity(
                StatusResponseDto(
                    status = Status.ERROR,
                    message = "Registration failed!",
                ),
                HttpStatus.BAD_REQUEST,
            )
        }
    }

    override fun login(userLoginRequestDto: UserLoginRequestDto): ResponseEntity<UserResponseDto> {
        return userService.login(userLoginRequestDto)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    companion object {
        private val log = LoggerFactory.getLogger(UserApiService::class.java)
    }
}
