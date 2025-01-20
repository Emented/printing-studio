/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.routines.references


import com.emented.printingstudio.jooq.routines.AddAdministrator
import com.emented.printingstudio.jooq.routines.AddCustomer
import com.emented.printingstudio.jooq.routines.GetAdministratorInProgressOrdersCount
import com.emented.printingstudio.jooq.routines.GetAdministratorOrdersCount
import com.emented.printingstudio.jooq.routines.GetCustomerFinishedOrdersCount
import com.emented.printingstudio.jooq.routines.GetCustomerFinishedOrdersTotal
import com.emented.printingstudio.jooq.routines.GetCustomerOrdersCount
import com.emented.printingstudio.jooq.routines.GetRecordCount
import com.emented.printingstudio.jooq.routines.SetDeliveryStatus
import com.emented.printingstudio.jooq.routines.SetMaterialAvailabilityStatus
import com.emented.printingstudio.jooq.routines.SetOrderStatus
import com.emented.printingstudio.jooq.routines.SetPaymentStatus
import com.emented.printingstudio.jooq.tables.GetTotalOrdersPerSettings
import com.emented.printingstudio.jooq.tables.GetTotalSalesPerMaterial
import com.emented.printingstudio.jooq.tables.records.GetTotalOrdersPerSettingsRecord
import com.emented.printingstudio.jooq.tables.records.GetTotalSalesPerMaterialRecord

import java.math.BigDecimal

import org.jooq.Configuration
import org.jooq.Field
import org.jooq.Result



/**
 * Call <code>public.add_administrator</code>
 */
fun addAdministrator(
      configuration: Configuration
    , pUsername: String?
    , pPasswordHash: String?
    , pName: String?
    , pSurname: String?
    , pPatronymic: String?
    , pPhone: String?
    , pEmail: String?
): Unit {
    val p = AddAdministrator()
    p.setPUsername(pUsername)
    p.setPPasswordHash(pPasswordHash)
    p.setPName(pName)
    p.setPSurname(pSurname)
    p.setPPatronymic(pPatronymic)
    p.setPPhone(pPhone)
    p.setPEmail(pEmail)

    p.execute(configuration)
}

/**
 * Call <code>public.add_customer</code>
 */
fun addCustomer(
      configuration: Configuration
    , pUsername: String?
    , pPasswordHash: String?
    , pName: String?
    , pSurname: String?
    , pPatronymic: String?
    , pPhone: String?
    , pEmail: String?
): Unit {
    val p = AddCustomer()
    p.setPUsername(pUsername)
    p.setPPasswordHash(pPasswordHash)
    p.setPName(pName)
    p.setPSurname(pSurname)
    p.setPPatronymic(pPatronymic)
    p.setPPhone(pPhone)
    p.setPEmail(pEmail)

    p.execute(configuration)
}

/**
 * Call <code>public.get_administrator_in_progress_orders_count</code>
 */
fun getAdministratorInProgressOrdersCount(
      configuration: Configuration
    , pAdministratorId: Long?
): Long? {
    val f = GetAdministratorInProgressOrdersCount()
    f.setPAdministratorId(pAdministratorId)

    f.execute(configuration)
    return f.returnValue
}

/**
 * Get <code>public.get_administrator_in_progress_orders_count</code> as a
 * field.
 */
fun getAdministratorInProgressOrdersCount(
      pAdministratorId: Long?
): Field<Long?> {
    val f = GetAdministratorInProgressOrdersCount()
    f.setPAdministratorId(pAdministratorId)

    return f.asField()
}

/**
 * Get <code>public.get_administrator_in_progress_orders_count</code> as a
 * field.
 */
fun getAdministratorInProgressOrdersCount(
      pAdministratorId: Field<Long?>
): Field<Long?> {
    val f = GetAdministratorInProgressOrdersCount()
    f.setPAdministratorId(pAdministratorId)

    return f.asField()
}

/**
 * Call <code>public.get_administrator_orders_count</code>
 */
fun getAdministratorOrdersCount(
      configuration: Configuration
    , pAdministratorId: Long?
): Long? {
    val f = GetAdministratorOrdersCount()
    f.setPAdministratorId(pAdministratorId)

    f.execute(configuration)
    return f.returnValue
}

/**
 * Get <code>public.get_administrator_orders_count</code> as a field.
 */
fun getAdministratorOrdersCount(
      pAdministratorId: Long?
): Field<Long?> {
    val f = GetAdministratorOrdersCount()
    f.setPAdministratorId(pAdministratorId)

    return f.asField()
}

/**
 * Get <code>public.get_administrator_orders_count</code> as a field.
 */
fun getAdministratorOrdersCount(
      pAdministratorId: Field<Long?>
): Field<Long?> {
    val f = GetAdministratorOrdersCount()
    f.setPAdministratorId(pAdministratorId)

    return f.asField()
}

/**
 * Call <code>public.get_customer_finished_orders_count</code>
 */
fun getCustomerFinishedOrdersCount(
      configuration: Configuration
    , pCustomerId: Long?
): Long? {
    val f = GetCustomerFinishedOrdersCount()
    f.setPCustomerId(pCustomerId)

    f.execute(configuration)
    return f.returnValue
}

/**
 * Get <code>public.get_customer_finished_orders_count</code> as a field.
 */
fun getCustomerFinishedOrdersCount(
      pCustomerId: Long?
): Field<Long?> {
    val f = GetCustomerFinishedOrdersCount()
    f.setPCustomerId(pCustomerId)

    return f.asField()
}

/**
 * Get <code>public.get_customer_finished_orders_count</code> as a field.
 */
