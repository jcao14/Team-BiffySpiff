import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

/** Method to set the blue to 0 */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
	pixelObj.setGreen(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

    public void mirrorVerticalRighttoLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
     
    }
  }
  
 public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel upPixel = null;
    Pixel downPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        upPixel = pixels[row][col];
	downPixel = pixels[height - 1 - row][col];
        upPixel.setColor(downPixel.getColor());
      }
    } 
  }
 public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel upPixel = null;
    Pixel downPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        upPixel = pixels[row][col];
        downPixel = pixels[height - 1 - row][col];
        downPixel.setColor(upPixel.getColor());
      }
    } 
  }

    public void mirrorDiagonal(){
	 Pixel[][] pixels = this.getPixels2D();
	 Pixel Pixel_A = null;
	 Pixel Pixel_B = null;
	 int maxSize = pixels.length;
	 if (maxSize > pixels[0].length){
	     maxSize = pixels[0].length;
	 }
	 
	 for (int row = 0; row < maxSize; row++)
	     {
		 for (int col = 0; col < maxSize; col++)
		     {
			 Pixel_A = pixels [row][col];
			 Pixel_B = pixels[col][row];
			 Pixel_A.setColor (Pixel_B.getColor());
		     }
	     }
}


    
    

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorArms()
  {
    int mirrorPoint = 193;
    Pixel upPixel = null;
    Pixel downPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 155; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 106; col < 168; col++)
      {
        
        upPixel = pixels[row][col];      
        downPixel = pixels [mirrorPoint - row + mirrorPoint] [col];
        downPixel.setColor(upPixel.getColor());
      }
    }
  

    Pixel upPixel2 = null;
    Pixel downPixel2 = null;
    
    // loop through the rows
    for (int row = 173; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
	for (int col = 233; col < 296; col++)
      {
        
        upPixel2 = pixels[row][col];      
        downPixel2 = pixels [mirrorPoint - row + mirrorPoint] [col];
        downPixel2.setColor(upPixel2.getColor());
      }
    }
  }

 public void mirrorGull()
  {
    int mirrorPoint = 340;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 230; row < 340; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 230; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

 public void copyB(Picture fromPic, 
		   int startRow, int startCol,int endRow, int endCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < endRow; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < endCol;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }


  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copyB(flower1,0,0,0,0);
    this.copyB(flower2,100,0,200,100);
    this.copyB(flower1,200,0,300,200);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copyB(flowerNoBlue,300,0,400,100);
    this.copyB(flower1,400,0,400,200);
    this.copyB(flower2,500,0,300,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }


public void myCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    Picture flower3 = new Picture("nigel.jpg");
    this.copyB(flower1,0,0,0,0);
    this.copyB(flower2,100,0,200,100);
    this.copyB(flower1,200,0,300,200);
    this.copyB(flower3,300,0,400,300);
    Picture flowerNoBlue = new Picture(flower3);
    flowerNoBlue.zeroBlue();
    this.copyB(flowerNoBlue,300,0,400,100);
    this.copyB(flower1,400,0,400,200);
    this.copyB(flower2,500,0,300,0);
    this.copyB(flower3,600,200,500,200);
    this.mirrorVertical();
 
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

 public void edgeDetectionB(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }

    Pixel upPixel = null;
    Pixel downPixel = null;
    Color downColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        upPixel = pixels[row][col];
        downPixel = pixels[row][col+1];
        downColor = downPixel.getColor();
        if (upPixel.colorDistance(downColor) > 
            edgeDist)
          upPixel.setColor(Color.BLACK);
        else
          upPixel.setColor(Color.WHITE);
      }
    }

  }

 public void negate(){
	Pixel[][] pixels = this.getPixels2D();
	for (Pixel[] rowArray : pixels)
	    {
		for (Pixel pixelObj : rowArray)
		    {
			pixelObj.setBlue(255- pixelObj.getBlue());
			pixelObj.setRed(255- pixelObj.getRed());
			pixelObj.setGreen(255- pixelObj.getGreen());
		    }
	    }
    }
 public void grayscale(){
	Pixel[][] pixels = this.getPixels2D();
	for (Pixel[] rowArray : pixels)
	    {
		for (Pixel pixelObj : rowArray)
		    {
			int ave = pixelObj.getBlue()+  pixelObj.getRed()+ pixelObj.getGreen();
			ave = ave/3;
			pixelObj.setBlue(ave);
			pixelObj.setRed(ave);
			pixelObj.setGreen(ave);
		    }
	    }
    }
 public void fixUnderwater(){
	Pixel[][] pixels = this.getPixels2D();
	for (Pixel[] rowArray : pixels)
	    {
		for (Pixel pixelObj : rowArray)
		    {
			pixelObj.setBlue( pixelObj.getBlue()-50);
			pixelObj.setRed(100+ pixelObj.getRed());
			pixelObj.setGreen(-25+ pixelObj.getGreen());
		    }
	    }
    }

  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
