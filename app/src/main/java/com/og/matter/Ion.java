package com.og.matter;


public class Ion{
	private float molar;
	private String symbol;
	private int atomic,line;
	private int metalic;
	public Ion(){
		//constractor
	}
	public int getMetalic() {
		return metalic;
	}
	public int getLine() {
		return line;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getAtomic() {
		return atomic;
	}
	public float getMolar() {
		return molar;
	}
	public void Symbol(){
		char tav;
		for(int i=0;i<symbol.length();i++){
    		tav=symbol.charAt(i);
    		switch(tav){
    		case 'A':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'l':
    				this.atomic=13;
    				this.molar=27;
    				this.line=3;
    				this.metalic=1;
    				break;
    			case 'r':
    				this.atomic=18;
    				this.molar=40;
    				this.line=8;
    				this.metalic=1;
    				break;
    			case 's':
    				this.atomic=33;
    				this.molar=(float) 74.9;
    				this.line=5;
    				this.metalic=2;
    				break;
    			case 'g':
    				this.atomic=47;
    				this.molar=(float) 107.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'u':
    				this.atomic=79;
    				this.molar=197;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 't':
    				this.atomic=85;
    				this.molar=210;
    				this.line=7;
    				this.metalic=2;
    				break;
    			case 'c':
    				this.atomic=89;
    				this.molar=227;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'm':
    				this.atomic=95;
    				this.molar=243;
    				this.line=0;
    				this.metalic=1;
    				break;
    				}
    			}
    			else
    				reset();
    		break;
    		case 'B':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=5;
    				this.molar=(float) 10.8;
    				this.line=3;
    				this.metalic=2;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'e':
    				this.atomic=4;
    				this.molar=9;
    				this.line=2;
    				this.metalic=1;
    				break;
    			case 'r':
    				this.atomic=35;
    				this.molar=(float) 79.9;
    				this.line=7;
    				this.metalic=2;
    				break;
    			case 'a':
    				this.atomic=56;
    				this.molar=(float) 137.3;
    				this.line=2;
    				this.metalic=1;
    				break;
    			case 'i':
    				this.atomic=83;
    				this.molar=209;
    				this.line=5;
    				this.metalic=1;
    				break;
    			case 'h':
    				this.atomic=107;
    				this.molar=264;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'k':
    				this.atomic=97;
    				this.molar=247;
    				this.line=0;
    				this.metalic=1;
    				break;
    			}
    			}
    			break;
    		case 'C':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=6;
    				this.molar=12;
    				this.line=4;
    				this.metalic=2;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'a':
    				this.atomic=20;
    				this.molar=(float) 40.1;
    				this.line=2;
    				this.metalic=1;
    				break;
    			case 'o':
    				this.atomic=27;
    				this.molar=(float) 58.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'u':
    				this.atomic=29;
    				this.molar=(float) 63.5;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 's':
    				this.atomic=55;
    				this.molar=(float) 132.9;
    				this.line=1;
    				this.metalic=1;
    				break;
    			case 'l':
    				this.atomic=17;
    				this.molar=(float) 35.5;
    				this.line=7;
    				this.metalic=2;
    				break;
    			case 'r':
    				this.atomic=24;
    				this.molar=52;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'd':
    				this.atomic=48;
    				this.molar=(float) 112.4;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'e':
    				this.atomic=58;
    				this.molar=(float) 140.1;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'm':
    				this.atomic=96;
    				this.molar=247;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'f':
    				this.atomic=98;
    				this.molar=251;
    				this.line=0;
    				this.metalic=1;
    				break;
    			}
    			}
    			break;
    		case 'D':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'b':
    				this.atomic=105;
    				this.molar=262;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 's':
    				this.atomic=110;
    				this.molar=271;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'y':
    				this.atomic=66;
    				this.molar=(float) 162.5;
    				this.line=0;
    				this.metalic=1;
    				break;
    				}
    			}
    			else
    				reset();
    			break;
    		case 'E':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'u':
    				this.atomic=63;
    				this.molar=152;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'r':
    				this.atomic=68;
    				this.molar=(float) 167.3;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 's':
    				this.atomic=99;
    				this.molar=254;
    				this.line=0;
    				this.metalic=1;
    				break;
    				}
    			}
    			else
    				reset();
    			break;
    		case 'F':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=9;
    				this.molar=19;
    				this.line=7;
    				this.metalic=2;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'r':
    				this.atomic=87;
    				this.molar=223;
    				this.line=1;
    				this.metalic=1;
    				break;
    			case 'e':
    				this.atomic=26;
    				this.molar=(float) 55.8;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'm':
    				this.atomic=100;
    				this.molar=253;
    				this.line=0;
    				this.metalic=1;
    				break;
    			}
    			}
    			break;
    		case 'G':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'a':
    				this.atomic=31;
    				this.molar=(float) 69.7;
    				this.line=3;
    				this.metalic=1;
    				break;
    			case 'e':
    				this.atomic=32;
    				this.molar=(float) 72.6;
    				this.line=4;
    				this.metalic=1;
    				break;
    			case 'd':
    				this.atomic=64;
    				this.molar=(float) 157.2;
    				this.line=0;
    				this.metalic=1;
    				break;
    				}
    			}
    			else
    				reset();
    			break;
    		case 'H':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=1;
    				this.molar=1;
    				this.line=1;
    				this.metalic=2;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'e':
    				this.atomic=2;
    				this.molar=4;
    				this.line=8;
    				this.metalic=2;
    				break;
    			case 'f':
    				this.atomic=72;
    				this.molar=(float) 178.5;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'g':
    				this.atomic=80;
    				this.molar=(float) 200.6;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 's':
    				this.atomic=108;
    				this.molar=269;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'o':
    				this.atomic=67;
    				this.molar=(float) 164.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			}
    			}
    			break;
    		case 'I':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=53;
    				this.molar=(float) 126.9;
    				this.line=7;
    				this.metalic=2;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'n':
    				this.atomic=49;
    				this.molar=(float) 114.8;
    				this.line=3;
    				this.metalic=1;
    				break;
    			case 'r':
    				this.atomic=77;
    				this.molar=(float) 192.2;
    				this.line=0;
    				this.metalic=1;
    				break;
    			}
    			}
    			break;
    		case 'K':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=19;
    				this.molar=(float) 39.1;
    				this.line=1;
    				this.metalic=1;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'r':
    				this.atomic=36;
    				this.molar=(float) 83.8;
    				this.line=8;
    				this.metalic=2;
    				break;
    			}
    			}
    			break;
    		case 'L':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'i':
    				this.atomic=3;
    				this.molar=(float) 6.9;
    				this.line=1;
    				this.metalic=1;
    				break;
    			case 'a':
    				this.atomic=57;
    				this.molar=(float) 138.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'u':
    				this.atomic=71;
    				this.molar=175;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'r':
    				this.atomic=103;
    				this.molar=257;
    				this.line=0;
    				this.metalic=1;
    				break;
    				}
    			}
    			else
    				reset();
    			break;
    		case 'M':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'g':
    				this.atomic=12;
    				this.molar=(float) 24.3;
    				this.line=2;
    				this.metalic=1;
    				break;
    			case 'n':
    				this.atomic=25;
    				this.molar=(float) 54.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'o':
    				this.atomic=42;
    				this.molar=(float) 95.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 't':
    				this.atomic=109;
    				this.molar=268;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'd':
    				this.atomic=101;
    				this.molar=256;
    				this.line=0;
    				this.metalic=1;
    				break;
    				}
    			}
    			else
    				reset();
    			break;
    		case 'N':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=7;
    				this.molar=14;
    				this.line=5;
    				this.metalic=2;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'e':
    				this.atomic=10;
    				this.molar=(float) 20.2;
    				this.line=8;
    				this.metalic=2;
    				break;
    			case 'i':
    				this.atomic=28;
    				this.molar=(float) 58.7;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'a':
    				this.atomic=11;
    				this.molar=23;
    				this.line=1;
    				this.metalic=1;
    				break;
    			case 'b':
    				this.atomic=41;
    				this.molar=(float) 92.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'd':
    				this.atomic=60;
    				this.molar=(float) 144.2;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'p':
    				this.atomic=93;
    				this.molar=237;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'o':
    				this.atomic=102;
    				this.molar=254;
    				this.line=0;
    				this.metalic=1;
    				break;
    			}
    			}
    			break;
    		case 'O':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=8;
    				this.molar=16;
    				this.line=6;
    				this.metalic=2;
    				}
    			if(i+1<symbol.length()){
    			if(symbol.charAt(i+1)=='s'){
    				this.atomic=76;
    				this.molar=(float) 190.2;
    				this.line=0;
    				this.metalic=1;
    				}
    			}
    			break;
    		case 'P':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=15;
    				this.molar=31;
    				this.line=5;
    				this.metalic=2;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'd':
    				this.atomic=46;
    				this.molar=(float) 106.4;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 't':
    				this.atomic=78;
    				this.molar=(float) 195.1;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'b':
    				this.atomic=82;
    				this.molar=(float) 207.2;
    				this.line=4;
    				this.metalic=1;
    				break;
    			case 'o':
    				this.atomic=84;
    				this.molar=210;
    				this.line=6;
    				this.metalic=1;
    				break;
    			case 'r':
    				this.atomic=59;
    				this.molar=(float) 140.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'm':
    				this.atomic=61;
    				this.molar=145;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'a':
    				this.atomic=91;
    				this.molar=231;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'u':
    				this.atomic=94;
    				this.molar=242;
    				this.line=0;
    				this.metalic=1;
    				break;
    			}
    			}
    			break;
    		case 'R':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'b':
    				this.atomic=37;
    				this.molar=(float) 85.5;
    				this.line=1;
    				this.metalic=1;
    				break;
    			case 'u':
    				this.atomic=44;
    				this.molar=(float) 101.1;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'h':
    				this.atomic=45;
    				this.molar=(float) 102.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'e':
    				this.atomic=75;
    				this.molar=(float) 186.2;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'n':
    				this.atomic=86;
    				this.molar=222;
    				this.line=8;
    				this.metalic=2;
    				break;
    			case 'a':
    				this.atomic=88;
    				this.molar=226;
    				this.line=2;
    				this.metalic=1;
    				break;
    			case 'f':
    				this.atomic=104;
    				this.molar=261;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'g':
    				this.atomic=111;
    				this.molar=272;
    				this.line=0;
    				this.metalic=1;
    				break;
    				}
    			}
    			else
    				reset();
    			break;
    		case 'S':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=16;
    				this.molar=(float) 32.1;
    				this.line=6;
    				this.metalic=2;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'i':
    				this.atomic=14;
    				this.molar=(float) 28.1;
    				this.line=4;
    				this.metalic=2;
    				break;
    			case 'c':
    				this.atomic=21;
    				this.molar=45;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'e':
    				this.atomic=34;
    				this.molar=79;
    				this.line=6;
    				this.metalic=2;
    				break;
    			case 'r':
    				this.atomic=38;
    				this.molar=(float) 87.6;
    				this.line=2;
    				this.metalic=1;
    				break;
    			case 'n':
    				this.atomic=50;
    				this.molar=(float) 118.7;
    				this.line=4;
    				this.metalic=1;
    				break;
    			case 'b':
    				this.atomic=51;
    				this.molar=(float) 121.8;
    				this.line=5;
    				this.metalic=2;
    				break;
    			case 'g':
    				this.atomic=106;
    				this.molar=266;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'm':
    				this.atomic=62;
    				this.molar=(float) 150.4;
    				this.line=0;
    				this.metalic=1;
    				break;
    			}
    			}
    			break;
    		case 'T':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'i':
    				this.atomic=22;
    				this.molar=(float) 47.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'c':
    				this.atomic=43;
    				this.molar=99;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'e':
    				this.atomic=52;
    				this.molar=(float) 127.6;
    				this.line=6;
    				this.metalic=2;
    				break;
    			case 'a':
    				this.atomic=73;
    				this.molar=181;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'l':
    				this.atomic=81;
    				this.molar=(float) 204.4;
    				this.line=3;
    				this.metalic=1;
    				break;
    			case 'b':
    				this.atomic=65;
    				this.molar=(float) 158.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'm':
    				this.atomic=69;
    				this.molar=(float) 168.9;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'h':
    				this.atomic=90;
    				this.molar=232;
    				this.line=0;
    				this.metalic=1;
    				break;
    				}
    			}
    			else
    				reset();
    			break;
    		case 'U':
    			if(i+1<symbol.length()){
    				reset();
    			}
    			else{
				this.atomic=92;
				this.molar=238;
				this.line=0;
				this.metalic=1;
				}
    			break;
    		case 'V':
    			if(i+1<symbol.length()){
    				reset();
    			}
    			else{
				this.atomic=23;
				this.molar=(float) 50.9;
				this.line=0;
				this.metalic=1;
				}
    			break;
    		case 'W':
    			if(i+1<symbol.length()){
    				reset();
    			}
    			else{
				this.atomic=74;
				this.molar=(float) 183.8;
				this.line=0;
				this.metalic=1;
				}
    			break;
    		case 'X':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'e':
    				this.atomic=54;
    				this.molar=(float) 131.3;
    				this.line=8;
    				this.metalic=2;
    				break;
    				}
    			}
    			else
    				reset();
    			break;
    		case 'Y':
    			if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
    				this.atomic=39;
    				this.molar=(float) 88.1;
    				this.line=0;
    				this.metalic=1;
    				}
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'b':
    				this.atomic=70;
    				this.molar=173;
    				this.line=0;
    				this.metalic=1;
    				break;
    			}
    			}
    			break;
    		case 'Z':
    			if(i+1<symbol.length()){
    			switch(symbol.charAt(i+1)){
    			case 'n':
    				this.atomic=30;
    				this.molar=(float) 65.4;
    				this.line=0;
    				this.metalic=1;
    				break;
    			case 'r':
    				this.atomic=40;
    				this.molar=(float) 91.2;
    				this.line=0;
    				this.metalic=1;
    				break;
    				}
    			}
    			else
    				reset();
    		}
	}
}
	public void reset(){
		symbol="";
		molar=0;
		atomic=0;
		line=0;
		metalic= 0;
	}
}