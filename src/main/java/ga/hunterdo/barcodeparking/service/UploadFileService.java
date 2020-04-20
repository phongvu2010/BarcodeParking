package ga.hunterdo.barcodeparking.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {
	// Save Files
	public String saveUploadedFiles(String uploadFilePath, MultipartFile[] files) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (MultipartFile file : files) {
			if (file.isEmpty())
				continue;

			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadFilePath);
			Files.write(path, bytes);

			sb.append(uploadFilePath);
		}

		return sb.toString();
	}
}