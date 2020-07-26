/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


public class Teacherinfo {
    private String teacher_id;
    private String teacher_name;
    private String teacher_mobile;
    private String teacher_email;
    private String teacher_pass;

    public Teacherinfo(String teacher_id, String teacher_name, String teacher_mobile, String teacher_email, String teacher_pass) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_mobile = teacher_mobile;
        this.teacher_email = teacher_email;
        this.teacher_pass = teacher_pass;
    }

    /**
     * @return the teacher_id
     */
    public String getTeacher_id() {
        return teacher_id;
    }

    /**
     * @param teacher_id the teacher_id to set
     */
    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    /**
     * @return the teacher_name
     */
    public String getTeacher_name() {
        return teacher_name;
    }

    /**
     * @param teacher_name the teacher_name to set
     */
    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    /**
     * @return the teacher_mobile
     */
    public String getTeacher_mobile() {
        return teacher_mobile;
    }

    /**
     * @param teacher_mobile the teacher_mobile to set
     */
    public void setTeacher_mobile(String teacher_mobile) {
        this.teacher_mobile = teacher_mobile;
    }

    /**
     * @return the teacher_email
     */
    public String getTeacher_email() {
        return teacher_email;
    }

    /**
     * @param teacher_email the teacher_email to set
     */
    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    /**
     * @return the teacher_pass
     */
    public String getTeacher_pass() {
        return teacher_pass;
    }

    /**
     * @param teacher_pass the teacher_pass to set
     */
    public void setTeacher_pass(String teacher_pass) {
        this.teacher_pass = teacher_pass;
    }
}
