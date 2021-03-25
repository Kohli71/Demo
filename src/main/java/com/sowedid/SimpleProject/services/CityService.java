package com.sowedid.SimpleProject.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowedid.SimpleProject.domain.AddressDomain;
import com.sowedid.SimpleProject.domain.CityAddresssDomain;
import com.sowedid.SimpleProject.models.Address;
import com.sowedid.SimpleProject.models.City;
import com.sowedid.SimpleProject.models.CityAddMapping;
import com.sowedid.SimpleProject.repositories.CityAddMappingRepository;
import com.sowedid.SimpleProject.repositories.CityRepository;

@Service
public class CityService {
@Autowired
private CityRepository cityRepository;

@Autowired
private CityAddMappingRepository cityAddMappingRepository;

public List<City> getCityDetails(){
	return cityRepository.findAll();	
}

public City saveCity(City city) {
	return cityRepository.save(city);
}

public List<CityAddresssDomain> getCityAddresesDetails(Integer cityId) {
	List<CityAddMapping> cityAddMappings= cityAddMappingRepository.findByCityCityId(cityId);
	List<CityAddresssDomain> cityAddresssDomains= new ArrayList<CityAddresssDomain>();
	for (CityAddMapping cityAddMapping : cityAddMappings) {
		CityAddresssDomain cityAddresssDomain = new CityAddresssDomain();
		cityAddresssDomain.setCityName(cityAddMapping.getCity().getCityName());
		/*cityAddresssDomain.setAddressName(cityAddMapping.getAddress().getAddressName());
		cityAddresssDomain.setAddressLoc(cityAddMapping.getAddress().getAddressLoc());
		cityAddresssDomain.setAddressId(cityAddMapping.getAddress().getAddressId());
		cityAddresssDomains.add(cityAddresssDomain);*/
	}
	return cityAddresssDomains;
}

private static Map<Integer,City> cityMap=new HashMap<Integer,City>();

private static Integer idIndex=1;

static {
	City a = new City(1,"Mysore");
    cityMap.put(1, a);
    City b = new City(2,"Bangalore");
    cityMap.put(2, b);
    City c = new City(3,"Mangalore");
    cityMap.put(3, c);
}

public static List<City> list() {
    return new ArrayList<City>(cityMap.values());
  }


  /*public void validateCity(City city) {
	  cityRepository.save(city);
   /* idIndex += idIndex;
    City cityId;
	//cityMap.set(idIndex, cityMap);
    cityMap.put(idIndex, cityId);
    return cityMap;*/
  //}*/
  
  public static City get(Integer cityId) {
	  return cityMap.get(cityId);
  }
  
/*public City validateCity(City city) {
	// TODO Auto-generated method stub
	return cityRepository.save(city);
}

public List<City> CityDetails() {
	return new ArrayList<City>(cityDetails.values);
}*/
  public City getCityByCityId(Integer cityId) {
		City city=cityRepository.findByCityId(cityId);
		return city;
	}

	public CityAddresssDomain validateCity(City city) {
		// TODO Auto-generated method stub
		City city2=cityRepository.save(city);
		CityAddresssDomain cityAddressDomain=new CityAddresssDomain();
		if(city2!=null){
			cityAddressDomain.setCityId(city2.getCityId());
			cityAddressDomain.setCityName(city2.getCityName());
			
		}
		return cityAddressDomain;
	}
	
	public City getCityByCityid(Integer cityId) {
		City city = cityRepository.findByCityid(cityId);
		return city;
	}
	
}