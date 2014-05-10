package Model;

import java.util.Observable;
import java.util.Vector;

import Model.Interface.IActor;

public class Logic extends Observable implements Runnable {
	private Vector<IActor> actors;
	private boolean isGameRunning;
	private long last = 0;
	private double delta = 0;

	public Logic() {
		this.actors = new Vector<IActor>();
	}

	public void addActor(IActor actor){
		actors.add(actor);
	}

	public void setGameRunning(boolean isGameRunning) {
		this.isGameRunning = isGameRunning;
	}

	@Override
	public void run() {
		last = System.nanoTime();
		while (true) {
			try {
				if(isGameRunning){
					long currentTime = System.nanoTime();
					delta = (currentTime - last)/1000000.00;
//					System.out.println(((long) 1e9)/delta); => fps
					last = currentTime;
					for (IActor actor : actors) {
						actor.actuate(delta);
					}
					for (int i = 0; i < actors.size(); i++) {
						for (int j = i+1; j < actors.size(); j++) {
							IActor s1 = actors.elementAt(i);
							IActor s2 = actors.elementAt(j);
							s1.checkCollision(s2);
						}
					}
					setChanged();
					notifyObservers();
				}
				Thread.sleep(15);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
