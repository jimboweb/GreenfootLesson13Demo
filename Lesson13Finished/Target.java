import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Actor
{
    GreenWorld myWorld;
    int pointValue = 5;
    public void addedToWorld(World w){
        myWorld = (GreenWorld)w;
    }
    /**
     * Act - do whatever the Target wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Player.class)){
            myWorld.addScore(5);
            myWorld.removeObject(this);
        }
    }    
}
