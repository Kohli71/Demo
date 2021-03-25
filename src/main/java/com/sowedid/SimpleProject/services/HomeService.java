package com.sowedid.SimpleProject.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
//import org.hibernate.mapping.Collection;
//import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.sowedid.SimpleProject.domain.AddressDomain;
import com.sowedid.SimpleProject.models.Address;
import com.sowedid.SimpleProject.repositories.AddressRepository;
import com.sowedid.SimpleProject.repositories.CityAddMappingRepository;

@Service
@Repository
public class HomeService {
	
	private static final Map<Integer,Address> addMap=new HashMap<Integer,Address>();
	
	static {
		initAdd();
	}
	
	private static void initAdd() {
		Address add3=new Address(1,"Mysore Palace","Mysore");
		Address add4=new Address(2,"Beautiful Place","Bangalore");
		Address add1=new Address(4,"AutoNagar","Vijayawada");
		Address add2=new Address(5,"Mirchi vard","Guntur");
		
	
		addMap.put(add1.getAddressId(), add1);
		addMap.put(add2.getAddressId(), add2);
		addMap.put(add3.getAddressId(), add3);
		addMap.put(add4.getAddressId(), add4);
	}
	
	public Integer getMaxAddressId() {
		Set<Integer> keys=addMap.keySet();
		Integer max=0;
		for(Integer key:keys) {
			if(key>max) {
				max=key;
			}
		}
		return max;
	}
	
	/*public Address getAddress(Integer addressId) {
		return addMap.get(addressId);
	}*/
	
	/*public Address addAddress(AddressDomain addressDomain) {
		Integer addressId=this.getMaxAddressId()+1;
		addressDomain.setAddressId(addressId);
		Address newAdd=new Address(addressDomain);
		addMap.put(newAdd.getAddressId(),newAdd);
		return newAdd;
	}*/
	
	/*public Address updateAddress(AddressDomain addressDomain) {
		Address add=this.getAddress(addressDomain.getAddressId());
		if(add!=null) {
			//add.setAddressId(addressDomain.getAddressId());
			add.setAddressName(addressDomain.getAddressName());
			add.setAddressLoc(addressDomain.getAddressLoc());
		}
		return add;
	}*/
	
	public void deleteAddress(Integer addressId) {
		addMap.remove(addressId);
	}
	
	/*public List<Address> getAllAddresses() {
		Collection<Address> c=addMap.values();
		List<Address> list=new ArrayList<Address>();
		list.addAll(c);
		return list;
	}*/
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	public HomeService(AddressRepository addressRepository) {
		this.addressRepository=addressRepository;
	}
	@Autowired
	private CityAddMappingRepository cityAddMappingRepository;
	
	public List<Address> getAddressDetails(){
		return addressRepository.findAll();
	}

	/*public void saveAddreses(Address address) {
		addressRepository.save(address);
		
	}*/
	
	public void deleteAddresses(Integer addressId) {
		addressRepository.delete(addressId);
	}
	/*public Address getAddressDetails(Integer addressId) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*public void deleteAddress(Integer addressId) { 
		cityAddMappingRepository.deleteByAddressAddressId(addressId);
		
	}*/

	public void deleteCity(Integer cityId) {
		addressRepository.delete(cityId);
		
	}

	public Address getAddressByAddressId(Integer addressId) {
		Address address=addressRepository.findByAddressId(addressId);
		return address;
	}

	public AddressDomain saveOrUpdateAddress(Address address) {
		// TODO Auto-generated method stub
		Address address2=addressRepository.save(address);
		AddressDomain addressDomain=new AddressDomain();
		if(address2!=null){
			addressDomain.setAddressId(address2.getAddressId());
			addressDomain.setAddressName(address2.getAddressName());
			addressDomain.setAddressLoc(address2.getAddressLoc());
			
		}
		return addressDomain;
	}
		
}