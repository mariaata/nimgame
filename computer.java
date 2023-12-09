import java.util.Random;

public class Computer{
    
    private int mode;
    private int choice;
    
    Random r = new Random ();

    public Computer(int m){
        mode = m;
        choice = -1;
    }
    
    public void move(int marblesLeft){
        int [] pile= {63,31,15,7,3};

        boolean flag = false;

        for (int i=0; i<pile.length; i++){
            if (marblesLeft==pile[i]){
                flag=true;
            }
        }

        if(mode==1||flag==true){
            choice = r.nextInt(marblesLeft/2)+1;
        } else if (mode==2 && flag==false){
            for(int i=0;i<pile.length;i++){
                if(marblesLeft>pile[i]){
                    choice = marblesLeft - pile[i];
                }
            }
        }
    }
    public int getChoice(){
        return choice;
    }
}


