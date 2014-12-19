package com.tatiana.UseLWJGL.util.screen;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.tatiana.UseLWJGL.util.ParamsDisplay;

public class TakeScreen {

	int width;
	int height;
	int bpp;
	ByteBuffer screenBuffer;
	String format = "PNG";
	
	ParamsDisplay paramsDisplay = new ParamsDisplay();

	
	public void savingScreen() {
		//getting screen
		/*GL11.glReadBuffer(GL11.GL_FRONT);
		width = Display.getDisplayMode().getWidth();
		height = Display.getDisplayMode().getHeight();
		bpp = 4;
		
		screenBuffer = BufferUtils.createByteBuffer(width * height * bpp);
		
		GL11.glReadPixels(0, 0, width, height, GL11.GL_RGBA, GL11.GL_BYTE, screenBuffer);
		
		File file = new File("save/screen.png"); // The file to save to.
		BufferedImage image = new BufferedImage(width, height, 
	            BufferedImage.TYPE_INT_ARGB);
	    for(int i = 0; i < width; i++)
	        for(int j = 0; j < height; j++)
	        {
	            int bufferPlace = (i + (width * j)) * 4;
	            byte red = screenBuffer.get(bufferPlace);
	            byte green = screenBuffer.get(bufferPlace + 1);
	            byte blue = screenBuffer.get(bufferPlace + 2);
	            int color = (0xFF << 24) | // For a completely opaque image.
	                        (red << 16) |
	                        (green << 8) |
	                        (blue);
	            image.setRGB(i, height - (j + 1), color);
	        }
	    try {
	        ImageIO.write(image, format, file);
	    } catch (IOException e) { e.printStackTrace(); }*/
		
		int WIDTH = Display.getDisplayMode().getWidth();
		int HEIGHT = Display.getDisplayMode().getHeight();
		File file = new File("save/screen.png"); // The file to save to.
		int[] pixels = new int[WIDTH * HEIGHT];
        int bindex;
        // allocate space for RBG pixels
        ByteBuffer fb = ByteBuffer.allocateDirect(WIDTH * HEIGHT * 3);

        // grab a copy of the current frame contents as RGB
        GL11.glReadPixels(0, 0, WIDTH, HEIGHT, GL11.GL_RGB, GL11.GL_BYTE, fb);

        BufferedImage imageIn = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // convert RGB data in ByteBuffer to integer array
        for (int i=0; i < pixels.length; i++) {
            bindex = i * 3;
            pixels[i] =
                ((fb.get(bindex) << 16))  +
                ((fb.get(bindex+1) << 8))  +
                ((fb.get(bindex+2) << 0));
        }
        //Allocate colored pixel to buffered Image
        imageIn.setRGB(0, 0, WIDTH, HEIGHT, pixels, 0 , WIDTH);

        //Creating the transformation direction (horizontal)
        AffineTransform at =  AffineTransform.getScaleInstance(1, -1);
        at.translate(0, -imageIn.getHeight(null));

        //Applying transformation
        AffineTransformOp opRotated = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage imageOut = opRotated.filter(imageIn, null);

        try {//Try to screate image, else show exception.
            ImageIO.write(imageOut, format , file);
        }
        catch (Exception e) {
            System.out.println("ScreenShot() exception: " +e);
        }
	}
}
