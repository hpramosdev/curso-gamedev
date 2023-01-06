package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.*;

public class World {
	
	public static List <Blocks> blocos = new ArrayList <Blocks>();
	
	public World() {
		for (int x = 0; x < 15 * 2; x++) {
			blocos.add(new Blocks(x * 32, 0));
		}

		for (int x = 0; x < 15 * 2; x++) {
			blocos.add(new Blocks(x * 32, 480 - 32));
		}
		
		for (int y = 0; y < 15 * 2; y++) {
			blocos.add(new Blocks(0, y * 32));
		}
		
		for (int y = 0; y < 15 * 2; y++) {
			blocos.add(new Blocks(640 - 32, y * 32));
		}
	}
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i < blocos.size(); i++) {
			Blocks blocoAtual = blocos.get(i);
			if (blocoAtual.intersects(new Rectangle(x,y,32,32))) {
				return false;
			}
		}		
		return true;
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < blocos.size(); i++) {
			blocos.get(i).render(g);
		}		
	}
}
