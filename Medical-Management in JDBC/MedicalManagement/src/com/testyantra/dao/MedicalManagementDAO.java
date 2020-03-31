package com.testyantra.dao;

import java.util.ArrayList;

import com.testyantra.infobean.MedicalInfoBean;
import com.testyantra.infobean.MedicalInfoBean1;
import com.testyantra.infobean.UserInfoBean;

public interface MedicalManagementDAO {
	
	public boolean deleteUser(UserInfoBean userInfoBean);
	
	public boolean addInventory1(MedicalInfoBean medicalInfoBean);
	
	public boolean addInventory2(MedicalInfoBean1 medicalInfoBean1);
	
	public boolean deleteInventory1(MedicalInfoBean medicalInfoBean);
	
	public boolean deleteInventory2(MedicalInfoBean1 medicalInfoBean1);
	
	public boolean updateInventory1(MedicalInfoBean medicalInfoBean);
	
	public boolean updateInventory2(MedicalInfoBean1 medicalInfoBean1);
	
	public boolean updateInventory3(MedicalInfoBean1 medicalInfoBean1);
	
	public boolean updateInventory4(MedicalInfoBean1 medicalInfoBean1);
	
	public boolean createUser(UserInfoBean userInfoBean);
	
	
	public UserInfoBean authenticate(String email, String password);
	
	public ArrayList displayInventory();
	
	public boolean addCart(MedicalInfoBean1 medicalInfoBean1);

}
