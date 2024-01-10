/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.records

import com.emented.printingstudio.jooq.tables.User
import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record11
import org.jooq.Row11
import org.jooq.impl.UpdatableRecordImpl
import java.time.OffsetDateTime

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UserRecord() :
    UpdatableRecordImpl<UserRecord>(User.USER),
    Record11<Long?, String?, String?, String?, String?, String?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var username: String?
        set(value) = set(1, value)
        get() = get(1) as String?

    var passwordHash: String?
        set(value) = set(2, value)
        get() = get(2) as String?

    var name: String?
        set(value) = set(3, value)
        get() = get(3) as String?

    var surname: String?
        set(value) = set(4, value)
        get() = get(4) as String?

    var patronymic: String?
        set(value) = set(5, value)
        get() = get(5) as String?

    var phone: String?
        set(value) = set(6, value)
        get() = get(6) as String?

    var email: String?
        set(value) = set(7, value)
        get() = get(7) as String?

    var address: String?
        set(value) = set(8, value)
        get() = get(8) as String?

    var creationTimestamp: OffsetDateTime?
        set(value) = set(9, value)
        get() = get(9) as OffsetDateTime?

    var updateTimestamp: OffsetDateTime?
        set(value) = set(10, value)
        get() = get(10) as OffsetDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row11<Long?, String?, String?, String?, String?, String?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?> =
        super.fieldsRow() as Row11<Long?, String?, String?, String?, String?, String?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?>

    override fun valuesRow(): Row11<Long?, String?, String?, String?, String?, String?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?> =
        super.valuesRow() as Row11<Long?, String?, String?, String?, String?, String?, String?, String?, String?, OffsetDateTime?, OffsetDateTime?>

    override fun field1(): Field<Long?> = User.USER.ID
    override fun field2(): Field<String?> = User.USER.USERNAME
    override fun field3(): Field<String?> = User.USER.PASSWORD_HASH
    override fun field4(): Field<String?> = User.USER.NAME
    override fun field5(): Field<String?> = User.USER.SURNAME
    override fun field6(): Field<String?> = User.USER.PATRONYMIC
    override fun field7(): Field<String?> = User.USER.PHONE
    override fun field8(): Field<String?> = User.USER.EMAIL
    override fun field9(): Field<String?> = User.USER.ADDRESS
    override fun field10(): Field<OffsetDateTime?> = User.USER.CREATION_TIMESTAMP
    override fun field11(): Field<OffsetDateTime?> = User.USER.UPDATE_TIMESTAMP
    override fun component1(): Long? = id
    override fun component2(): String? = username
    override fun component3(): String? = passwordHash
    override fun component4(): String? = name
    override fun component5(): String? = surname
    override fun component6(): String? = patronymic
    override fun component7(): String? = phone
    override fun component8(): String? = email
    override fun component9(): String? = address
    override fun component10(): OffsetDateTime? = creationTimestamp
    override fun component11(): OffsetDateTime? = updateTimestamp
    override fun value1(): Long? = id
    override fun value2(): String? = username
    override fun value3(): String? = passwordHash
    override fun value4(): String? = name
    override fun value5(): String? = surname
    override fun value6(): String? = patronymic
    override fun value7(): String? = phone
    override fun value8(): String? = email
    override fun value9(): String? = address
    override fun value10(): OffsetDateTime? = creationTimestamp
    override fun value11(): OffsetDateTime? = updateTimestamp

    override fun value1(value: Long?): UserRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): UserRecord {
        this.username = value
        return this
    }

    override fun value3(value: String?): UserRecord {
        this.passwordHash = value
        return this
    }

    override fun value4(value: String?): UserRecord {
        this.name = value
        return this
    }

    override fun value5(value: String?): UserRecord {
        this.surname = value
        return this
    }

    override fun value6(value: String?): UserRecord {
        this.patronymic = value
        return this
    }

    override fun value7(value: String?): UserRecord {
        this.phone = value
        return this
    }

    override fun value8(value: String?): UserRecord {
        this.email = value
        return this
    }

    override fun value9(value: String?): UserRecord {
        this.address = value
        return this
    }

    override fun value10(value: OffsetDateTime?): UserRecord {
        this.creationTimestamp = value
        return this
    }

    override fun value11(value: OffsetDateTime?): UserRecord {
        this.updateTimestamp = value
        return this
    }

    override fun values(
        value1: Long?,
        value2: String?,
        value3: String?,
        value4: String?,
        value5: String?,
        value6: String?,
        value7: String?,
        value8: String?,
        value9: String?,
        value10: OffsetDateTime?,
        value11: OffsetDateTime?,
    ): UserRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        this.value9(value9)
        this.value10(value10)
        this.value11(value11)
        return this
    }

    /**
     * Create a detached, initialised UserRecord
     */
    constructor(
        id: Long? = null,
        username: String? = null,
        passwordHash: String? = null,
        name: String? = null,
        surname: String? = null,
        patronymic: String? = null,
        phone: String? = null,
        email: String? = null,
        address: String? = null,
        creationTimestamp: OffsetDateTime? = null,
        updateTimestamp: OffsetDateTime? = null,
    ) : this() {
        this.id = id
        this.username = username
        this.passwordHash = passwordHash
        this.name = name
        this.surname = surname
        this.patronymic = patronymic
        this.phone = phone
        this.email = email
        this.address = address
        this.creationTimestamp = creationTimestamp
        this.updateTimestamp = updateTimestamp
    }
}