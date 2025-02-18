package controller.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.FilenameChange;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class PhotoUploadController {

	@GetMapping("/uploadform")
	public String upload()
	{
		return "upload/uploadform";
	}

	@PostMapping("/uploadprocess")
	public String uploadPhoto(
			HttpServletRequest request,
			Model model,
			@RequestParam String title,
			@RequestParam("upload") MultipartFile upload
			) {
		//업로드할 프로젝트내의 위치를 지정(webapp/save)
		String uploadFolder=request.getSession().getServletContext().getRealPath("/save");
		System.out.println(uploadFolder);

		//업로드할 파일명

		//원래파일명으로 저장할경우 같은이름업로드시 덮어써지는 문제 발생
		//String uploadFile=upload.getOriginalFilename();

		String uploadFileName=FilenameChange.getDateChangeFileName(upload.getOriginalFilename());

		//업로드
		try {
			upload.transferTo(new File(uploadFolder+"/"+uploadFileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("title", title);
		model.addAttribute("photo", uploadFileName);

		return "upload/uploadresult";
	}

	//파일 여러개 업로드
	@GetMapping("/multiform")
	public String multi()
	{
		return "upload/uploadformmulti";
	}

	@PostMapping("/multiprocess")
	public String multiUpload(
			HttpServletRequest request,
			@RequestParam String title,
			@RequestParam("upload") List<MultipartFile> uploadList,
			Model model
			)
	{
		//제목부터 모델에 저장
		model.addAttribute("title", title);

		//업로드할 프로젝트내의 위치를 지정(webapp/save)
		String uploadFolder=request.getSession().getServletContext().getRealPath("/save");


		//업로드된 파일명을 저장할 리스트변수
		List<String> list=new Vector<>();

		//여러개의 파일들을 업로드(파일명은 뒤에 날짜붙여서 업로드하기)
		for(MultipartFile multiFile:uploadList)
		{
			//업로드할 파일명 구하기
			//String uploadFileName=FilenameChange.getDateChangeFileName(multiFile.getOriginalFilename());
			String uploadFileName=FilenameChange.getRandomChangeFileName(multiFile.getOriginalFilename());
			//사진들 업로드
			try {
				multiFile.transferTo(new File(uploadFolder+"/"+uploadFileName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//업로드된 파일명 list 에 추가
			list.add(uploadFileName);
		}

		//list 를 모델에 저장
		model.addAttribute("list", list);

		return "upload/uploadresultmulti";
	}

	//ajax
	@GetMapping("/ajaxupload")
	public String ajaxForm()
	{
		return "upload/ajaxphotoupload";
	}

	//사진을 업로드후 json 형태로 파일명 반환
	//ajax 함수를 통해서 호출되는 메서드
	@PostMapping("/oneupload")
	@ResponseBody
	public Map<String, String> photoUpload(HttpServletRequest request,
			@RequestParam("upload") MultipartFile upload)
	{
		//업로드할 경우
		String uploadPath=request.getSession().getServletContext().getRealPath("/save");
		//업로드할 파일명
		String uploadFileName=FilenameChange.getDateChangeFileName(upload.getOriginalFilename());

		//업로드
		try {
			upload.transferTo(new File(uploadPath+"/"+uploadFileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, String> map=new HashMap<>();
		map.put("photo", uploadFileName);
		return map;
	}

	//ajax-여러개 사진 업로드
	@GetMapping("/multiajaxupload")
	public String ajaxMultiForm()
	{
		return "upload/ajaxmultiuploadform";
	}

	@PostMapping("/multiupload")
	@ResponseBody	
	public List<Map<String, String>> ajaxMultiUpload(
			HttpServletRequest request,
			@RequestParam("upload") List<MultipartFile> uploadList
			)
	{
		List<Map<String, String>> list=new Vector<>();

		//업로드할 프로젝트내의 위치를 지정(webapp/save)
		String uploadFolder=request.getSession().getServletContext().getRealPath("/save");


		//여러개의 파일들을 업로드(파일명은 UUID 로)
		for(MultipartFile multiFile:uploadList)
		{
			String uploadFileName=FilenameChange.getRandomChangeFileName(multiFile.getOriginalFilename());
			//사진들 업로드
			try {
				multiFile.transferTo(new File(uploadFolder+"/"+uploadFileName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//업로드된 파일명 list 에 추가
			Map<String, String> map=new HashMap<>();
			map.put("photo", uploadFileName);
			list.add(map);
		}

		return list;
	}

}


















