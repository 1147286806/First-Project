package com.situ.mall.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.situ.mall.common.util.JsonUtils;

@Controller
@RequestMapping("/manager/upload")
public class UploadManagerController {

	@RequestMapping(value="/uploadPic", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadPic(MultipartFile pictureFile) {
		//为了防止文件重名（重名文件会覆盖丢失）,所以生成一个不重复的随机的名字dcf38fd6925c44528d6c402d02c04d7b
		String name = UUID.randomUUID().toString().replace("-", "");
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		String fileName = name + "." + ext;//dcf38fd6925c44528d6c402d02c04d7b.png
		String filePath = "D:\\pic\\" + fileName;
		try {
			pictureFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url = "/pic/" + fileName;
		
		Map<String, Object> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("url", url);
		return map;
 	}
	
	@RequestMapping(value="/multiPicUpload", produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String multiPicUpload(MultipartFile pictureFile) {
		System.out.println("UploadManagerController.multiPicUpload()");
		try {
			String name = UUID.randomUUID().toString().replace("-", "");
			String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
			String fileName = name + "." + ext;//dcf38fd6925c44528d6c402d02c04d7b.png
			String filePath = "D:\\pic\\" + fileName;
			try {
				pictureFile.transferTo(new File(filePath));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String url = "/pic/" + fileName;

			Map<String, Object> map = new HashMap<>();
			map.put("error", 0);
			map.put("fileName", fileName);
			map.put("url", url);
			return JsonUtils.objectToJson(map);
		} catch (Exception e) {
			Map<String, Object> map = new HashMap<>();
			map.put("error", 1);
			map.put("message", "图片上传失败");
			return JsonUtils.objectToJson(map);
		}
	}
	
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		System.out.println(uuid);
	}
}
