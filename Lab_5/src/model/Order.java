/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author vaish
 */
public class Order {
    
    ArrayList<OrderItem> orderItemlist;

    public Order() {
        
        this.orderItemlist= new ArrayList<OrderItem>();
    }

    public ArrayList<OrderItem> getOrderItemlist() {
        return orderItemlist;
    }

    public void setOrderItemlist(ArrayList<OrderItem> orderItemlist) {
        this.orderItemlist = orderItemlist;
    }
    
    public void addNewOrderItem(Product product,double price,int quantity){
        OrderItem orderitem=new OrderItem(product,price,quantity);
        orderItemlist.add(orderitem);
       
    }
    
    public void deleteItem(OrderItem item){
        this.orderItemlist.remove(item);
       
    }
    
    public OrderItem findProduct(Product product)
    {
        for (OrderItem oi: this.getOrderItemlist())
        {
            if(oi.getProduct().equals(product))
            {
                return oi;
            }
        }
        return null;
    }
}
