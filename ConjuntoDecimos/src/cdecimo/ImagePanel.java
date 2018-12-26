/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdecimo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author sergio
 */
public class ImagePanel extends JPanel{
    private BufferedImage image;
    
    public ImagePanel() throws IOException{
        File patos = new File("dospatos.png");
        image = ImageIO.read(patos);      
        BufferedImage resized = resizeImage(image, BufferedImage.TYPE_INT_ARGB);
        resized.createGraphics();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0,0,this);
    }
    
    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
	BufferedImage resizedImage = new BufferedImage(125, 129, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, 125, 129, null);
	g.dispose();
		
	return resizedImage;
    }
}
