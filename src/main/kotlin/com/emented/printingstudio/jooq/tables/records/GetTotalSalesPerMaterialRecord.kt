/*
 * This file is generated by jOOQ.
 */
package com.emented.printingstudio.jooq.tables.records

import com.emented.printingstudio.jooq.tables.GetTotalSalesPerMaterial
import org.jooq.Field
import org.jooq.Record2
import org.jooq.Row2
import org.jooq.impl.TableRecordImpl
import java.math.BigDecimal

/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class GetTotalSalesPerMaterialRecord() :
    TableRecordImpl<GetTotalSalesPerMaterialRecord>(GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL),
    Record2<Long?, BigDecimal?> {

    var materialType: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var salesRevenue: BigDecimal?
        set(value) = set(1, value)
        get() = get(1) as BigDecimal?

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row2<Long?, BigDecimal?> = super.fieldsRow() as Row2<Long?, BigDecimal?>
    override fun valuesRow(): Row2<Long?, BigDecimal?> = super.valuesRow() as Row2<Long?, BigDecimal?>
    override fun field1(): Field<Long?> = GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL.MATERIAL_TYPE
    override fun field2(): Field<BigDecimal?> = GetTotalSalesPerMaterial.GET_TOTAL_SALES_PER_MATERIAL.SALES_REVENUE
    override fun component1(): Long? = materialType
    override fun component2(): BigDecimal? = salesRevenue
    override fun value1(): Long? = materialType
    override fun value2(): BigDecimal? = salesRevenue

    override fun value1(value: Long?): GetTotalSalesPerMaterialRecord {
        this.materialType = value
        return this
    }

    override fun value2(value: BigDecimal?): GetTotalSalesPerMaterialRecord {
        this.salesRevenue = value
        return this
    }

    override fun values(value1: Long?, value2: BigDecimal?): GetTotalSalesPerMaterialRecord {
        this.value1(value1)
        this.value2(value2)
        return this
    }

    /**
     * Create a detached, initialised GetTotalSalesPerMaterialRecord
     */
    constructor(materialType: Long? = null, salesRevenue: BigDecimal? = null) : this() {
        this.materialType = materialType
        this.salesRevenue = salesRevenue
    }
}