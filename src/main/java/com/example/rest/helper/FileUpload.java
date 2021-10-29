package com.example.rest.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.bind.api.impl.NameConverter.Standard;

@Component
public class FileUpload {
	
	public final String url="E:\\springBoot\\rest\\rest\\src\\main\\resources\\static\\image";
	
	//public final  String url = new ClassPathResource("/rest/src/main/resources/static").getFile().getAbsolutePath().toString();  
	
	public FileUpload() throws IOException {
		
	}
	
	public boolean upload (MultipartFile file) throws IOException
	{
		
		boolean f = false;
		try {
			
//			InputStream is = file.getInputStream();
//			byte data[] = new byte[is.available()];
//			FileOutputStream fos = new FileOutputStream(url+File.separator+file.getOriginalFilename());
//			fos.write(data);
//			fos.close();
		System.out.println(url);
			Files.copy(file.getInputStream(),Paths.get( url+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
	
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}

}