fun getCustomerFinishedOrdersCount(
      pCustomerId: Field<Long?>
): Field<Long?> {
    val f = GetCustomerFinishedOrdersCount()
    f.setPCustomerId(pCustomerId)

    return f.asField()
}

/**
 * Call <code>public.get_customer_finished_orders_total</code>
 */
fun getCustomerFinishedOrdersTotal(
      configuration: Configuration
    , pCustomerId: Long?
): BigDecimal? {
    val f = GetCustomerFinishedOrdersTotal()
    f.setPCustomerId(pCustomerId)

    f.execute(configuration)
    return f.returnValue
}

/**
 * Get <code>public.get_customer_finished_orders_total</code> as a field.
 */
fun getCustomerFinishedOrdersTotal(
      pCustomerId: Long?
): Field<BigDecimal?> {
    val f = GetCustomerFinishedOrdersTotal()
    f.setPCustomerId(pCustomerId)

    return f.asField()
}

/**
 * Get <code>public.get_customer_finished_orders_total</code> as a field.
 */
fun getCustomerFinishedOrdersTotal(
      pCustomerId: Field<Long?>
): Field<BigDecimal?> {
    val f = GetCustomerFinishedOrdersTotal()
    f.setPCustomerId(pCustomerId)

    return f.asField()
}

/**
 * Call <code>public.get_customer_orders_count</code>
 */
fun getCustomerOrdersCount(
      configuration: Configuration
    , pCustomerId: Long?
): Long? {
    val f = GetCustomerOrdersCount()
    f.setPCustomerId(pCustomerId)

    f.execute(configuration)
    return f.returnValue
}

/**
 * Get <code>public.get_customer_orders_count</code> as a field.
 */
fun getCustomerOrdersCount(
      pCustomerId: Long?
): Field<Long?> {
    val f = GetCustomerOrdersCount()
    f.setPCustomerId(pCustomerId)

    return f.asField()
}

/**
 * Get <code>public.get_customer_orders_count</code> as a field.
 */
fun getCustomerOrdersCount(
      pCustomerId: Field<Long?>
): Field<Long?> {
    val f = GetCustomerOrdersCount()
    f.setPCustomerId(pCustomerId)

    return f.asField()
}

/**
 * Call <code>public.get_record_count</code>
 */
fun getRecordCount(
      configuration: Configuration
    , tableName: String?
): Long? {
    val f = GetRecordCount()
    f.setTableName(tableName)

    f.execute(configuration)
    return f.returnValue
}

/**
 * Get <code>public.get_record_count</code> as a field.
 */
fun getRecordCount(
      tableName: String?
): Field<Long?> {
    val f = GetRecordCount()
    f.setTableName(tableName)

    return f.asField()
}

/**
 * Get <code>public.get_record_count</code> as a field.
 */
fun getRecordCount(
      tableName: Field<String?>
): Field<Long?> {
    val f = GetRecordCount()
    f.setTableName(tableName)

    return f.asField()
}

/**
 * Call <code>public.set_delivery_status</code>
 */
fun setDeliveryStatus(
      configuration: Configuration
    , pDeliveryId: Long?
    , pStatus: String?
): Unit {
    val p = SetDeliveryStatus()
    p.setPDeliveryId(pDeliveryId)
    p.setPStatus(pStatus)

    p.execute(configuration)
}

/**
 * Call <code>public.set_material_availability_status</code>
 */
fun setMaterialAvailabilityStatus(
      configuration: Configuration
    , pMaterialId: Long?
    , pAvailabilityStatus: String?
): Unit {
    val p = SetMaterialAvailabilityStatus()
    p.setPMaterialId(pMaterialId)
    p.setPAvailabilityStatus(pAvailabilityStatus)

    p.execute(configuration)
}

/**
 * Call <code>public.set_order_status</code>
 */
fun setOrderStatus(
      configuration: Configuration
    , pOrderId: Long?
    , pStatus: String?
): Unit {
    val p = SetOrderStatus()
    p.setPOrderId(pOrderId)
    p.setPStatus(pStatus)

    p.execute(configuration)
}

/**
 * Call <code>public.set_payment_status</code>
 */
fun setPaymentStatus(
      configuration: Configuration
    , pPaymentId: Long?
    , pStatus: String?
): Unit {
    val p = SetPaymentStatus()
    p.setPPaymentId(pPaymentId)
    p.setPStatus(pStatus)

    p.execute(configuration)
}

/**
 * Call <code>public.get_total_orders_per_settings</code>.
 */
fun getTotalOrdersPerSettings(
      configuration: Configuration
): Result<GetTotalOrdersPerSettingsRecord> = configuration.dsl().selectFrom(com.emented.printingstudio.jooq.tables.GetTotalOrdersPerSettings.GET_TOTAL_ORDERS_PER_SETTINGS.call(
)).fetch()

/**
 * Get <code>public.get_total_orders_per_settings</code> as a table.
 */
fun getTotalOrdersPerSettings(): GetTotalOrdersPerSettings = com.emented.printingstudio.jooq.tables.GetTotalOrdersPerSettings.GET_TOTAL_ORDERS_PER_SETTINGS.call(
)

/**
 * Call <code>public.get_total_sales_per_material</code>.
 */
fun getTotalSalesPerMaterial(
      configuration: Configuration
): Result<GetTotalSalesPerMaterialRecord> = configuration.dsl().selectFrom(com.emented.printingstudio.jooq.tables.GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL.call(
)).fetch()

/**
 * Get <code>public.get_total_sales_per_material</code> as a table.
 */
fun getTotalSalesPerMaterial(): GetTotalSalesPerMaterial = com.emented.printingstudio.jooq.tables.GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL.call(
)
