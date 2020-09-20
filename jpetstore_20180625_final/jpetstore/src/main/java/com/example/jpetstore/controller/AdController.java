package com.example.jpetstore.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Advertisement;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class AdController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdController.class);
	
	/**
	 * Upload single file using Spring Controller
	 */
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@RequestMapping("/shop/applyAd.do")
	public ModelAndView applyAd(@RequestParam("itemid") String itemid) throws Exception {
		return new ModelAndView("tiles/ApplyAd", "itemid", itemid);
	}
	
	@RequestMapping(value = "/shop/waitForAdApproval.do", method = RequestMethod.POST)
	public String adApplyHandler(HttpServletRequest request,
			@RequestParam("title") String title,
			@RequestParam("file") MultipartFile file,
			@RequestParam("itemid") String itemid,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate)  throws Exception {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "C:/Users/20150/jejudo2/jpetstore/src/main/webapp/images";
				File dir = new File(rootPath + File.separator + "ad_images");
				if (!dir.exists())
					dir.mkdirs();
				
				Advertisement ad = new Advertisement();
				Item i = this.petStore.getItem(itemid);
				
				ad.setImage(itemid+"_"+file.getOriginalFilename());	//���ε� �� ���� ���ϸ����� �����. �ߺ��Ǵ� ���: ���� item�� �� �� �̻� �����ϰ�, �̹��� ���ϸ��� ���� ���� ���ε��� ��� ����� ���ϰ� ó���ϱ�.
				ad.setFavCategory(i.getProduct().getCategoryId());
				ad.setTitle(title);
				ad.setItemid(itemid);
				String sd[] = startDate.split("-");
				String ed[] = endDate.split("-");
				Calendar sc = Calendar.getInstance();
				Calendar ec = Calendar.getInstance();
				sc.set(Integer.parseInt(sd[0]), Integer.parseInt(sd[1])-1, Integer.parseInt(sd[2]));
				ec.set(Integer.parseInt(ed[0]), Integer.parseInt(ed[1])-1, Integer.parseInt(ed[2]));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
				
				String sDate = dateFormat.format(sc.getTime());
				String eDate = dateFormat.format(ec.getTime());

				ad.setStartDate(sDate);
				ad.setEndDate(eDate);
				//�ϴ� 10����
				long time = ((ec.getTimeInMillis() - sc.getTimeInMillis())/1000)/(24*60*60);
				
				
				ad.setBannerPrice((int)time * 10);
				
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + ad.getImage());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());
				UserSession userSession = 
						(UserSession) WebUtils.getSessionAttribute(request, "userSession");
				petStore.advertisementScheduler(ad, userSession.getAccount());
//				petStore.insertAd(ad);
//				petStore.updateAdStatus(itemid, "1");

				return "tiles/waitForAdApproval";
			} catch (Exception e) {
				return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();	//"�̿뿡 ������ ���~" �������� ��ü
			}
		} else {
			return "You failed to upload " + file.getOriginalFilename()
					+ " because the file was empty.";
		}
	}
	
	@RequestMapping(value = "/shop/waitForAdApproval.do", method = RequestMethod.GET)
	public ModelAndView waitForAdApproval() {
		return new ModelAndView("tiles/waitForAdApproval");
	}
	
}
