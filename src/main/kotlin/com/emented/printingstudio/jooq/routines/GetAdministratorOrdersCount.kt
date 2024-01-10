/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.routines

import com.emented.printingstudio.jooq.Public
import org.jooq.Field
import org.jooq.Parameter
import org.jooq.impl.AbstractRoutine
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class GetAdministratorOrdersCount :
    AbstractRoutine<Long>("get_administrator_orders_count", Public.PUBLIC, SQLDataType.BIGINT) {
    companion object {

        /**
         * The parameter <code>public.get_administrator_orders_count.RETURN_VALUE</code>.
         */
        val RETURN_VALUE: Parameter<Long?> = Internal.createParameter("RETURN_VALUE", SQLDataType.BIGINT, false, false)

        /**
         * The parameter <code>public.get_administrator_orders_count.p_administrator_id</code>.
         */
        val P_ADMINISTRATOR_ID: Parameter<Long?> =
            Internal.createParameter("p_administrator_id", SQLDataType.BIGINT, false, false)
    }

    init {
        returnParameter = RETURN_VALUE
        addInParameter(P_ADMINISTRATOR_ID)
    }

    /**
     * Set the <code>p_administrator_id</code> parameter IN value to the routine
     */
    fun setPAdministratorId(value: Long?) = setValue(P_ADMINISTRATOR_ID, value)

    /**
     * Set the <code>p_administrator_id</code> parameter to the function to be used with a {@link org.jooq.Select} statement
     */
    fun setPAdministratorId(field: Field<Long?>) {
        setField(P_ADMINISTRATOR_ID, field)
    }
}