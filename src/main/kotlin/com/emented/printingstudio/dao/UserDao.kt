package com.emented.printingstudio.dao

import com.emented.printingstudio.jooq.tables.references.USER
import com.emented.printingstudio.model.User
import org.jooq.DSLContext
import org.jooq.Record
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class UserDao(
    private val dslContext: DSLContext,
) {

    fun create(user: User): User? {
        val now = OffsetDateTime.now()
        return dslContext.insertInto(USER)
            .set(USER.USERNAME, user.username)
            .set(USER.PASSWORD_HASH, user.passwordHash)
            .set(USER.NAME, user.name)
            .set(USER.SURNAME, user.surname)
            .set(USER.PATRONYMIC, user.patronymic)
            .set(USER.PHONE, user.phone)
            .set(USER.EMAIL, user.email)
            .set(USER.ADDRESS, user.address)
            .set(USER.CREATION_TIMESTAMP, now)
            .set(USER.UPDATE_TIMESTAMP, now)
            .onConflictDoNothing()
            .returning(userFields)
            .fetchOne(UserDao::mapUser)
    }

    fun getByUsernameAndPasswordHash(username: String, passwordHash: String): User? {
        return dslContext.select(userFields).from(USER)
            .where(USER.USERNAME.eq(username).and(USER.PASSWORD_HASH.eq(passwordHash)))
            .fetchOne(UserDao::mapUser)
    }

    companion object {
        val userFields = setOf(
            USER.ID,
            USER.USERNAME,
            USER.PASSWORD_HASH,
            USER.NAME,
            USER.SURNAME,
            USER.PATRONYMIC,
            USER.PHONE,
            USER.EMAIL,
            USER.ADDRESS,
            USER.CREATION_TIMESTAMP,
            USER.UPDATE_TIMESTAMP,
        )

        fun mapUser(record: Record): User {
            return User(
                id = record.get(USER.ID)!!,
                username = record.get(USER.USERNAME)!!,
                passwordHash = record.get(USER.PASSWORD_HASH)!!,
                name = record.get(USER.NAME)!!,
                surname = record.get(USER.SURNAME)!!,
                patronymic = record.get(USER.PATRONYMIC),
                phone = record.get(USER.PHONE)!!,
                email = record.get(USER.EMAIL)!!,
                address = record.get(USER.ADDRESS)!!,
                creationTimestamp = record.get(USER.CREATION_TIMESTAMP)!!,
                updateTimestamp = record.get(USER.UPDATE_TIMESTAMP)!!,
            )
        }
    }
}
