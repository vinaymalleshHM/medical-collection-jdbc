package com.testyantra.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.testyantra.dao.MedicalMangementDAO;
import com.testyantra.dao.MedicalMangementDAOImpl;
import com.testyantra.datastore.MedicineDB;
import com.testyantra.datastore.UserDB;
import com.testyantra.infobean.MedicalCreation;
import com.testyantra.infobean.UserCreation;


public class MedicalMApp {
	public static void main(String[] args) {

		MedicalMangementDAO medicalMangementDAO = new MedicalMangementDAOImpl();
		UserCreation userCreation = null;
		MedicalCreation medicalCreation = null;

		while (true) {
			System.out.println(" Enter Choice 1 to Continue...\n 2 to Exit..");
			Scanner s = new Scanner(System.in);
			int choice = s.nextInt();

			if (choice == 1) {

				Scanner sc = new Scanner(System.in);
				System.out.println(" Enter I/P Performance\n admin to Act Like Admin\n user to Use Functionalites\n"
						+ "visitor to view the functions\n");
				String key = sc.next();

				switch (key) {
				case "admin":
					System.out.println(" Your in Adimin Role");
					System.out.println(" 1 to Delete a User\n 2 to"
							+ " Create a Inventory\n 3 to Delete Inventory\n 4 to Modify a inventory");
					Scanner sc1 = new Scanner(System.in);
					int n = sc1.nextInt();

					if (n == 1) {
						System.out.println("Enter The Id");
						int id = sc1.nextInt();
						boolean res = medicalMangementDAO.deleteUser(id);
						if (res) {
							System.out.println("User is Succussfuly Deleted");
						} else {
							System.out.println("User is Not Deleted");
						}
					} 
					else if (n == 2) {
						System.out.println("Enter Shop Name");
						String sName = sc1.next();
						System.out.println("Enter the No of type  Medicine ");
						int no = sc1.nextInt();
						int size = no;
						ArrayList  h = new ArrayList();
						for (int i = 0 ; i < no ; i++) {

							System.out.println("Enter Tablet Name");
							String sTabletName = sc1.next();
							System.out.println("Enter Tablet Price");
							double sTablePrice = sc1.nextDouble();
							System.out.println("Enter Tablet Quantity");
							int sQuantity = sc1.nextInt();
							h.add(sTabletName);
							h.add(sTablePrice);
							h.add(sQuantity);

						}



						medicalCreation = new MedicalCreation();
						medicalCreation.setsName(sName);
						//medicalCreation.setsTabletName(sTabletName);
						//medicalCreation.setsTablePrice(sTablePrice);
						//medicalCreation.setsQuantity(sQuantity);

						boolean res = medicalMangementDAO.createMedicalStore(medicalCreation,h);
						if (res) {
							ArrayList u = MedicineDB.mdcDB.get(MedicalMangementDAOImpl.temp1);
							System.out.println(u);
						}
					}

					else if (n == 3) {
						System.out.println("Enter Id to delete");
						int id = sc1.nextInt();

						if (medicalMangementDAO.deleteMedicalStore(id)) {
							System.out.println("Store is Deleted");
						}
						else {
							System.out.println("Store is Not Able to Deleted");
						}


					} 
					else if (n == 4) {

						System.out.println("Enter to Modify Inventory ID");
						int id = sc1.nextInt();
						if (MedicineDB.mdcDB.containsKey(id)) {
							System.out.println("entre number to modify items");
							System.out.println("1.shope name\n 2.Tablet Name\n 3.Price\n 4.Quentity\n ");
							int ch = sc1.nextInt();
							if (medicalMangementDAO.modifyMedicine(ch, id)) {
								System.out.println("Updated succusfully");
							}
							else {
								System.out.println("Not Updated ");
							}
						}	
						else {
							System.out.println("Invalid Shop Id");
						}
					}

					break;


				case "user":System.out.println(" 1 to Register\n 2 to login");
				Scanner sc2 = new Scanner(System.in);
				int n1 = sc2.nextInt();

				if (n1 == 1) {
					System.out.println("Enter The Name");
					String uName = sc2.next();
					System.out.println("Enter The Age");
					int uAge = sc2.nextInt();
					System.out.println("Enter The Email");
					String uEmail = sc2.next();
					System.out.println("Enter The Password");
					String uPassword = sc2.next();
					System.out.println("Enter The MobileNo");
					long uMobileNo = sc2.nextInt();

					userCreation = new UserCreation();
					userCreation.setuName(uName);
					userCreation.setuAge(uAge);
					userCreation.setuEmail(uEmail);
					userCreation.setuPassword(uPassword);
					userCreation.setuMobileNo(uMobileNo);

					boolean res = medicalMangementDAO.createUser(userCreation);
					if (res) {
						ArrayList u = UserDB.usrDB.get(MedicalMangementDAOImpl.temp);
						// UserCreation usr = (UserCreation) u;
						// System.out.println(usr.getuName());
						System.out.println(u);
					} else {
						System.out.println("can't Add User " + userCreation.getuName());
					}
				} 


				else if (n1==2) {
					System.out.println("Enter UserId to Login");
					int id= sc2.nextInt();
					System.out.println("Enter Password to login");
					String uPassword= sc2.next();

					userCreation = new UserCreation();
					userCreation.setuPassword(uPassword);

					if (medicalMangementDAO.userValidation(id, uPassword)) {
						System.out.println("Login Successfull");


						Set<Integer> ss = MedicineDB.mdcDB.keySet();
						Iterator<Integer> it =ss.iterator();
						while (it.hasNext()) {
							int key1 = it.next(); 

							ArrayList al = MedicineDB.mdcDB.get(key1); 
							for (int i = 1; i < al.size();i++) { 
								/*
								 * if (i==0) {
								 * 
								 * System.out.println("Shop Name "+al.get(i));
								 * 
								 * }
								 */
								if (i==1 || i == 4 || i==7 || i==10 || i== 13 || i== 16 || i== 19 || i== 22 || i== 25   ) { 

									System.out.println("Tablet Name "+al.get(i));
									i++;
									if (i==2 || i == 5 || i== 8 || i== 11 || i== 14 || i== 17 || i== 20 || i== 23 || i== 27  ) { 

										System.out.println("Tablet Price "+al.get(i));
										i++;
										if (i==3 || i == 6 || i== 9 || i== 12 || i== 15 || i== 18 || i== 21 || i== 24 || i== 28 ) { 

											System.out.println("Tablet Quantity "+al.get(i));
											System.out.println("===========================");

										}
									}
								}

							} 

							/*
							 * for (int i = 0; i < al.size();i++) { if (i==0) {
							 * 
							 * System.out.println("Shop Name "+al.get(i));
							 * 
							 * } else if (i==1 || i == 4) {
							 * 
							 * System.out.println("Tablet Name "+al.get(i)); i++; if (i==2 || i == 5) {
							 * 
							 * System.out.println("Tablet Price "+al.get(i)); i++; if (i==3 || i == 6) {
							 * 
							 * System.out.println("Tablet Quantity "+al.get(i));
							 * 
							 * } } }
							 * 
							 * }
							 */ 

						} 
						System.out.println(" Enter 1 to Add Cart\n 2 to Payment\n 3 to Logout");
						int choose = sc2.nextInt();
						if(choose==1) {
								/*
								 * System.out.println("Enter Shop Name"); String sName = sc2.next();
								 */
							System.out.println("Enter Tablet Name");
							String sTabletName = sc2.next();
							System.out.println("Enter Tablet Quantity");
							int sQuantity = sc2.nextInt();

							medicalCreation = new MedicalCreation();
						//	medicalCreation.setsName(sName);
							medicalCreation.setsTabletName(sTabletName);
							medicalCreation.setsQuantity(sQuantity);

							if (medicalMangementDAO.addtoCart(id, medicalCreation)) {
								System.out.println("Added to cart");
								System.out.println(" Enter 1 to Add Cart\n 2 to Payment\n 3 to Logout");
								int choose1 = sc2.nextInt();
								if(choose1==1) {
										/*
										 * System.out.println("Enter Shop Name"); String sName1 = sc.next();
										 */
									System.out.println("Enter Tablet Name");
									String sTabletName1 = sc2.next();
									System.out.println("Enter Tablet Quantity");
									int sQuantity1 = sc2.nextInt();

									medicalCreation = new MedicalCreation();
									//medicalCreation.setsName(sName1);
									medicalCreation.setsTabletName(sTabletName1);
									medicalCreation.setsQuantity(sQuantity1);

									if (medicalMangementDAO.addtoCart(id, medicalCreation)) {
										System.out.println("Added to cart");
									}
									else {
										System.out.println(" Not Added to cart");
									}

								}
								else if(choose1==2) {
									System.out.println("Payment");
								}
								else if(choose1==3) {
									System.out.println("Logout Successfully" +id);
									break;
								}

							}
							else {
								System.out.println(" Not Added to cart");
							}

						}
						else if(choose==2) {
							System.out.println("Payment");
						}
						else if(choose==3) {
							System.out.println("Logout Successfully" +id);
							break;
						}

					}

					//System.out.println(MedicineDB.mdcDB);
					else {
						System.out.println("Inavalid UserId or Password");
					}

				}


				break;

				case "visitor":
					Set<Integer> ss = MedicineDB.mdcDB.keySet();
					Iterator<Integer> it =ss.iterator();
					while (it.hasNext()) {
						int key1 = it.next(); 

						ArrayList al = MedicineDB.mdcDB.get(key1);

						for (int i = 1; i < al.size();i++) { 
							/*
							 * if (i==0) {
							 * 
							 * System.out.println("Shop Name "+al.get(i));
							 * 
							 * }
							 */
							if (i==1 || i == 4 || i==7 || i==10 || i== 13 || i== 16 || i== 19 || i== 22 || i== 25   ) { 

								System.out.println("Tablet Name "+al.get(i));
								i++;
								if (i==2 || i == 5 || i== 8 || i== 11 || i== 14 || i== 17 || i== 20 || i== 23 || i== 27  ) { 

									System.out.println("Tablet Price "+al.get(i));
									i++;
									if (i==3 || i == 6 || i== 9 || i== 12 || i== 15 || i== 18 || i== 21 || i== 24 || i== 28 ) { 

										System.out.println("Tablet Quantity "+al.get(i));
										System.out.println("===========================");

									}
								}
							}

						} 
						/*
						 * for (int i = 0; i < al.size();i++) { if (i==0) {
						 * 
						 * System.out.println("Shop Name "+al.get(i));
						 * 
						 * } else if (i==1) {
						 * 
						 * System.out.println("Tablet Name "+al.get(i));
						 * 
						 * } else if (i==2) {
						 * 
						 * System.out.println("Tablet Price "+al.get(i));
						 * 
						 * } else if (i==3) {
						 * 
						 * System.out.println("Tablet Quantity "+al.get(i));
						 * 
						 * }
						 * 
						 * }
						 */

					} 
					System.out.println("Wish to Continue,1 to SignUp\n 2 to exit");
					int l = sc.nextInt();
					if (l==1) {
						System.out.println("Enter The Name");
						String uName = sc.next();
						System.out.println("Enter The Age");
						int uAge = sc.nextInt();
						System.out.println("Enter The Email");
						String uEmail = sc.next();
						System.out.println("Enter The Password");
						String uPassword = sc.next();
						System.out.println("Enter The MobileNo");
						long uMobileNo = sc.nextInt();

						userCreation = new UserCreation();
						userCreation.setuName(uName);
						userCreation.setuAge(uAge);
						userCreation.setuEmail(uEmail);
						userCreation.setuPassword(uPassword);
						userCreation.setuMobileNo(uMobileNo);

						boolean res = medicalMangementDAO.createUser(userCreation);
						if (res) {
							ArrayList u = UserDB.usrDB.get(MedicalMangementDAOImpl.temp);
							// UserCreation usr = (UserCreation) u;
							// System.out.println(usr.getuName());
							System.out.println(u);
						} else {
							System.out.println("can't Add User " + userCreation.getuName());
						}

					}
					else {
						break;
					}


					break;
				default:
					break;
				}

			} 
			else
				break;

		} // end of while
	}// end of main
}// end of class
