package oracle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import ex_240311_jdbc_member_with_swing_oracle.MemberProc;
import ex_240311_jdbc_member_with_swing_oracle.Member_List;

//import javax.management.loading.PrivateClassLoader;

public class main1 {
//static
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	    // new Member_List();
	   // }//main
		/*
	    @Override
	    public void mouseClicked(MouseEvent e) {
	        // mouseClicked 만 사용
	        int r = jTable.getSelectedRow();
	        String id = (String) jTable.getValueAt(r, 0);
	        //System.out.println("id="+id);
	       // MemberProc mem = new MemberProc(id,this); //아이디를 인자로 수정창 생성
	               
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
	        // TODO Auto-generated method stub
	       
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
	        // TODO Auto-generated method stub
	       
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
	        // TODO Auto-generated method stub
	       
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
	        // TODO Auto-generated method stub
	       
	    }
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        //버튼을 클릭하면
	        //if(e.getSource() == btnInsert ){
	           // new MemberProc(this);
	           
	          
	            //dao = new MemberDAO();           
	            //dao.userSelectAll(model);
	            //model.fireTableDataChanged();
	            //jTable.updateUI();           
	            //jTable.requestFocusInWindow();
	           
	        }
	    
	

 */
	
		
		try {
			// 분리된 조회 기능 호출 해보기. 
			//db2.edit("lsh", "이상현", "hi","1987-06-25");
			db2.select();
			// 분리된 기능, 데이터 입력해보기. 
			//db2.insert("lsy",  "이상용", "hello", "1980-03-15");
			
			//db2.select();
			//db2.insert("lsh", "이상현", "hi","1987-06-25");
		//db2.delete("lsh");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
}

