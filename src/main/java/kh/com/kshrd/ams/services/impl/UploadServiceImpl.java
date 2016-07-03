package kh.com.kshrd.ams.services.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kh.com.kshrd.ams.services.UploadService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

@Service
public class UploadServiceImpl implements UploadService{

	@Override
	public String uploadMultipart(CommonsMultipartFile file, HttpServletRequest request) {
		try {
			String filename = "";
			if (!file.isEmpty()) {
				String savePath = "/opt/resources/images";
				String savePathThumbnails = "/opt/resources/image-thumbnails";
				try {
					filename = file.getOriginalFilename();
					byte[] bytes = file.getBytes();
					UUID uuid = UUID.randomUUID();
					String randomUUIDFileName = uuid.toString();
					String extension = filename.substring(filename.lastIndexOf(".") + 1);
					System.out.println(savePath);

					File pathOriginal = new File(savePath);
					if (!pathOriginal.exists()) {
						pathOriginal.mkdirs();
					}
					File pathThumbnails = new File(savePathThumbnails);
					if (!pathThumbnails.exists()) {
						pathThumbnails.mkdirs();
					}
					filename = randomUUIDFileName + "." + extension;
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File(savePath + File.separator + filename)));
					stream.write(bytes);
					stream.close();

					try {
						Thumbnails.of(savePath + File.separator + filename).forceSize(320, 320)
								.toFiles(pathThumbnails, Rename.PREFIX_HYPHEN_THUMBNAIL);
					} catch (Exception ex) {
						BufferedOutputStream streamFile = new BufferedOutputStream(
								new FileOutputStream(new File(savePath + File.separator + filename)));
						streamFile.write(bytes);
						streamFile.close();
					}

					System.out.println("MESSAGE ==> YOU HAVE BEEN UPLOADED " + savePath + File.separator + filename
							+ " SUCCESSFULLY!");
					return getURLWithContextPath(request) + "image-thumbnails/" + "thumbnail-" + uuid + "." + extension;
				} catch (Exception e) {
					System.out.println("MESSAGE ==> YOU FAILED TO UPLOAD " + filename + " => " + e.getMessage());
				}
			} else {
				System.out.println("YOU FAILED TO UPLOAD BECAUSE THE FILE WAS EMPTY.");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static String getURLWithContextPath(HttpServletRequest request) {
		return request.getScheme() 
			+ "://" + request.getServerName() 
			+ ":" + request.getServerPort()
			+ request.getContextPath();
	}

}
