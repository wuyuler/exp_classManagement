package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Student;
import entity.Teacher;
import utils.Constant;
import utils.DBhelper;

public class TchDao {
	
	//获得所有学生信息
		public static ArrayList<Teacher> getAllTeachers() throws SQLException{
			Connection conn=null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<Teacher> list = new ArrayList<Teacher>();
			
			try {
				String sql = "select * from "+Constant.TEATABLE+" order by id;";
				conn = DBhelper.getConnection();
				stmt = conn.prepareStatement(sql);
				rs=stmt.executeQuery();
				while(rs.next()) {
					Teacher tch = new Teacher();
					
					tch.setUsername(rs.getString(Constant.USERNAME));
					tch.setPassword(rs.getString(Constant.PASSWORD));
					tch.setId(rs.getString(Constant.ID));
					tch.setBirthday(rs.getString(Constant.BIRTHDAY));
					tch.setSex(rs.getString(Constant.SEX));
					tch.setName(rs.getString(Constant.NAME));
					tch.setEmail(rs.getString(Constant.EMAIL));
					tch.setInterview(rs.getString(Constant.INTERVIEW));
					tch.setPhone(rs.getString(Constant.PHONE));
					tch.setSubject(rs.getString(Constant.SUBJECT));
					
					list.add(tch);
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
		
		//根据id找到老师
				public static  Teacher getTeacherById( String id) {
					Connection conn=null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					
					try {
						String sql = "select * from "+Constant.TEATABLE+" where "+Constant.ID+"=?;";
						
						conn = DBhelper.getConnection();
						stmt = conn.prepareStatement(sql);
						//取代sql语句里第几个问号，从1开始
						stmt.setString(1, id);
						rs=stmt.executeQuery();
						if(rs.next()) {
							Teacher tch = new Teacher();
							tch.setUsername(rs.getString(Constant.USERNAME));
							tch.setPassword(rs.getString(Constant.PASSWORD));
							tch.setId(rs.getString(Constant.ID));
							tch.setBirthday(rs.getString(Constant.BIRTHDAY));
							tch.setSex(rs.getString(Constant.SEX));
							tch.setName(rs.getString(Constant.NAME));
							tch.setEmail(rs.getString(Constant.EMAIL));
							tch.setInterview(rs.getString(Constant.INTERVIEW));
							tch.setPhone(rs.getString(Constant.PHONE));
							tch.setSubject(rs.getString(Constant.SUBJECT));
							
						return tch;
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
				
				//根据id找到老师
				public static  Teacher getTeacherByUsername( String username) {
					Connection conn=null;
					PreparedStatement stmt = null;
					ResultSet rs = null;
					
					try {
						String sql = "select * from "+Constant.TEATABLE+" where "+Constant.USERNAME+"=?;";
						
						conn = DBhelper.getConnection();
						stmt = conn.prepareStatement(sql);
						//取代sql语句里第几个问号，从1开始
						stmt.setString(1, username);
						rs=stmt.executeQuery();
						if(rs.next()) {
							Teacher tch = new Teacher();
							tch.setUsername(rs.getString(Constant.USERNAME));
							tch.setPassword(rs.getString(Constant.PASSWORD));
							tch.setId(rs.getString(Constant.ID));
							tch.setBirthday(rs.getString(Constant.BIRTHDAY));
							tch.setSex(rs.getString(Constant.SEX));
							tch.setName(rs.getString(Constant.NAME));
							tch.setEmail(rs.getString(Constant.EMAIL));
							tch.setInterview(rs.getString(Constant.INTERVIEW));
							tch.setPhone(rs.getString(Constant.PHONE));
							tch.setSubject(rs.getString(Constant.SUBJECT));
							
						return tch;
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
				
				//更新信息
				public static void updateInfo(Teacher stu) {
					//老师可以自己更改的信息,name，sex，birthday，phone,email,interview
					Connection conn=null;
					PreparedStatement stmt = null;
					
					
					try {
						String sql2=""+Constant.ID+"='"+stu.getId()+"'";
						if(stu.getName()!=null) {
							 sql2 = sql2+","+Constant.NAME+"='"+stu.getName()+"'";
						}
						if(stu.getSex()!=null) {
							 sql2 = sql2+","+Constant.SEX+"='"+stu.getSex()+"'";
						}
						if(stu.getBirthday()!=null) {
							 sql2 = sql2+","+Constant.BIRTHDAY+"='"+stu.getBirthday()+"'";
						}
						if(stu.getEmail()!=null) {
							 sql2 = sql2+","+Constant.EMAIL+"='"+stu.getEmail()+"'";
						}
						if(stu.getUsername()!=null) {
							 sql2 = sql2+","+Constant.USERNAME+"='"+stu.getUsername()+"'";
						}
						if(stu.getPassword()!=null) {
								 sql2 = sql2+","+Constant.PASSWORD+"='"+stu.getPassword()+"'";
							}
						if(stu.getPhone()!=null)sql2 = sql2+","+Constant.PHONE+"='"+stu.getPhone()+"'";
						if(stu.getInterview()!=null)sql2=sql2+","+Constant.INTERVIEW+"='"+stu.getInterview()+"'";
						String sql = "update "+Constant.TEATABLE+" set "+sql2+" where "+Constant.ID+"='"+stu.getId()+"';";
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
				
				//判断帐号是否已注册
				public static Boolean isNewUsername(String username) {
					ArrayList<Teacher> list = null;
					try {
						list = TchDao.getAllTeachers();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(Teacher stu:list) {
						if(stu.getUsername()!=null)
						if(stu.getUsername().equals(username))
							return false;
					}
					return true;
				}
				
				//帐号密码是否匹配
				public static Boolean isCorrectPassword(String username,String password) {
					ArrayList<Teacher> list = null;
					try {
						list = TchDao.getAllTeachers();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(Teacher stu:list) {
						
						if(stu.getUsername()!=null&&stu.getUsername().equals(username)&&stu.getPassword().equals(password))
							return true;
					}
					return false;
					
					 
				}
				//判断是否为新学号
				public static Boolean isNewID(String id) {
					ArrayList<Teacher> list=new ArrayList<Teacher>();
					try {
						 list= TchDao.getAllTeachers();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for(Teacher stu:list) {
						if(id.equals(stu.getId()))
							return false;
					}
					return true;
				}
		
				//判断是否是新建帐号
				public static Boolean isFirstCreateUsername(String id) {
					
					Teacher stu=TchDao.getTeacherById(id);
					System.out.println(stu.getName()+stu.getUsername());
					if(stu.getUsername()==null)return true;
					else return false;
				}
				//插入老师
				public static  void insertTeacher(Teacher stu) {
					String id = stu.getId();
					String username=stu.getUsername();
					String password = stu.getPassword();
					String name= stu.getName();
					String sex = stu.getSex();
					String email=stu.getEmail();
					String phone = stu.getPhone();
					String subject = stu.getSubject();
					String interview = stu.getInterview();
					String birthday=stu.getBirthday();
					
					Connection conn=null;
					PreparedStatement stmt = null;
				
					try {
						
						String sql = "insert into "+Constant.TEATABLE+" values (?,?,?,?,?,?,?,?,?,?);";
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
						stmt.setString(9, subject);
						stmt.setString(10, interview);
						System.out.println(sql);
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
				public static  void delectTchByID( String id) {
					Connection conn=null;
					PreparedStatement stmt = null;
					
					
					try {
						String sql = "delete from "+Constant.TEATABLE+" where "+Constant.ID+"=?;";
						
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
			
		public static void main(String[] args) {
			
//			ArrayList<Teacher> list=null;
//			try {
//			list = TchDao.getAllTeachers();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			for(Teacher tch:list) {
//				System.out.println(tch.getName());
//			}
			
//			//测试根据id找到老师
//			Teacher tch = TchDao.getTeacherById("0");
//			System.out.println(tch.getName());
			
//			Teacher tch = new Teacher();
//			tch.setId("0");
//			tch.setInterview("我蚁王");
//			TchDao.updateInfo(tch);
			//测试插入
			
			Teacher tch = new Teacher();
			tch.setId("12354");
			tch.setName("龙");
			tch.setSubject("军事");
			tch.setSex("男");
			
			TchDao.insertTeacher(tch);
			
		}

}
