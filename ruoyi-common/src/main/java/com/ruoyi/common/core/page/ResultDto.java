package com.ruoyi.common.core.page;


/**
 * ResultDto
 *
 * @author grapecc
 * @since 2025/3/10 12:21
 */
public class ResultDto {
   public TableDataInfo getTableDataInfo() {
      return tableDataInfo;
   }

   public void setTableDataInfo(TableDataInfo tableDataInfo) {
      this.tableDataInfo = tableDataInfo;
   }

   public String getTotal() {
      return total;
   }

   public void setTotal(String total) {
      this.total = total;
   }

   private TableDataInfo  tableDataInfo;
   private String total;
}
