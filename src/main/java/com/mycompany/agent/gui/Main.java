/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.agent.gui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public EntityManager em;

    public static void main(String[] args) {
        new authorization().setVisible(true);
    }

    public void Session() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_agent_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
        
       
    }

}
