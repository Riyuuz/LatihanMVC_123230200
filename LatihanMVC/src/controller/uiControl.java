/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author rakha
 */
import model.koneksikan;
import model.buku;
import java.util.List;

public class uiControl {
    
    public List<buku> getdata(){
        koneksikan kon = new koneksikan();
        return kon.getbuku();
    }
    
    public void inputbuku(buku bukus){
        koneksikan kon = new koneksikan();
        kon.insertBuku(bukus);
        
    }
    
    public void upBuku (buku bukus){
        koneksikan kon = new koneksikan();
        kon.UpdateBuku(bukus);
    }
    
    public void delbuk (int id){
        koneksikan kon = new koneksikan();
        kon.deletion(id);
    }
    
    


}
