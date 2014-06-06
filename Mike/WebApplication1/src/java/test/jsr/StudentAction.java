
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jsr;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author sjampani
 */
public class StudentAction extends ActionSupport {
    private Student studentObj;

    public Student getStudentObj() {
        return studentObj;
    }

    public void setStudentObj(Student studentObj) {
        this.studentObj = studentObj;
    }
    
   public String execute() throws Exception {  
            setStudentObj(getStudentObj()); 
            
             DBUtils dbutil = new DBUtils();
           
            dbutil.addStudent(getStudentObj());
            return SUCCESS;  
    } 
    
}
