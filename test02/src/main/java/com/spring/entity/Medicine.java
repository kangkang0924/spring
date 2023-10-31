package com.spring.entity;

/**
 * @author ablaze
 * @Date: 2023/10/23/15:33
 */
public class Medicine {

    private int id;
    private String medname;
    private String mtype;

    public void startMedicine() {
        System.out.println("start taking medicine");
    }
    public void endMedicine() {
        System.out.println("end taking medicine");
    }


    public Medicine() {
    }

    public Medicine(String medname, String mtype) {
        this.medname = medname;
        this.mtype = mtype;
    }

    public Medicine(int id, String medname, String mtype) {
        this.id = id;
        this.medname = medname;
        this.mtype = mtype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medname='" + medname + '\'' +
                ", mtype='" + mtype + '\'' +
                '}';
    }
}
