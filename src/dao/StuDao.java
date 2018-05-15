package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entity.Student;
import utils.Constant;
import utils.DBhelper;
import utils.Setting;

public class StuDao {
	
	//获得所有学生信息
	public static ArrayList<Student> getAllStudents() throws SQLException{
		Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Student> list = new ArrayList<Student>();
		
		try {
			String sql = "select * from "+Constant.STUTABLE+" order by id;";
			conn = DBhelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				
				stu.setUsername(rs.getString(Constant.USERNAME_STU));
				stu.setPassword(rs.getString(Constant.PASSWORD_STU));
				stu.setId(rs.getString(Constant.ID_STU));
				stu.setBirthday(rs.getString(Constant.BIRTHDAY_STU));
				stu.setSex(rs.getString(Constant.SEX_STU));
				stu.setName(rs.getString(Constant.NAME_STU));
				stu.setEmail(rs.getString(Constant.EMAIL_STU));
				stu.setInterview(rs.getString(Constant.INTERVIEW_STU));
				stu.setPhone(rs.getString(Constant.PHONE_STU));
				
				list.add(stu);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		finally{
			
			stmt.close();
			rs.close();
		}
		return list;
		
	}
	
	//根据id找到学生
		public static  Student getStudentById( String id) {
			Connection conn=null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "select * from "+Constant.STUTABLE+" where "+Constant.ID_STU+"=?;";
				
				conn = DBhelper.getConnection();
				stmt = conn.prepareStatement(sql);
				//取代sql语句里第几个问号，从1开始
				stmt.setString(1, id);
				rs=stmt.executeQuery();
				if(rs.next()) {
					Student stu = new Student();
					stu.setUsername(rs.getString(Constant.USERNAME_STU));
					stu.setPassword(rs.getString(Constant.PASSWORD_STU));
					stu.setId(rs.getString(Constant.ID_STU));
					stu.setBirthday(rs.getString(Constant.BIRTHDAY_STU));
					stu.setSex(rs.getString(Constant.SEX_STU));
					stu.setName(rs.getString(Constant.NAME_STU));
					stu.setEmail(rs.getString(Constant.EMAIL_STU));
					stu.setInterview(rs.getString(Constant.INTERVIEW_STU));
					stu.setPhone(rs.getString(Constant.PHONE_STU));
					
					
				return stu;
			}
				else return null;
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}finally {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			}
		
		//根据id找到学生
				public static  Student getStudentByUsername( String username) {
					Connection conn=null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					
					try {
						String sql = "select * from "+Constant.STUTABLE+" where "+Constant.USERNAME_STU+"=?;";
						
						conn = DBhelper.getConnection();
						stmt = conn.prepareStatement(sql);
						//取代sql语句里第几个问号，从1开始
						stmt.setString(1, username);
						rs=stmt.executeQuery();
						if(rs.next()) {
							Student stu = new Student();
							stu.setUsername(rs.getString(Constant.USERNAME_STU));
							stu.setPassword(rs.getString(Constant.PASSWORD_STU));
							stu.setId(rs.getString(Constant.ID_STU));
							stu.setBirthday(rs.getString(Constant.BIRTHDAY_STU));
							stu.setSex(rs.getString(Constant.SEX_STU));
							stu.setName(rs.getString(Constant.NAME_STU));
							stu.setEmail(rs.getString(Constant.EMAIL_STU));
							stu.setInterview(rs.getString(Constant.INTERVIEW_STU));
							stu.setPhone(rs.getString(Constant.PHONE_STU));
							
							
						return stu;
					}
						else return null;
						
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return null;
					}finally {
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
					}
		
		//插入学生
			public static  void insertStudent(Student stu) {
				String id = stu.getId();
				String username=stu.getUsername();
				String password = stu.getPassword();
				String name= stu.getName();
				String sex = stu.getSex();
				String email=stu.getEmail();
				String phone = stu.getPhone();
				String interview = stu.getInterview();
				String birthday=stu.getBirthday();
				
				Connection conn=null;
				PreparedStatement stmt = null;
			
				try {
					
					String sql = "insert into "+Constant.STUTABLE+" values (?,?,?,?,?,?,?,?,?);";
					conn = DBhelper.getConnection();
					stmt = conn.prepareStatement(sql);
					//取代sql语句里第几个问号，从1开始
					stmt.setString(1, id);
					stmt.setString(2, username);
					stmt.setString(3, password);
					stmt.setString(4, name);
					stmt.setString(5, sex);
					stmt.setString(6, birthday);
					stmt.setString(7, email);
					stmt.setString(8, phone);
					stmt.setString(9, interview);
					stmt.executeUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			
			//删除学生
			public static  void delectStuByID( String id) {
				Connection conn=null;
				PreparedStatement stmt = null;
				
				
				try {
					String sql = "delete from "+Constant.STUTABLE+" where "+Constant.ID_STU+"=?;";
					
					conn = DBhelper.getConnection();
					stmt = conn.prepareStatement(sql);
					//取代sql语句里第几个问号，从1开始
					stmt.setString(1, id);
					stmt.executeUpdate();
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					
				}finally {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				}
			
			
			//更新信息
			public static void updateInfo(Student stu) {
				//学生可以自己更改的信息,name，sex，birthday，phone,email,interview
				Connection conn=null;
				PreparedStatement stmt = null;
				
				
				try {
					String sql2=""+Constant.ID_STU+"='"+stu.getId()+"'";
					if(stu.getName()!=null) {
						 sql2 = sql2+","+Constant.NAME_STU+"='"+stu.getName()+"'";
					}
					String sql = "update "+Constant.STUTABLE+" set "+sql2+" where "+Constant.ID_STU+"='"+stu.getId()+"';";
					System.out.println(sql);
					
					conn = DBhelper.getConnection();
					stmt = conn.prepareStatement(sql);
					stmt.executeUpdate();
					
					
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					
				}finally {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
				
			}
			
			//录入成绩,同个一个成绩数组和科目编号
			public static void updateScores(ArrayList<Integer> scoreList,int id_subject) {
				Connection conn=null;
				PreparedStatement stmt = null;
				ArrayList<Student> list = null;
				try {
					list = StuDao.getAllStudents();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					
					conn = DBhelper.getConnection();
					String sql="";
					for(int i=0;i<list.size()&&i<scoreList.size();i++) {
						
						sql = "update "+Constant.STUTABLE+" set s"+id_subject+"="+scoreList.get(i)+" where "+Constant.ID_STU+"='"+list.get(i).getId()+"';";
						stmt = conn.prepareStatement(sql);
						stmt.executeUpdate();
						System.out.println(sql);
					}
					
					
					
					
					
					
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					
				}finally {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				}
				
				
			}
			
		//判断是否为新学号
		public static Boolean isNewID(String id) {
			ArrayList<Student> list=new ArrayList<Student>();
			try {
				 list= StuDao.getAllStudents();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(Student stu:list) {
				if(id.equals(stu.getId()))
					return true;
			}
			return false;
		}
		
		//判断是否是新建帐号
		public static Boolean FirstCreateUsername(String id) {
			
			Student stu=StuDao.getStudentById(id);
			System.out.println(stu.getName()+stu.getUsername());
			if(stu.getUsername()==null)return true;
			else return false;
		}
		//判断帐号是否已注册
		public static Boolean isNewUsername(String username) {
			ArrayList<Student> list = null;
			try {
				list = StuDao.getAllStudents();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Student stu:list) {
				if(stu.getUsername()!=null)
				if(stu.getUsername().equals(username))
					return false;
			}
			return true;
		}
		
		//帐号密码是否匹配
		public static Boolean isCorrectPassword(String username,String password) {
			ArrayList<Student> list = null;
			try {
				list = StuDao.getAllStudents();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Student stu:list) {
				
				if(stu.getUsername()!=null&&stu.getUsername().equals(username)&&stu.getPassword().equals(password))
					return true;
			}
			return false;
			
			 
		}
		
	
	
	
	public static void main(String[] args) {
//		ArrayList<Student> list = new ArrayList<Student>();
//		try {
//			list = StuDao.getAllStudents();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(Student stu:list) {
//			System.out.println(stu.getName());
//	}
		
//		//测试findbyid
//		Student stu = new Student();
//		stu = StuDao.getStudentById("99999999");
//		if(stu!=null)
//		System.out.println(stu.getName());
//		else System.out.println("未找到");
		
//		stu.setId("99999999");
//		StuDao.insertStudent(stu);
		
//		//测试是否为新学号
//		if(StuDao.isNewID("16002"))System.out.println("已存在");
//		else System.out.println("新学号");
		
//		//是否新的帐号
//		if(StuDao.isNewUsername("1"))System.out.println("未建立帐号");
//		else System.out.println("已有帐号");
		
//		//帐号密码是否正确
//		if(StuDao.isCorrectPassword("admin", "admin3"))System.out.println("正确");
//		else System.out.println("错误请检查一下");
		
//		//测试删除学生
//		StuDao.delectStuByID("99999999");
//		if(StuDao.getStudentById("99999999")==null)System.out.println("删除成功");
//		else System.out.println("删除失败");
		
//		//测试修改信息
//		Student stu = new Student();
//		stu.setId("1600200010");
//		
//		StuDao.updateInfo(stu);
		
//		//测试检验是否为新帐号
//		String username = "admin3";
//		if(StuDao.isNewUsername(username)) {
//			System.out.println("可以使用");
//		}
//		else System.out.println("一存在");
//		
		//测试录入成绩
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for(int i = 0;i <10;i++) {
//			list.add(i);
//		}
//		StuDao.updateScores(list, 0);
	}
		

};
