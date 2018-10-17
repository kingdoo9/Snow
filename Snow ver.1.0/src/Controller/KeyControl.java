 package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import Constants.GConstants;
import Model.GCharacter;

public class KeyControl implements KeyListener{
	
	private int jump, fall=2, num;
	private int Who=0, Uobj;
	boolean isKeyLeft = false;
	boolean isKeyRight = false;
	int GameOver = 0;
	private int nKeySpace = 0; 
	GCharacter Hero = new GCharacter();
	
	public KeyControl(){
		Hero.initkey();
		Hero.setJump(-GConstants.Jump);
	    this.jump = Hero.getJump();
	}
	
	public int getPositionX(){ return Hero.getPosX(); }
	public int getPositionY(){ return Hero.getPosY(); }
	
	@Override 
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_LEFT){ 			
			isKeyLeft = true;
	    } 
	    if (e.getKeyCode() == KeyEvent.VK_RIGHT){   
	    	isKeyRight = true; 
	    } 
	    if (e.getKeyCode() == KeyEvent.VK_SPACE && nKeySpace < GConstants.JumpCount){ 
	        nKeySpace++; 
	        jump = -GConstants.Jump; 
	    }
	    if (e.getKeyCode() == KeyEvent.VK_R){
	    	Hero.initkey();
	    }
	} 

	@Override 
	public void keyReleased(KeyEvent e){ 

		if (e.getKeyCode() == KeyEvent.VK_LEFT){ 

			isKeyLeft = false;
		} 
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){ 
			
	         isKeyRight = false; 
		} 
	} 

	@Override 
	public void keyTyped(KeyEvent e){}
	
	public int keyDraw(){
		if (nKeySpace > 0){ 
				if (isKeyLeft){
	            	if(Hero.getPosX() >= 0 && is_LLocation_ok(GConstants.GObject)==0){
	            		Hero.setPosX(Hero.getPosX() - GConstants.Speed);
	            	}else if(Who == 2){
	            		GameOver = 1;
					}else if(Who == 3){
						GameOver = 2;
					}
	            }
	            if (isKeyRight){ 
	            	if((Hero.getPosX() +50) <= GConstants.FrameWidth && is_RLocation_ok(GConstants.GObject)==0){
	            		Hero.setPosX(Hero.getPosX() + GConstants.Speed);
	            	}else if(Who == 2){
	            		GameOver = 1;
	            	}else if(Who == 3){
						GameOver = 2;
					}
	            }
			Uobj = is_DLocation_ok(GConstants.GObject);
			if(Uobj != 0 && jump < 0){
				if(Who == 2){
					GameOver = 1;
				}else if(Who == 3){
					GameOver = 2;
				}else{
					Hero.setPosY(GConstants.GObject.elementAt(Uobj).getPosY()+50);
				}
			}
			
			Hero.setPosY(Hero.getPosY()+ jump);// 점프 
			Uobj = is_ULocation_ok(GConstants.GObject);
            if (Uobj != 0 && jump > 0){
				if(Who == 2){
					GameOver = 1;
				}else if(Who == 3){
					GameOver = 2;
				}else{
	            	Hero.setPosY(GConstants.GObject.elementAt(Uobj).getPosY()-50);
	                jump = -GConstants.Jump;// 점프 초기값으로
	                nKeySpace = 0;
				}

            }
            
			jump += 1;// 점점 느려지다가 점점 빨라짐  

                 
		}else if((Hero.getPosX() > (GConstants.GObject.elementAt(Uobj).getPosX()+50) || (Hero.getPosX()+50) < GConstants.GObject.elementAt(Uobj).getPosX())
				&& Hero.getPosY()<600){
			 if (isKeyLeft){
	            	if(Hero.getPosX() >= 0 && is_LLocation_ok(GConstants.GObject)==0){
	            		Hero.setPosX(Hero.getPosX() - GConstants.Speed);
	            	}else if(Who == 2){
	            		GameOver = 1;
	            	}else if(Who == 3){
						GameOver = 2;
					}
	            }
	            if (isKeyRight){ 
	            	if((Hero.getPosX() +50) <= GConstants.FrameWidth && is_RLocation_ok(GConstants.GObject)==0){
	            		Hero.setPosX(Hero.getPosX() + GConstants.Speed);
	            	}else if(Who == 2){
	            		GameOver = 1;
	            	}else if(Who == 3){
						GameOver = 2;
					}
	            } 
			

			Hero.setPosY(Hero.getPosY() + fall);
			fall += 1;
			 
		}else{
            if (isKeyLeft){
            	if(Hero.getPosX() >= 0 && is_LLocation_ok(GConstants.GObject) == 0){
            		Hero.setPosX(Hero.getPosX() - GConstants.Speed);
            	}else if(Who == 2){
            		GameOver = 1;
            	}else if(Who == 3){
					GameOver = 2;
				}
            }
            if (isKeyRight){ 
            	if((Hero.getPosX() +50) <= GConstants.FrameWidth && is_RLocation_ok(GConstants.GObject)==0){
            		Hero.setPosX(Hero.getPosX() + GConstants.Speed);
            	}else if(Who == 2){
            		GameOver = 1;
            	}else if(Who == 3){
					GameOver = 2;
				}
            } 
		}
		Uobj = is_ULocation_ok(GConstants.GObject);
		if(Uobj != 0){
			if(Who == 2){
				GameOver = 1;
			}else if(Who == 3){
				GameOver = 2;
			}else{
				Hero.setPosY(GConstants.GObject.elementAt(Uobj).getPosY()-50);
				fall = 2;
			}
		}
		return GameOver;
		
	}
	

	
	// 충돌을 처리하는 함수
	public int is_RLocation_ok( Vector<GCharacter> gObject){
		for(GCharacter e : gObject){
			if((Hero.getPosX() + 50) == e.getPosX()){
				if(Hero.getPosY() >= e.getPosY() && Hero.getPosY() < (e.getPosY()+50)
						|| (Hero.getPosY()+50) > e.getPosY() && (Hero.getPosY()+50) <= (e.getPosY()+50)){
					if(e.getName().equals("Spike")){Who = 2;}
					else if(e.getName().equals("Goal")){Who = 3;}
					else{Who = 1;}
					return num;
				}
			}
			num++;
		}
		return 0;
	}
	public int is_LLocation_ok( Vector<GCharacter> gObject){
		num = 0;
		for(GCharacter e : gObject){
			if(Hero.getPosX() == (e.getPosX() + 50)){
				if(Hero.getPosY() >= e.getPosY() && Hero.getPosY() < (e.getPosY()+50)
						|| (Hero.getPosY()+50) > e.getPosY() && (Hero.getPosY()+50) <= (e.getPosY()+50)){
					if(e.getName().equals("Spike")){Who = 2;}
					else if(e.getName().equals("Goal")){Who = 3;}
					else{Who = 1;}
					return num;
				}
			}
			num++;
		}
		return 0;
	}
	public int is_ULocation_ok( Vector<GCharacter> gObject){
		num = 0;
		for(GCharacter e : gObject){
			if((Hero.getPosY()+50) > e.getPosY() && (Hero.getPosY()+50) <= (e.getPosY()+25) ){
				if(Hero.getPosX() >= e.getPosX() && Hero.getPosX() < (e.getPosX()+50)
						|| (Hero.getPosX()+50) > e.getPosX() && (Hero.getPosX()+50) <= (e.getPosX()+50)){
					if(e.getName().equals("Spike")){Who = 2;}
					else if(e.getName().equals("Goal")){Who = 3;}
					else{Who = 1;}
					return num;
				}
			}
			num++;
		}
		return 0;
	}
	public int is_DLocation_ok( Vector<GCharacter> gObject){
		num = 0;
		for(GCharacter e : gObject){
			if(Hero.getPosY() < (e.getPosY()+50) && Hero.getPosY() >= e.getPosY()+25){
				if(Hero.getPosX() >= e.getPosX() && Hero.getPosX() < (e.getPosX()+50)
						|| (Hero.getPosX()+50) > e.getPosX() && (Hero.getPosX()+50) <= (e.getPosX()+50)){
					if(e.getName().equals("Spike")){Who = 2;}
					else if(e.getName().equals("Goal")){Who = 3;}
					else{Who = 1;}
					return num;
				}	
			}
			num++;
		}
		return 0;
	}

	public void reset() {
		Hero.initkey();
		GameOver = 0;
		
	}
}
