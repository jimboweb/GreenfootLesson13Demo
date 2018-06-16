import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    int score = 0;
    GreenfootImage boardImage;
    int width;
    int height = 60;
    GreenWorld myWorld;
    int lives = 3; //step 0
    GreenfootImage playerImage; //step 1 
    int livesX;       //step 3
    int livesSpacing; // step 3
    public Scoreboard(){
        playerImage = new Player().getImage(); //step 2
    }
    
    public void addedToWorld(World w){
        myWorld = (GreenWorld)w;
        width = myWorld.getWidth();
        livesX = (int)(width * 0.6);                         // step 4
        livesSpacing = (int)(playerImage.getWidth() * 1.2);  // step 4
        drawBoard();
    }
        
    public void addScore(int amount){
        score+=amount;
    }
    
    public void drawBoard(){ // step 7
        boardImage = new GreenfootImage(width, height);
        boardImage.setColor(Color.BLACK);
        boardImage.fillRect(0,0,width,height);
        setImage(boardImage);
    }
    
    public void drawScore(){
        boardImage.setColor(Color.RED);
        boardImage.setFont(new Font("Arial", 24));
        boardImage.drawString("Score: " + score, 20, 40);
    }
    
    public void drawLives(){ //step 5
        for(int i=0;i<lives;i++){
            int xPos = livesX + livesSpacing * i;
            int yPos = height/2;
            boardImage.drawImage(playerImage, xPos, yPos);
        }
    }
    
    public void loseLife(){ // step 6
        if(lives>0){
            lives--;
        } else {
            myWorld.endGame();
        }
    }
    
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drawBoard();
        drawScore();
        drawLives();
    }    
}
