package com.digitanomad.gridtest.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.digitanomad.gridtest.dto.UserDto;

public class UserServiceExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// 스프링 컨테이너에 의해 전달된 데이터 모델을 받는다.
		@SuppressWarnings("unchecked")
		List<UserDto> userList = (List<UserDto>) model.get("userList");
		
		// 새로운 엑셀 시트 생성
		HSSFSheet sheet = workbook.createSheet("고객 목록");
		sheet.setDefaultColumnWidth(30);
		
		// 헤더 셀 스타일 생성
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		Font font = workbook.createFont();
		font.setFontName("굴림");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		// 헤더 행 생성
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("이름");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("회사");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("시작일");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("카드번호");
		header.getCell(4).setCellStyle(style);
		
		// 데이터 행 생성
		int rowCount = 1;
		for (UserDto userDto : userList) {
			HSSFRow row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(userDto.getId());
			row.createCell(1).setCellValue(userDto.getName());
			row.createCell(2).setCellValue(userDto.getCompany());
			row.createCell(3).setCellValue(userDto.getStartdate());
			row.createCell(4).setCellValue(userDto.getCardnum());
		}
		
		String excelFileName = "customer_list.xls";
		response.setHeader("Content-Disposition", "attachment; filename=\"" + excelFileName + "\"");
		
	}

}
