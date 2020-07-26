/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author USER
 */
public class Student {
    
    private String ID;
    private String Name;
    private String Father_name;
    private String DOB;
    private String Sex;
    private String Email;
    private String Mobile;
    private String Semester;
    private String Dept;
    private String User;
    private String Pass;

    Student(String ID, String Name, String Father_name, String DOB, String Sex, String Email, String Mobile, String Semester, String Dept, String User, String Pass) {
        this.ID = ID;
        this.Name = Name;
        this.Father_name = Father_name;
        this.DOB = DOB;
        this.Sex = Sex;
        this.Email = Email;
        this.Mobile = Mobile;
        this.Semester = Semester;
        this.Dept = Dept;
        this.User = User;
        this.Pass = Pass;
    }

//    Student() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Father_name
     */
    public String getFather_name() {
        return Father_name;
    }

    /**
     * @param Father_name the Father_name to set
     */
    public void setFather_name(String Father_name) {
        this.Father_name = Father_name;
    }

    /**
     * @return the DOB
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the Sex
     */
    public String getSex() {
        return Sex;
    }

    /**
     * @param Sex the Sex to set
     */
    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Mobile
     */
    public String getMobile() {
        return Mobile;
    }

    /**
     * @param Mobile the Mobile to set
     */
    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    /**
     * @return the Semester
     */
    public String getSemester() {
        return Semester;
    }

    /**
     * @param Semester the Semester to set
     */
    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    /**
     * @return the Dept
     */
    public String getDept() {
        return Dept;
    }

    /**
     * @param Dept the Dept to set
     */
    public void setDept(String Dept) {
        this.Dept = Dept;
    }

    /**
     * @return the User
     */
    public String getUser() {
        return User;
    }

    /**
     * @param User the User to set
     */
    public void setUser(String User) {
        this.User = User;
    }

    /**
     * @return the Pass
     */
    public String getPass() {
        return Pass;
    }

    /**
     * @param Pass the Pass to set
     */
    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    
}
