package com.emented.printingstudio.service.impl

import com.emented.printingstudio.dao.AdministratorDao
import com.emented.printingstudio.dao.CustomerDao
import com.emented.printingstudio.dao.UserDao
import com.emented.printingstudio.dto.BusinessInfoRegisterRequestDto
import com.emented.printingstudio.dto.UserLoginRequestDto
import com.emented.printingstudio.dto.UserRegisterRequestDto
import com.emented.printingstudio.dto.UserResponseDto
import com.emented.printingstudio.extensions.toResponse
import com.emented.printingstudio.model.BusinessInfo
import com.emented.printingstudio.model.Customer
import com.emented.printingstudio.model.User
import com.emented.printingstudio.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userDao: UserDao,
    private val customerDao: CustomerDao,
    private val administratorDao: AdministratorDao,
) : UserService {

    @Transactional
    override fun register(userRegisterRequestDto: UserRegisterRequestDto) {
        val user = userRegisterRequestDto.toUserModel()

        val persistedUser = userDao.create(user) ?: throw IllegalStateException("Unable to create user!")
        customerDao.create(userRegisterRequestDto.toCustomerModel(persistedUser))
            ?: throw IllegalStateException("Unable to create customer!")
    }

    override fun login(userLoginRequestDto: UserLoginRequestDto): UserResponseDto? {
        val user = userDao.getByUsernameAndPasswordHash(userLoginRequestDto.username, userLoginRequestDto.password)

        if (user != null) {
            val administrator = administratorDao.getAdministratorByUserId(user.id!!)
            val customer = customerDao.getCustomerByUserId(user.id)

            return user.toResponse(customer?.id, administrator?.id)
        }

        return null
    }
}

private fun UserRegisterRequestDto.toCustomerModel(user: User): Customer {
    return Customer(
        user = user,
        businessInfo = this.businessInfo?.toBusinessInfoModel(),
        socialNetworks = listOf(),
    )
}

private fun UserRegisterRequestDto.toUserModel(): User {
    return User(
        username = this.username,
        passwordHash = this.password,
        name = this.name,
        surname = this.surname,
        patronymic = this.patronymic,
        phone = this.phone,
        email = this.email,
        address = this.address,
    )
}

private fun BusinessInfoRegisterRequestDto.toBusinessInfoModel(): BusinessInfo {
    return BusinessInfo(
        inn = this.inn,
        kpp = this.kpp,
        companyName = this.companyName,
    )
}
