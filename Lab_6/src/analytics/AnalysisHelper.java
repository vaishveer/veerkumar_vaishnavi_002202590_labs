/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

/**
 *
 * @author harshalneelkamal
 */

import data.DataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import model.Comment;
import model.Post;
import model.User;


public class AnalysisHelper {
    //Find Average number of likes per comment.
    //TODO
    public void getAverageLikesPerComments() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        int likeNumber = 0;
        int commentNumber = comments.size();
        for (Comment c : comments.values()) {
            likeNumber += c.getLikes();
        }
        
        System.out.println("Average number of likes per comments: " + likeNumber / commentNumber);
            
    }
    
    public void getMaxLikeCommentPost(){
        DataStore data=DataStore.getInstance();
        Comment commenrWithMaxLikes= null;
        
        for(Comment c:data.getComments().values())
        {
            if(commenrWithMaxLikes == null)
            {
                commenrWithMaxLikes=c;
            }
            if(c.getLikes() > commenrWithMaxLikes.getLikes())
            {
                commenrWithMaxLikes =c;
            }
        }
        
        int postID= commenrWithMaxLikes.getPostId();
        
        System.out.println("Q2: post with most likes per comment" + data.getPosts().get(postID).getPostId());//finds post object using the post id and then its actual post id
    }
    
    public void getPostWithMostComments(){
        DataStore data=DataStore.getInstance();
        Post postWithMostComments= null;
        for(Post p:data.getPosts().values())
        {
            if(postWithMostComments == null)
            {
                postWithMostComments=p;
            }
            if(p.getComments().size() > postWithMostComments.getComments().size())
            {
                postWithMostComments=p;
            }
        }
        System.out.println("Q3: post with most comments" + postWithMostComments.getPostId()); //gives post id with most comments
    }
    
    public void getPassiveUsers(){
        
        DataStore data= DataStore.getInstance();
        HashMap<Integer,Integer>postNumbers=new HashMap<Integer,Integer>();
        
        for(Post p: data.getPosts().values())
        {
            int userID=p.getUserId();
            if(postNumbers.containsKey(userID))
            {
                postNumbers.put(userID, postNumbers.get(userID)+1);
            }
            else
            {
                postNumbers.put(userID,1);
            }
        }
        
        ArrayList<User> users=new ArrayList(data.getUsers().values());
        Collections.sort(users,new UserMapComparator(postNumbers));
        
        System.out.println("Q4 the following users have the least posts: ");
        
        for(int i=0;i<5;i++)
        {
            System.out.println(users.get(i)+ ", - Post count: " + postNumbers.get(users.get(i).getId()));
        }
    }
    
    public void getPassiveCommentUsers()
    {
        DataStore data=DataStore.getInstance();
        HashMap<Integer,Integer>commentNumbers= new HashMap<Integer,Integer>();//map of userid and no of comments
        
        for(Comment c:data.getComments().values())
        {
            int userID=c.getUserId();
            if(commentNumbers.containsKey(userID))
            {
                commentNumbers.put(userID, commentNumbers.get(userID)+1);
            }
            else
            {
                commentNumbers.put(userID, 1);
            }
        }
        
        ArrayList<User> users =new ArrayList(data.getUsers().values());
        
        Collections.sort(users,new UserMapComparator(commentNumbers));//sort based on comparator object based on comment numbers
        
        System.out.println("Q5 the following users have the least comments: ");
        
        for(int i=0;i<5;i++)
        {
            System.out.println(users.get(i)+ ", - Comment count: " + commentNumbers.get(users.get(i).getId()));
        }
    }
    
    public void getPassiveAndActiveOverallUsers()
    {
        DataStore data=DataStore.getInstance();
        HashMap<Integer,Integer>overallNumbers= new HashMap<Integer,Integer>();//map of userid and overall no
        
        for(Comment c:data.getComments().values())
        {
            int userID=c.getUserId();
            if(overallNumbers.containsKey(userID))
            {
                overallNumbers.put(userID, overallNumbers.get(userID)+1 + c.getLikes());
            }
            else
            {
                overallNumbers.put(userID, 1 + c.getLikes());
            }
        }
        
        for(Post p:data.getPosts().values())
        {
            int userID=p.getUserId();
            if(overallNumbers.containsKey(userID))
            {
                overallNumbers.put(userID, overallNumbers.get(userID) + 1);
            }
            else
            {
                overallNumbers.put(userID, 1);
            }
        }
        
        ArrayList<User> users =new ArrayList(data.getUsers().values());
        
        Collections.sort(users,new UserMapComparator(overallNumbers));
        
        System.out.println("Q6 the following users have been passive overall: ");
        
        for(int i=0;i<5;i++)
        {
            System.out.println(users.get(i)+ ", - Overall count: " + overallNumbers.get(users.get(i).getId()));
        }
        
        System.out.println("Q7 the following users have been active overall ");
        
        for(int i=users.size()-1; i>users.size()-6; i--)
        {
            System.out.println(users.get(i)+ ", - Overall count: " + overallNumbers.get(users.get(i).getId()));
        }
    }
    
}
