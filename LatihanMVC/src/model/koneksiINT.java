/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

public interface koneksiINT {
    public void insertBuku (buku datas);
    public void UpdateBuku(buku datas);
    public void deletion(int id);
    public List<buku> getbuku();
    
}
