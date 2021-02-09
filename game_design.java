import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Frame;

public class game_design extends Frame implements KeyListener{
	int score;
	int life;
	int pk_code;
	int pk_char;
	int snake_x;
	int snake_y;
	int step_size;
	int food_x;
	int food_y;
	game_design()
	{
		food_x=(int)(Math.random()*330+60);
		food_y=(int)(Math.random()*330+60);
		step_size=5;
		snake_x=100;
		snake_y=100;
		score=0;
		life=3;
		setVisible(true);
		setBounds(100,100,500,500);
		setTitle("Snake Game");
		addKeyListener(this);
	}
	@Override
	public void paint(Graphics g)
	{
		if(pk_code==37)
		{
		snake_x-=step_size;
		}
		else if(pk_code==39)
		{
		snake_x+=step_size;
		}
		else if(pk_code==38)
		{
		snake_y-=step_size;
		}
		else if(pk_code==40)
		{
		snake_y+=step_size;
		}
		if(snake_x<=50 || snake_x>390 || snake_y<=50 || snake_y>=390)
		{
			snake_x=100;
			snake_y=100;
			life=life-1;
			if(life<0)
			{
				g.drawString("Game Over",250,250);
				try {
					Thread.sleep(1000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				System.exit(0);
			}
		}
		g.drawOval(snake_x, snake_y, 10, 10);
		g.fillOval(food_x, food_y, 10, 10);
		g.drawRect(50,50,400,400);
		g.drawString("Score= "+ score+"Life ="+ life , 250, 470);
		try {
			Thread.sleep(100);
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
			repaint();
			}
	@Override
	public void keyPressed(KeyEvent e) {
	pk_code=e.getKeyCode();
	}
	@Override
	public void keyReleased(KeyEvent e) {
	repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	
}



