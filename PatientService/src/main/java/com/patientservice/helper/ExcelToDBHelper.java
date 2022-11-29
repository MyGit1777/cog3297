package com.patientservice.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.patientservice.model.Patient;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelToDBHelper {

	// Check file type
	public static boolean checkFileFormat(MultipartFile file) {

		String contentType = file.getContentType();

		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}

	}

	// Extracting list of Patients from excel sheet

	public static List<Patient> extractListOfPatients(InputStream input) {
		List<Patient> patientsList = new ArrayList<>();

		try {

			XSSFWorkbook workbook = new XSSFWorkbook(input);

			XSSFSheet sheet = workbook.getSheet("P1");

			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();

				int cellId = 0;

				Patient patient = new Patient();
				SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
				while (cells.hasNext()) {
					Cell cell = cells.next();

					switch (cellId) {
					case 0:
						patient.setPatientName(cell.getStringCellValue());
						break;
					case 1:
						patient.setAddress(cell.getStringCellValue());
						break;
					case 2:
						
						Date date = cell.getDateCellValue();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						String strDate = dateFormat.format(date);
						patient.setDOB(strDate);
						break;

					case 3:
						patient.setEmailId(cell.getStringCellValue());
						break;
					case 4:
						String phoneNo = NumberToTextConverter.toText(cell.getNumericCellValue());
						patient.setPhoneNumber(phoneNo);
						break;
					case 5:
						patient.setDrugId((int) cell.getNumericCellValue());
						break;
					case 6:
						patient.setDrugName(cell.getStringCellValue());
						break;
					default:
						break;
					}
					cellId++;

				}

				patientsList.add(patient);
//				workbook.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientsList;

	}

}
