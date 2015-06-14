package com.digitanomad.gridtest.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserExcelService {

	public boolean uploadUserExcel(MultipartFile file);
}
