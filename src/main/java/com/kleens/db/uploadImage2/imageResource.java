package com.kleens.db.uploadImage2;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kleens.db.Repo.imageRepo;

@RestController
@RequestMapping(value = "/kleens")
public class imageResource {
@Autowired
imageRepo imgRepo;

@PostMapping("/upload2/{id}")
public image uploadimage2(@PathVariable Long id,@RequestParam("myFile") MultipartFile  file ) throws IOException{
	image img = new image( file.getBytes());
	imgRepo.findOne(id);
	final image savedImage = imgRepo.save(img);
	System.out.println("Image Saved");
	return savedImage;
	
}

}
