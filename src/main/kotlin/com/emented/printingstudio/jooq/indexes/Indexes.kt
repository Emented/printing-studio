/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.indexes


import com.emented.printingstudio.jooq.tables.Administrator
import com.emented.printingstudio.jooq.tables.BusinessInfo
import com.emented.printingstudio.jooq.tables.Car
import com.emented.printingstudio.jooq.tables.Customer
import com.emented.printingstudio.jooq.tables.Delivery
import com.emented.printingstudio.jooq.tables.Document
import com.emented.printingstudio.jooq.tables.Material
import com.emented.printingstudio.jooq.tables.Order

import org.jooq.Index
import org.jooq.impl.DSL
import org.jooq.impl.Internal



// -------------------------------------------------------------------------
// INDEX definitions
// -------------------------------------------------------------------------

val ADMINISTRATOR_USER_ID_INDEX: Index = Internal.createIndex(DSL.name("administrator_user_id_index"), Administrator.ADMINISTRATOR, arrayOf(Administrator.ADMINISTRATOR.USER_ID), false)
val BUSINESS_INFO_INN_KPP_INDEX: Index = Internal.createIndex(DSL.name("business_info_inn_kpp_index"), BusinessInfo.BUSINESS_INFO, arrayOf(BusinessInfo.BUSINESS_INFO.INN, BusinessInfo.BUSINESS_INFO.KPP), false)
val CLID: Index = Internal.createIndex(DSL.name("clid"), Car.CAR, arrayOf(Car.CAR.CLIENT_ID), false)
val CUSTOMER_USER_ID_INDEX: Index = Internal.createIndex(DSL.name("customer_user_id_index"), Customer.CUSTOMER, arrayOf(Customer.CUSTOMER.USER_ID), false)
val DELIVERY_TYPE_STATUS_INDEX: Index = Internal.createIndex(DSL.name("delivery_type_status_index"), Delivery.DELIVERY, arrayOf(Delivery.DELIVERY.TYPE, Delivery.DELIVERY.STATUS), false)
val DOCUMENT_ORDER_ID_INDEX: Index = Internal.createIndex(DSL.name("document_order_id_index"), Document.DOCUMENT, arrayOf(Document.DOCUMENT.ORDER_ID), false)
val MATERIAL_TYPE_STATUS_INDEX: Index = Internal.createIndex(DSL.name("material_type_status_index"), Material.MATERIAL, arrayOf(Material.MATERIAL.TYPE, Material.MATERIAL.AVAILABILITY_STATUS), false)
val ORDER_ADMINISTRATOR_ID_INDEX: Index = Internal.createIndex(DSL.name("order_administrator_id_index"), Order.ORDER, arrayOf(Order.ORDER.CUSTOMER_ID), false)
val ORDER_CUSTOMER_ID_INDEX: Index = Internal.createIndex(DSL.name("order_customer_id_index"), Order.ORDER, arrayOf(Order.ORDER.CUSTOMER_ID), false)
val ORDER_STATUS_CREATION_DATE_INDEX: Index = Internal.createIndex(DSL.name("order_status_creation_date_index"), Order.ORDER, arrayOf(Order.ORDER.STATUS, Order.ORDER.CREATION_TIMESTAMP), false)
