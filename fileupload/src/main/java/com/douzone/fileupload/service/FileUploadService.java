package com.douzone.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static final String SAVE_PATH = "/mysite-upload";
	private static final String URL = "/images";

	public String restore(MultipartFile multipartFile) {
		String url;
		try {
			if (multipartFile.isEmpty()) {
				return url = "";
			}

			String originFilename = multipartFile.getOriginalFilename();

			int lastIndex = originFilename.lastIndexOf('.');
			String extName = originFilename.substring(lastIndex + 1);

			String saveFilename = generateSaveFilename(extName);
			long fileSize = multipartFile.getSize();

			System.out.println(originFilename + " : " + fileSize + " : " + saveFilename);

			byte[] fileData = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(fileData);
			os.close();
			url = URL + "/" + saveFilename;

			return url;

		} catch (IOException e) {
			throw new RuntimeException("file upload error : " + e);
		}

	}

	private String generateSaveFilename(String extName) {
		String filename = "";

		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(calendar.YEAR);
		filename += calendar.get(calendar.MONTH);
		filename += calendar.get(calendar.DATE);
		filename += calendar.get(calendar.HOUR);
		filename += calendar.get(calendar.MINUTE);
		filename += calendar.get(calendar.SECOND);
		filename += calendar.get(calendar.MILLISECOND);
		filename += ("." + extName);

		return filename;
	}

}
