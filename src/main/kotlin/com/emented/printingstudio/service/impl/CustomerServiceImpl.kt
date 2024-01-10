package com.emented.printingstudio.service.impl

import com.emented.printingstudio.dao.CustomerDao
import com.emented.printingstudio.dto.CustomerResponseDto
import com.emented.printingstudio.extensions.toResponse
import com.emented.printingstudio.service.CustomerService
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(
    private val customerDao: CustomerDao,
) : CustomerService {
    override fun customerByUserId(userId: Long): CustomerResponseDto? {
        val customer = customerDao.getCustomerByUserId(userId)

        return customer?.toResponse()
    }
}
