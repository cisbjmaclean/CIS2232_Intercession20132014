/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Student;
import forms.StudentForm;
import java.io.StringReader;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author bjmaclean
 */
public class AddStudent extends Action {

    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        ActionForward findForward = mapping.findForward("main");

        StudentForm formStudent = (StudentForm) request.getAttribute("studentForm");

        Student newStudent = new Student();
        BeanUtils.copyProperties(newStudent, formStudent);

        System.out.println("newStudent.firstName=" + newStudent.getFirstName());
        System.out.println("newStudent.lastName=" + newStudent.getLastName());
        System.out.println("newStudent.studentId=" + newStudent.getStudentId());
        System.out.println("newStudent.dob=" + newStudent.getDob());

        //Student.fileWrite(null, newStudent.fileOutputString());
        boolean successAdd = newStudent.saveStudent();
        Student.getStudents().put(newStudent.getStudentId(), newStudent);

        ActionMessages messages = new ActionMessages();
        if (successAdd) {
            messages.add("message1", (new ActionMessage("label.student.added.successfully")));
        } else {
            messages.add("error", (new ActionMessage("label.student.added.error")));
        }
        saveMessages(request, messages);

        //**********************************************************************
        //**********************************************************************
        //**********************************************************************
        //http://www.vogella.com/tutorials/JAXB/article.html
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        StringWriter sw = new StringWriter();
        m.marshal(newStudent, sw);
        String xmlStudent = sw.toString();
        System.out.println("xmlEncodedStudent=" + xmlStudent);
        //**********************************************************************
        //**********************************************************************

        //Unmarshall back for testing
        Unmarshaller um = context.createUnmarshaller();
        Student backStudent = (Student) um.unmarshal(new StringReader(xmlStudent));
        System.out.println("Student back from xml:" + backStudent.toString());

        //**********************************************************************
        //**********************************************************************
        //**********************************************************************
        return findForward;

    }

}
