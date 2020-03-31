package com.testyantra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.testyantra.infobean.MedicalInfoBean;
import com.testyantra.infobean.MedicalInfoBean1;
import com.testyantra.infobean.UserInfoBean;

public class MedicalManagementDAOImpl implements MedicalManagementDAO{

	UserInfoBean userInfoBean = null;
	@Override
	public boolean deleteUser(UserInfoBean userInfoBean) {

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean  isadde=false;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");
			String query="delete from user where user_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,userInfoBean.getUser_Id());
			int n = pstmt.executeUpdate();
			if(n>0) {
				isadde=true;
			}
		} 

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}




		finally {

			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return isadde;
	}



	@Override
	public boolean addInventory1(MedicalInfoBean medicalInfoBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isAdded= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");

			String query="insert into product values(?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, medicalInfoBean.getSh_Id());
			pstmt.setString(2,medicalInfoBean.getSh_Name() );
			int n =pstmt.executeUpdate();

			if(n>0) {
				isAdded= true;

			}


		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {


			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return isAdded;

	}






	@Override
	public boolean addInventory2(MedicalInfoBean1 medicalInfoBean1) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isAdded= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");

			String query="insert into product1 values(?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, medicalInfoBean1.getT_Id());
			pstmt.setString(2, medicalInfoBean1.getSh_Name());
			pstmt.setString(3,medicalInfoBean1.getTab_Name() );
			pstmt.setInt(4,medicalInfoBean1.getTab_Qty() );
			pstmt.setDouble(5,medicalInfoBean1.getTab_Price() );

			int n =pstmt.executeUpdate();

			if(n>0) {
				isAdded= true;

			}


		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {


			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return isAdded;

	}






	@Override
	public boolean deleteInventory1(MedicalInfoBean medicalInfoBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean  isadde=false;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");
			String query="delete from product where sh_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,medicalInfoBean.getSh_Id());
			int n = pstmt.executeUpdate();
			if(n>0) {
				isadde=true;
			}
		} 

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}




		finally {

			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return isadde;

	}






	@Override
	public boolean deleteInventory2(MedicalInfoBean1 medicalInfoBean1) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean  isadde=false;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");
			String query="delete from product1 where t_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,medicalInfoBean1.getT_Id());
			int n = pstmt.executeUpdate();
			if(n>0) {
				isadde=true;
			}
		} 

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}




		finally {

			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return isadde;

	}






	@Override
	public boolean updateInventory1(MedicalInfoBean medicalInfoBean) {

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean  isUp=false;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");

			String query="update product set sh_name=? where sh_id=? ";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1,medicalInfoBean.getSh_Name());
			pstmt.setInt(2,medicalInfoBean.getSh_Id());
			int n = pstmt.executeUpdate();

			if(n>0) {
				isUp=true;
			}




		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {

			if (pstmt != null) {

				try {

					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


			return isUp;


		}
	}






	@Override
	public boolean updateInventory2(MedicalInfoBean1 medicalInfoBean1) {

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean  isUp=false;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");

			String query="update product1 set tab_name=? where t_id=? ";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1,medicalInfoBean1.getTab_Name());
			pstmt.setInt(2,medicalInfoBean1.getT_Id());
			int n = pstmt.executeUpdate();

			if(n>0) {
				isUp=true;
			}




		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {

			if (pstmt != null) {

				try {

					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


			return isUp;


		}
	}






	@Override
	public boolean updateInventory3(MedicalInfoBean1 medicalInfoBean1) {

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean  isUp=false;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");

			String query="update product1 set tab_qty=? where t_id=? ";
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1,medicalInfoBean1.getTab_Qty());
			pstmt.setInt(2,medicalInfoBean1.getT_Id());
			int n = pstmt.executeUpdate();

			if(n>0) {
				isUp=true;
			}




		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {

			if (pstmt != null) {

				try {

					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


			return isUp;



		}
	}






	@Override
	public boolean updateInventory4(MedicalInfoBean1 medicalInfoBean1) {

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean  isUp=false;


		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");

			String query="update product1 set tab_price=? where t_id=? ";
			pstmt = con.prepareStatement(query);

			pstmt.setDouble(1,medicalInfoBean1.getTab_Price());
			pstmt.setInt(2,medicalInfoBean1.getT_Id());
			int n = pstmt.executeUpdate();

			if(n>0) {
				isUp=true;
			}




		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {

			if (pstmt != null) {

				try {

					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


			return isUp;


		}
	}






	@Override
	public boolean createUser(UserInfoBean userInfoBean) {

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isAdded= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");

			String query="insert into user values(?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userInfoBean.getUser_Id());
			pstmt.setString(2,userInfoBean.getUser_Name());
			pstmt.setString(3,userInfoBean.getEmail() );
			pstmt.setString(4,userInfoBean.getPassword() );
			pstmt.setLong(5,userInfoBean.getMobile() );

			int n =pstmt.executeUpdate();

			if(n>0) {
				isAdded= true;

			}


		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {


			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return isAdded;


	}






	@Override
	public UserInfoBean authenticate(String email, String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfoBean userInfoBean = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");

			String query="select * from user where email=? and password=? ";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();


			if (rs.next()) {

				userInfoBean = new UserInfoBean();
				userInfoBean.setUser_Id(rs.getInt("user_id"));
				userInfoBean.setUser_Name(rs.getString("user_name"));
				userInfoBean.setEmail(rs.getString("email"));
				userInfoBean.setPassword(rs.getString("password"));
				userInfoBean.setMobile(rs.getLong("mobile"));



			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {

			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			if (pstmt != null) {

				try {

					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


			return userInfoBean;

		}
	}






	@Override
	public ArrayList displayInventory() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		MedicalInfoBean1 medicalInfoBean1 = null;
		ArrayList al = new ArrayList();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");
			String query="select * from product1";
			pstmt = con.prepareStatement(query);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				medicalInfoBean1 = new MedicalInfoBean1();
				medicalInfoBean1.setT_Id(rs.getInt("t_id"));
				medicalInfoBean1.setSh_Name(rs.getString("sh_name"));
				medicalInfoBean1.setTab_Name(rs.getString("tab_name"));
				medicalInfoBean1.setTab_Qty(rs.getInt("tab_qty"));
				medicalInfoBean1.setTab_Price(rs.getDouble("tab_price"));
				al.add(medicalInfoBean1.getT_Id());
				//al.add(medicalInfoBean1.getSh_Name());
				al.add(medicalInfoBean1.getTab_Name());
				al.add(medicalInfoBean1.getTab_Qty());
				al.add(medicalInfoBean1.getTab_Price());

			}

		}

		catch (Exception e) {

		}

		finally {

			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}




		}
		return al;



	}






	@Override
	public boolean addCart(MedicalInfoBean1 medicalInfoBean1) {

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isCart= false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_booking_store","root","root");

			String query="insert into cart values(?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, medicalInfoBean1.getEmail());
			pstmt.setString(2,medicalInfoBean1.getTab_Name() );
			pstmt.setInt(3,medicalInfoBean1.getTab_Qty() );
			pstmt.setDouble(4,medicalInfoBean1.getTab_Price() );

			int n =pstmt.executeUpdate();

			if(n>0) {
				isCart= true;

			}


		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {


			if (pstmt != null) {

				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return isCart;



	}




}

