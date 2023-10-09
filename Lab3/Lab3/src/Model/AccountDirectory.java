/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vaish
 */
public class AccountDirectory {
    
    private ArrayList<Account> accountlist;

    public AccountDirectory() {
        //create new object of arraylist since it is not primitive datatype
        //this. ensures that accountlist is class level one 
        this.accountlist=new ArrayList<>();
    }
    
    public ArrayList<Account> getAccountlist() {
        return accountlist;
    }

    public void setAccountlist(ArrayList<Account> accountlist) {
        this.accountlist = accountlist;
    }
    
    public Account addAccount(){
        Account account=new Account(); //create new object of account becasue it has all the atributes/variables we need
        accountlist.add(account);
        return account;
    }
    
    public void deleteAccount(Account account){
        accountlist.remove(account);
    }
    
    public Account searchAccount(String accountnumber){
        for(Account account:accountlist){
            if(account.getAccountnumber().equals(accountnumber))
                return account;
        }
        return null;
    }
}
