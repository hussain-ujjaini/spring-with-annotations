package com.countryController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.countryModel.CountryDAO;
import com.countryView.CountryVO;

@Controller
public class CountryController {
	
	@Autowired
	CountryDAO countryDao;
	
	@RequestMapping(method=RequestMethod.GET,value="/addCountry")
	public ModelAndView addCountry() {
		return new ModelAndView("addCountry","data",new CountryVO());
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addCountryInDb")
	public ModelAndView insert(@ModelAttribute CountryVO countryvo) {
		countryDao.insert(countryvo);
		return new ModelAndView("../../index");
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/searchCountry")
	public ModelAndView searchCountry() {
		return new ModelAndView("searchCountry","data",new CountryVO());
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/searchCountryInDb")
	public ModelAndView search(@ModelAttribute CountryVO countryvo) {
		List countryList=countryDao.search(countryvo);
		if(countryList.size()>0) {
			return new ModelAndView("searchCountry", "searchCountryList", countryList).addObject("data", countryvo).addObject("msg", "Country List");
		}
		else {
			return new ModelAndView("searchCountry", "msg", "No Country Found").addObject("data", countryvo);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/viewCountries")
	public ModelAndView viewCountries() {
		List countryList=countryDao.viewCountries();
		CountryVO countryVo=new CountryVO();
		if(countryList.size()>0) {
			return new ModelAndView("viewCountries", "countryList", countryList).addObject("msg", "Country List").addObject("data", countryVo);
		}
		else {
			return new ModelAndView("viewCountries", "msg", "No Country Found");
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/deleteCountry")
	public ModelAndView deleteCountry(@RequestParam("countryId") String countryId) {
		
		CountryVO countryVo=new CountryVO();
		int deleteCountryId=Integer.parseInt(countryId);
		countryVo.setCountryId(deleteCountryId);
		countryDao.deleteCountry(countryVo);
		ModelAndView m=viewCountries();
		return m;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/editCountry")
	public ModelAndView editCountry(@RequestParam("countryId") String countryId) {
		CountryVO countryVo=new CountryVO();
		int editCountryId=Integer.parseInt(countryId);
		countryVo.setCountryId(editCountryId);
		List<CountryVO> searchCountryList=countryDao.searchCountryById(countryVo);
		return new ModelAndView("viewCountries", "data" , new CountryVO(searchCountryList.get(0)));
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/editCountryInDb")
	public ModelAndView editCountryInDb(@RequestParam("countryName") String countryName, @RequestParam("countryId") String countryId, @ModelAttribute CountryVO countryVo) {
		//CountryVO countryVo=new CountryVO();
		int editCountryId=Integer.parseInt(countryId);
		countryVo.setCountryId(editCountryId);
		String editCountryName=countryName;
		countryVo.setCountryName(editCountryName);
		countryDao.editCountryInDb(countryVo);
		ModelAndView m=viewCountries();
		return m;
	}
}