/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author fugalde
 */
public class JDesktopPaneImg extends JDesktopPane {
    
    ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/logo.jpg"));
    //Image image = icon.getImage();
    //Image newimage = image.getScaledInstance(1500, 1000, Image.SCALE_SMOOTH);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (this.getWidth() - icon.getImage().getWidth(null)) / 2;
        int y = (this.getHeight() - icon.getImage().getHeight(null)) / 2;
        g.drawImage(icon.getImage(), x, y, this);
    }
}
    
