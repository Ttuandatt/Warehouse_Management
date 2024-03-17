/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.LoginController;

public class main {
    public static void main(String[] args){
        LoginView view = new LoginView();
        view.giaoDienLogin();
        LoginController control = new LoginController(view);
    } 
} 
