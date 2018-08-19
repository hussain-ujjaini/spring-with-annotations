package com.countryModel;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.countryView.CountryVO;


@Repository
public class CountryDAO {
	@Autowired
	SessionFactory sf;
	public void insert(CountryVO vo)
	{
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.saveOrUpdate(vo);
		tx.commit();
		s.close();
	}
	public List search(CountryVO countryvo) {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		String hbl="from CountryVO where countryName like '"+countryvo.getCountryName()+"%'";
		Query query=s.createQuery(hbl);
		List countryList=query.list();
		tx.commit();
		s.close();
		return countryList;
	}
	public List viewCountries() {
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		String hbl="from CountryVO";
		Query query=s.createQuery(hbl);
		List countryList=query.list();
		tx.commit();
		s.close();
		return countryList;
	}
	public void deleteCountry(CountryVO countryVo) {
		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.delete(countryVo);
		tx.commit();
		s.close();
	}
	public void editCountryInDb(CountryVO countryvo) {
		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.update(countryvo);
		tx.commit();
		s.close();
	}
	public List<CountryVO> searchCountryById(CountryVO countryVo) {
		
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		String hbl="from CountryVO where countryId = '"+countryVo.getCountryId()+"%'";
		Query query=s.createQuery(hbl);
		List<CountryVO> countryList=query.list();
		tx.commit();
		s.close();
		return countryList;
	}
}