/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author vaish
 */
public class Account {
    private String routingnumber;
    private String accountnumber;
    private String bankName;
    private int balance;
    private Date createdon;
    
    //constructor has no return type, whenever you are creating object of class default constructor is called

    public Account() {
        this.createdon=new Date(); //it is set every time a new object for class is created so no need of setter for it
    }
    
    

    public String getRoutingnumber() {
        return routingnumber;
    }

    public void setRoutingnumber(String routingnumber) {
        this.routingnumber = routingnumber;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getCreatedon() {
        return createdon;
    }
@Override //telling java that below method will be used
    public String toString(){
        return bankName;
    }
}
