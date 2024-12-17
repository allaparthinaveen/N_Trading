package com.nav.algo.utils;

import com.nav.algo.dto.HistoricalData;
import com.nav.algo.strategy.UpAndDownStrategy;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    public List<HistoricalData> getData(final String filePath) throws IOException {
        List<HistoricalData> assertData = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
             Sheet sheet = workbook.getSheetAt(0) ;
             for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++){
                 Row row = sheet.getRow(i);
                 if (row != null && row.getCell(0).getCellType() != CellType.BLANK){
                     HistoricalData data = new HistoricalData();
                     data.setDate(row.getCell(0).getDateCellValue());
                     data.setOpen(row.getCell(1).getNumericCellValue());
                     data.setHigh(row.getCell(2).getNumericCellValue());
                     data.setLow(row.getCell(3).getNumericCellValue());
                     data.setClose(row.getCell(4).getNumericCellValue());
                     data.setAdjClose(row.getCell(5).getNumericCellValue());
                     assertData.add(data);
                 }
             }
        } catch (IOException e){
            logger.error("Unexpected exception occur while Read/Converting historical data {} ", e.getMessage());
            throw e;
        }
        return assertData;
    }
}
