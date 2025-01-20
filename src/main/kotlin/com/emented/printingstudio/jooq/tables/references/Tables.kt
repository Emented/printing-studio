/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.references


import com.emented.printingstudio.jooq.tables.Administrator
import com.emented.printingstudio.jooq.tables.AvailabilityStatus
import com.emented.printingstudio.jooq.tables.BusinessInfo
import com.emented.printingstudio.jooq.tables.Car
import com.emented.printingstudio.jooq.tables.Client
import com.emented.printingstudio.jooq.tables.Customer
import com.emented.printingstudio.jooq.tables.CustomerSocialNetwork
import com.emented.printingstudio.jooq.tables.Delivery
import com.emented.printingstudio.jooq.tables.DeliveryStatus
import com.emented.printingstudio.jooq.tables.DeliveryType
import com.emented.printingstudio.jooq.tables.Document
import com.emented.printingstudio.jooq.tables.DocumentType
import com.emented.printingstudio.jooq.tables.FilamentType
import com.emented.printingstudio.jooq.tables.GetTotalOrdersPerSettings
import com.emented.printingstudio.jooq.tables.GetTotalSalesPerMaterial
import com.emented.printingstudio.jooq.tables.Material
import com.emented.printingstudio.jooq.tables.Order
import com.emented.printingstudio.jooq.tables.OrderStatus
import com.emented.printingstudio.jooq.tables.Payment
import com.emented.printingstudio.jooq.tables.PaymentStatus
import com.emented.printingstudio.jooq.tables.PaymentType
import com.emented.printingstudio.jooq.tables.PrintSetting
import com.emented.printingstudio.jooq.tables.SocialNetwork
import com.emented.printingstudio.jooq.tables.User
import com.emented.printingstudio.jooq.tables.records.GetTotalOrdersPerSettingsRecord
import com.emented.printingstudio.jooq.tables.records.GetTotalSalesPerMaterialRecord

import org.jooq.Configuration
import org.jooq.Result



/**
 * The table <code>public.administrator</code>.
 */
val ADMINISTRATOR: Administrator = Administrator.ADMINISTRATOR

/**
 * The table <code>public.availability_status</code>.
 */
val AVAILABILITY_STATUS: AvailabilityStatus = AvailabilityStatus.AVAILABILITY_STATUS

/**
 * The table <code>public.business_info</code>.
 */
val BUSINESS_INFO: BusinessInfo = BusinessInfo.BUSINESS_INFO

/**
 * The table <code>public.car</code>.
 */
val CAR: Car = Car.CAR

/**
 * The table <code>public.client</code>.
 */
val CLIENT: Client = Client.CLIENT

/**
 * The table <code>public.customer</code>.
 */
val CUSTOMER: Customer = Customer.CUSTOMER

/**
 * The table <code>public.customer_social_network</code>.
 */
val CUSTOMER_SOCIAL_NETWORK: CustomerSocialNetwork = CustomerSocialNetwork.CUSTOMER_SOCIAL_NETWORK

/**
 * The table <code>public.delivery</code>.
 */
val DELIVERY: Delivery = Delivery.DELIVERY

/**
 * The table <code>public.delivery_status</code>.
 */
val DELIVERY_STATUS: DeliveryStatus = DeliveryStatus.DELIVERY_STATUS

/**
 * The table <code>public.delivery_type</code>.
 */
val DELIVERY_TYPE: DeliveryType = DeliveryType.DELIVERY_TYPE

/**
 * The table <code>public.document</code>.
 */
val DOCUMENT: Document = Document.DOCUMENT

/**
 * The table <code>public.document_type</code>.
 */
val DOCUMENT_TYPE: DocumentType = DocumentType.DOCUMENT_TYPE

/**
 * The table <code>public.filament_type</code>.
 */
val FILAMENT_TYPE: FilamentType = FilamentType.FILAMENT_TYPE

/**
 * The table <code>public.get_total_orders_per_settings</code>.
 */
val GET_TOTAL_ORDERS_PER_SETTINGS: GetTotalOrdersPerSettings = GetTotalOrdersPerSettings.GET_TOTAL_ORDERS_PER_SETTINGS

/**
 * Call <code>public.get_total_orders_per_settings</code>.
 */
fun GET_TOTAL_ORDERS_PER_SETTINGS(
      configuration: Configuration
): Result<GetTotalOrdersPerSettingsRecord> = configuration.dsl().selectFrom(com.emented.printingstudio.jooq.tables.GetTotalOrdersPerSettings.GET_TOTAL_ORDERS_PER_SETTINGS.call(
)).fetch()

/**
 * Get <code>public.get_total_orders_per_settings</code> as a table.
 */
fun GET_TOTAL_ORDERS_PER_SETTINGS(): GetTotalOrdersPerSettings = com.emented.printingstudio.jooq.tables.GetTotalOrdersPerSettings.GET_TOTAL_ORDERS_PER_SETTINGS.call(
)

/**
 * The table <code>public.get_total_sales_per_material</code>.
 */
val GET_TOTAL_SALES_PER_MATERIAL: GetTotalSalesPerMaterial = GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL

/**
 * Call <code>public.get_total_sales_per_material</code>.
 */
fun GET_TOTAL_SALES_PER_MATERIAL(
      configuration: Configuration
): Result<GetTotalSalesPerMaterialRecord> = configuration.dsl().selectFrom(com.emented.printingstudio.jooq.tables.GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL.call(
)).fetch()

/**
 * Get <code>public.get_total_sales_per_material</code> as a table.
 */
fun GET_TOTAL_SALES_PER_MATERIAL(): GetTotalSalesPerMaterial = com.emented.printingstudio.jooq.tables.GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL.call(
)

/**
 * The table <code>public.material</code>.
 */
val MATERIAL: Material = Material.MATERIAL

/**
 * The table <code>public.order</code>.
 */
val ORDER: Order = Order.ORDER

/**
 * The table <code>public.order_status</code>.
 */
val ORDER_STATUS: OrderStatus = OrderStatus.ORDER_STATUS

/**
 * The table <code>public.payment</code>.
 */
val PAYMENT: Payment = Payment.PAYMENT

/**
 * The table <code>public.payment_status</code>.
 */
val PAYMENT_STATUS: PaymentStatus = PaymentStatus.PAYMENT_STATUS

/**
 * The table <code>public.payment_type</code>.
 */
val PAYMENT_TYPE: PaymentType = PaymentType.PAYMENT_TYPE

/**
 * The table <code>public.print_setting</code>.
 */
val PRINT_SETTING: PrintSetting = PrintSetting.PRINT_SETTING

/**
 * The table <code>public.social_network</code>.
 */
val SOCIAL_NETWORK: SocialNetwork = SocialNetwork.SOCIAL_NETWORK

/**
 * The table <code>public.user</code>.
 */
val USER: User = User.USER
