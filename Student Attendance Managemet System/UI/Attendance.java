/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


public class Attendance {
    private String date;
    private String s_id;
    private String t_id;
    private String c_id;
    private String sem_id;
    private String d_name;
    
    public Attendance(String date, String s_id, String t_id, String c_id, String sem_id, String d_name) {
        this.date = date;
        this.s_id = s_id;
        this.t_id = t_id;
        this.c_id = c_id;
        this.sem_id = sem_id;
        this.d_name = d_name;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the s_id
     */
    public String getS_id() {
        return s_id;
    }

    /**
     * @param s_id the s_id to set
     */
    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    /**
     * @return the t_id
     */
    public String getT_id() {
        return t_id;
    }

    /**
     * @param t_id the t_id to set
     */
    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    /**
     * @return the c_id
     */
    public String getC_id() {
        return c_id;
    }

    /**
     * @param c_id the c_id to set
     */
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    /**
     * @return the sem_id
     */
    public String getSem_id() {
        return sem_id;
    }

    /**
     * @param sem_id the sem_id to set
     */
    public void setSem_id(String sem_id) {
        this.sem_id = sem_id;
    }

    /**
     * @return the d_name
     */
    public String getD_name() {
        return d_name;
    }

    /**
     * @param d_name the d_name to set
     */
    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

}