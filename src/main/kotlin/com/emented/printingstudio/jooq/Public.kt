/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq

import com.emented.printingstudio.jooq.sequences.ADMINISTRATOR_ID_SEQ
import com.emented.printingstudio.jooq.sequences.AVAILABILITY_STATUS_ID_SEQ
import com.emented.printingstudio.jooq.sequences.BUSINESS_INFO_ID_SEQ
import com.emented.printingstudio.jooq.sequences.CUSTOMER_ID_SEQ
import com.emented.printingstudio.jooq.sequences.DELIVERY_ID_SEQ
import com.emented.printingstudio.jooq.sequences.DELIVERY_STATUS_ID_SEQ
import com.emented.printingstudio.jooq.sequences.DELIVERY_TYPE_ID_SEQ
import com.emented.printingstudio.jooq.sequences.DOCUMENT_ID_SEQ
import com.emented.printingstudio.jooq.sequences.DOCUMENT_TYPE_ID_SEQ
import com.emented.printingstudio.jooq.sequences.FILAMENT_TYPE_ID_SEQ
import com.emented.printingstudio.jooq.sequences.MATERIAL_ID_SEQ
import com.emented.printingstudio.jooq.sequences.ORDER_ID_SEQ
import com.emented.printingstudio.jooq.sequences.ORDER_STATUS_ID_SEQ
import com.emented.printingstudio.jooq.sequences.PAYMENT_ID_SEQ
import com.emented.printingstudio.jooq.sequences.PAYMENT_STATUS_ID_SEQ
import com.emented.printingstudio.jooq.sequences.PAYMENT_TYPE_ID_SEQ
import com.emented.printingstudio.jooq.sequences.PRINT_SETTING_ID_SEQ
import com.emented.printingstudio.jooq.sequences.SOCIAL_NETWORK_ID_SEQ
import com.emented.printingstudio.jooq.sequences.USER_ID_SEQ
import com.emented.printingstudio.jooq.tables.Administrator
import com.emented.printingstudio.jooq.tables.AvailabilityStatus
import com.emented.printingstudio.jooq.tables.BusinessInfo
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
import org.jooq.Catalog
import org.jooq.Configuration
import org.jooq.Result
import org.jooq.Sequence
import org.jooq.Table
import org.jooq.impl.SchemaImpl

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Public : SchemaImpl("public", DefaultCatalog.DEFAULT_CATALOG) {
    companion object {

        /**
         * The reference instance of <code>public</code>
         */
        val PUBLIC = Public()
    }

    /**
     * The table <code>public.administrator</code>.
     */
    val ADMINISTRATOR get() = Administrator.ADMINISTRATOR

    /**
     * The table <code>public.availability_status</code>.
     */
    val AVAILABILITY_STATUS get() = AvailabilityStatus.AVAILABILITY_STATUS

    /**
     * The table <code>public.business_info</code>.
     */
    val BUSINESS_INFO get() = BusinessInfo.BUSINESS_INFO

    /**
     * The table <code>public.customer</code>.
     */
    val CUSTOMER get() = Customer.CUSTOMER

    /**
     * The table <code>public.customer_social_network</code>.
     */
    val CUSTOMER_SOCIAL_NETWORK get() = CustomerSocialNetwork.CUSTOMER_SOCIAL_NETWORK

    /**
     * The table <code>public.delivery</code>.
     */
    val DELIVERY get() = Delivery.DELIVERY

    /**
     * The table <code>public.delivery_status</code>.
     */
    val DELIVERY_STATUS get() = DeliveryStatus.DELIVERY_STATUS

    /**
     * The table <code>public.delivery_type</code>.
     */
    val DELIVERY_TYPE get() = DeliveryType.DELIVERY_TYPE

    /**
     * The table <code>public.document</code>.
     */
    val DOCUMENT get() = Document.DOCUMENT

    /**
     * The table <code>public.document_type</code>.
     */
    val DOCUMENT_TYPE get() = DocumentType.DOCUMENT_TYPE

    /**
     * The table <code>public.filament_type</code>.
     */
    val FILAMENT_TYPE get() = FilamentType.FILAMENT_TYPE

    /**
     * The table <code>public.get_total_orders_per_settings</code>.
     */
    val GET_TOTAL_ORDERS_PER_SETTINGS get() = GetTotalOrdersPerSettings.GET_TOTAL_ORDERS_PER_SETTINGS

    /**
     * Call <code>public.get_total_orders_per_settings</code>.
     */
    fun GET_TOTAL_ORDERS_PER_SETTINGS(
        configuration: Configuration,
    ): Result<GetTotalOrdersPerSettingsRecord> = configuration.dsl().selectFrom(
        GetTotalOrdersPerSettings.GET_TOTAL_ORDERS_PER_SETTINGS.call(),
    ).fetch()

    /**
     * Get <code>public.get_total_orders_per_settings</code> as a table.
     */
    fun GET_TOTAL_ORDERS_PER_SETTINGS(): GetTotalOrdersPerSettings =
        GetTotalOrdersPerSettings.GET_TOTAL_ORDERS_PER_SETTINGS.call()

    /**
     * The table <code>public.get_total_sales_per_material</code>.
     */
    val GET_TOTAL_SALES_PER_MATERIAL get() = GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL

    /**
     * Call <code>public.get_total_sales_per_material</code>.
     */
    fun GET_TOTAL_SALES_PER_MATERIAL(
        configuration: Configuration,
    ): Result<GetTotalSalesPerMaterialRecord> = configuration.dsl().selectFrom(
        GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL.call(),
    ).fetch()

    /**
     * Get <code>public.get_total_sales_per_material</code> as a table.
     */
    fun GET_TOTAL_SALES_PER_MATERIAL(): GetTotalSalesPerMaterial =
        GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL.call()

    /**
     * The table <code>public.material</code>.
     */
    val MATERIAL get() = Material.MATERIAL

    /**
     * The table <code>public.order</code>.
     */
    val ORDER get() = Order.ORDER

    /**
     * The table <code>public.order_status</code>.
     */
    val ORDER_STATUS get() = OrderStatus.ORDER_STATUS

    /**
     * The table <code>public.payment</code>.
     */
    val PAYMENT get() = Payment.PAYMENT

    /**
     * The table <code>public.payment_status</code>.
     */
    val PAYMENT_STATUS get() = PaymentStatus.PAYMENT_STATUS

    /**
     * The table <code>public.payment_type</code>.
     */
    val PAYMENT_TYPE get() = PaymentType.PAYMENT_TYPE

    /**
     * The table <code>public.print_setting</code>.
     */
    val PRINT_SETTING get() = PrintSetting.PRINT_SETTING

    /**
     * The table <code>public.social_network</code>.
     */
    val SOCIAL_NETWORK get() = SocialNetwork.SOCIAL_NETWORK

    /**
     * The table <code>public.user</code>.
     */
    val USER get() = User.USER

    override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    override fun getSequences(): List<Sequence<*>> = listOf(
        ADMINISTRATOR_ID_SEQ,
        AVAILABILITY_STATUS_ID_SEQ,
        BUSINESS_INFO_ID_SEQ,
        CUSTOMER_ID_SEQ,
        DELIVERY_ID_SEQ,
        DELIVERY_STATUS_ID_SEQ,
        DELIVERY_TYPE_ID_SEQ,
        DOCUMENT_ID_SEQ,
        DOCUMENT_TYPE_ID_SEQ,
        FILAMENT_TYPE_ID_SEQ,
        MATERIAL_ID_SEQ,
        ORDER_ID_SEQ,
        ORDER_STATUS_ID_SEQ,
        PAYMENT_ID_SEQ,
        PAYMENT_STATUS_ID_SEQ,
        PAYMENT_TYPE_ID_SEQ,
        PRINT_SETTING_ID_SEQ,
        SOCIAL_NETWORK_ID_SEQ,
        USER_ID_SEQ,
    )

    override fun getTables(): List<Table<*>> = listOf(
        Administrator.ADMINISTRATOR,
        AvailabilityStatus.AVAILABILITY_STATUS,
        BusinessInfo.BUSINESS_INFO,
        Customer.CUSTOMER,
        CustomerSocialNetwork.CUSTOMER_SOCIAL_NETWORK,
        Delivery.DELIVERY,
        DeliveryStatus.DELIVERY_STATUS,
        DeliveryType.DELIVERY_TYPE,
        Document.DOCUMENT,
        DocumentType.DOCUMENT_TYPE,
        FilamentType.FILAMENT_TYPE,
        GetTotalOrdersPerSettings.GET_TOTAL_ORDERS_PER_SETTINGS,
        GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL,
        Material.MATERIAL,
        Order.ORDER,
        OrderStatus.ORDER_STATUS,
        Payment.PAYMENT,
        PaymentStatus.PAYMENT_STATUS,
        PaymentType.PAYMENT_TYPE,
        PrintSetting.PRINT_SETTING,
        SocialNetwork.SOCIAL_NETWORK,
        User.USER,
    )
}