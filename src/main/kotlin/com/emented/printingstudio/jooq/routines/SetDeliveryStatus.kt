/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.routines

import com.emented.printingstudio.jooq.Public
import org.jooq.Parameter
import org.jooq.impl.AbstractRoutine
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class SetDeliveryStatus : AbstractRoutine<Void>("set_delivery_status", Public.PUBLIC) {
    companion object {

        /**
         * The parameter <code>public.set_delivery_status.p_delivery_id</code>.
         */
        val P_DELIVERY_ID: Parameter<Long?> =
            Internal.createParameter("p_delivery_id", SQLDataType.BIGINT, false, false)

        /**
         * The parameter <code>public.set_delivery_status.p_status</code>.
         */
        val P_STATUS: Parameter<String?> = Internal.createParameter("p_status", SQLDataType.VARCHAR, false, false)
    }

    init {
        addInParameter(P_DELIVERY_ID)
        addInParameter(P_STATUS)
    }

    /**
     * Set the <code>p_delivery_id</code> parameter IN value to the routine
     */
    fun setPDeliveryId(value: Long?) = setValue(P_DELIVERY_ID, value)

    /**
     * Set the <code>p_status</code> parameter IN value to the routine
     */
    fun setPStatus(value: String?) = setValue(P_STATUS, value)
}