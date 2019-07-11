package edu.duke.compsci290.goodfoodgonebad.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by nazligungor on 25.04.2018.
 */

@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)

    public int userid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "brand")
    public String brand;

    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "expiration")
    public Date expiration;
    @TypeConverters(DataConverter.class)
    @ColumnInfo(name = "purchase")
    public Date purchase;

    public int getUserid(){
        return userid;
    }

    public void setUserid(int uid){
        this.userid = uid;
    }

    public String getItemName(){
        return name;
    }

    public void setItemName(String n){
        this.name = n;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String n){
        this.brand = n;
    }

    public Date getExpiration(){
        return expiration;
    }

    public void setExpiration(Date d){
        this.expiration = d;
    }

    public Date getPurchase(){
        return purchase;
    }

    public void setPurchase(Date d){
        this.purchase = d;
    }

    public Product(){}
    public Product(String name,String brand,Date exp, Date pur){
        //this.userid = id;
        this.name = name;
        this.brand = brand;
        this.expiration = exp;
        this.purchase = pur;
    }

    public Product(Product p){
        this.userid = p.getUserid();
        this.name = p.getItemName();
        this.brand = p.getBrand();
        this.expiration = p.getExpiration();
        this.purchase = p.getPurchase();
    }

}
