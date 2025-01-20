package com.emented.printingstudio.controller

import com.emented.printingstudio.api.PingApiDelegate
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class PingApiService : PingApiDelegate {

    override fun ping(): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}