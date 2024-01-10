package com.emented.printingstudio.controller

import com.emented.printingstudio.dto.ResponseStatusCode
import com.emented.printingstudio.dto.StatusResponseDto
import com.emented.printingstudio.dto.UserLoginRequestDto
import com.emented.printingstudio.dto.UserRegisterRequestDto
import com.emented.printingstudio.dto.UserResponseDto
import com.emented.printingstudio.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService,
) {
    @PutMapping("/register")
    fun register(@RequestBody userRegisterRequestDto: UserRegisterRequestDto): ResponseEntity<StatusResponseDto> {
        return try {
            userService.register(userRegisterRequestDto)
            ResponseEntity.ok(
                StatusResponseDto(
                    status = ResponseStatusCode.SUCCESS,
                ),
            )
        } catch (exception: IllegalStateException) {
            ResponseEntity(
                StatusResponseDto(
                    status = ResponseStatusCode.ERROR,
                    message = exception.message,
                ),
                HttpStatus.BAD_REQUEST,
            )
        } catch (exception: Exception) {
            ResponseEntity(
                StatusResponseDto(
                    status = ResponseStatusCode.ERROR,
                    message = "Registration failed!",
                ),
                HttpStatus.BAD_REQUEST,
            )
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody userLoginRequestDto: UserLoginRequestDto): ResponseEntity<UserResponseDto> {
        return userService.login(userLoginRequestDto)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}
