package com.og.matter;

public class Element {
	private float molar;
	private String name,Ename,group,symbol;
	private int atomic,electrons,protons,line,metalic;
	private int kationnum=0,count=0;
	private int numindex=0;
	private Ion kation=new Ion();
	private Ion anion=new Ion();
	private Ion panion=new Ion();
	private boolean letter=false;
	private boolean metal=false,nmetal=false;
	public Element(){
		//constractor
	}
	public int getProtons() {
		return protons;
	}
	public void setProtons(int protons) {
		this.protons = protons;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
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
	public void setAtomic(int atomic) {
		this.atomic = atomic;
	}
	public int getMetalic() {
		return metalic;
	}
	public void setMetalic(int metalic) {
		this.metalic = metalic;
	}
	public int getElectrons() {
		return electrons;
	}
	public void setElectrons(int electrons) {
		this.electrons = electrons;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public float getMolar() {
		return molar;
	}
	public void setMolar(float molar) {
		this.molar = molar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEname() {
		return Ename;
	}
	public void setEName(String Ename) {
		this.Ename = Ename;
	}
	public void Symbol(){
		char tav;
		this.group="None";
		boolean PM=false;
		String tempName="";
		for(int i=0;i<symbol.length();i++){
			tav=symbol.charAt(i);
			if(tav=='+'||tav=='-')
				PM=true;
		}
		if(PM){
			tempName=symbol;
			symbol=element();
		}
		for(int i=0;i<symbol.length();i++){
			tav=symbol.charAt(i);
			switch(tav){
				case 'A':
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'l':
								this.metalic=1;
								this.name="אַלוּמִינְיוּם";
								this.Ename="Aluminium";
								this.atomic=13;
								this.molar=27;
								this.line=3;
								break;
							case 'r':
								this.metalic=2;
								this.group="גזים אצילים";
								this.name="אַרְגּוֹן";
								this.Ename="Argon";
								this.atomic=18;
								this.molar=40;
								this.line=8;
								break;
							case 's':
								this.metalic=2;
								this.name="אַרְסֶן";
								this.Ename="Arsenic";
								this.atomic=33;
								this.molar=(float) 74.9;
								this.line=5;
								break;
							case 'g':
								this.metalic=1;
								this.name="כסף";
								this.Ename="Silver";
								this.atomic=47;
								this.molar=(float) 107.9;
								this.line=0;
								break;
							case 'u':
								this.metalic=1;
								this.name="זהב";
								this.Ename="Gold";
								this.atomic=79;
								this.molar=197;
								this.line=0;
								break;
							case 't':
								this.metalic=2;
								this.group="הלוגנים";
								this.name="אַסְטָטִין";
								this.Ename="Astatine";
								this.atomic=85;
								this.molar=210;
								this.line=7;
								break;
							case 'c':
								this.metalic=1;
								this.name="אַקְטִינְיוּם";
								this.Ename="Actinium";
								this.atomic=89;
								this.molar=227;
								this.line=0;
								break;
							case 'm':
								this.metalic=1;
								this.name="אַמֵרִיצְיוּם";
								this.Ename="Americium";
								this.atomic=95;
								this.molar=243;
								this.line=0;
								break;
						}
					}
					else
						reset();
					break;
				case 'B':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=2;
						this.name="בּוֹר";
						this.Ename="Boron";
						this.atomic=5;
						this.molar=(float) 10.8;
						this.line=3;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'e':
								this.metalic=1;
								this.group="מתכות אלקליות עפרוריות";
								this.name="בֶּרִילְיוּם";
								this.Ename="Beryllium";
								this.atomic=4;
								this.molar=9;
								this.line=2;
								break;
							case 'r':
								this.metalic=2;
								this.group="הלוגנים";
								this.name="בְּרוֹם";
								this.Ename="Bromine";
								this.atomic=35;
								this.molar=(float) 79.9;
								this.line=7;
								break;
							case 'a':
								this.metalic=1;
								this.group="מתכות אלקליות עפרוריות";
								this.name="בְּריום";
								this.Ename="Barium";
								this.atomic=56;
								this.molar=(float) 137.3;
								this.line=2;
								break;
							case 'i':
								this.metalic=1;
								this.name="בִּיסְמוּת";
								this.Ename="Bismuth";
								this.atomic=83;
								this.molar=209;
								this.line=5;
								break;
							case 'h':
								this.metalic=1;
								this.name="בּוֹהרִיּוּם";
								this.Ename="Bohrium";
								this.atomic=107;
								this.molar=264;
								this.line=0;
								break;
							case 'k':
								this.metalic=1;
								this.name="בֵּרְקֵלִיּוּם";
								this.Ename="Berkelium";
								this.atomic=97;
								this.molar=247;
								this.line=0;
								break;
						}
					}
					break;
				case 'C':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=2;
						this.name="פחמן";
						this.Ename="Carbon";
						this.atomic=6;
						this.molar=12;
						this.line=4;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'a':
								this.metalic=1;
								this.group="מתכות אלקליות עפרוריות";
								this.Ename="Calcium";
								this.name="סידן";
								this.atomic=20;
								this.molar=(float) 40.1;
								this.line=2;
								break;
							case 'o':
								this.metalic=1;
								this.name="קוֹבַּלְט";
								this.Ename="Cobalt";
								this.atomic=27;
								this.molar=(float) 58.9;
								this.line=0;
								break;
							case 'u':
								this.metalic=1;
								this.name="נחושת";
								this.Ename="Copper";
								this.atomic=29;
								this.molar=(float) 63.5;
								this.line=0;
								break;
							case 's':
								this.metalic=1;
								this.group="מתכות אלקליות";
								this.name="צסיום";
								this.Ename="Caesium";
								this.atomic=55;
								this.molar=(float) 132.9;
								this.line=1;
								break;
							case 'l':
								this.metalic=2;
								this.group="הלוגנים";
								this.name="כלור";
								this.Ename="Chlorine";
								this.atomic=17;
								this.molar=(float) 35.5;
								this.line=7;
								break;
							case 'r':
								this.metalic=1;
								this.name="כרום";
								this.Ename="Chromium";
								this.atomic=24;
								this.molar=52;
								this.line=0;
								break;
							case 'd':
								this.metalic=1;
								this.name="קדמיום";
								this.Ename="Cadmium";
								this.atomic=48;
								this.molar=(float) 112.4;
								this.line=0;
								break;
							case 'e':
								this.metalic=1;
								this.name="צריום";
								this.Ename="Cerium";
								this.atomic=58;
								this.molar=(float) 140.1;
								this.line=0;
								break;
							case 'm':
								this.metalic=1;
								this.name="קוּרְיוּם";
								this.Ename="Curium";
								this.atomic=96;
								this.molar=247;
								this.line=0;
								break;
							case 'f':
								this.metalic=1;
								this.name="קַלִיפֿוֹרְנִיּוּם";
								this.Ename="Californium";
								this.atomic=98;
								this.molar=251;
								this.line=0;
								break;
						}
					}
					break;
				case 'D':
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'b':
								this.metalic=1;
								this.name="דּוּבְּנִיּוּם";
								this.Ename="Dubnium";
								this.atomic=105;
								this.molar=262;
								this.line=0;
								break;
							case 's':
								this.metalic=1;
								this.name="דַּרְמְשְטַטְיוּם";
								this.Ename="Darmstadtium";
								this.atomic=110;
								this.molar=271;
								this.line=0;
								break;
							case 'y':
								this.metalic=1;
								this.name="דִּיסְפְּרוֹסְיוּם";
								this.Ename="Dysprosium";
								this.atomic=66;
								this.molar=(float) 162.5;
								this.line=0;
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
								this.metalic=1;
								this.name="אירופיום";
								this.Ename="Europium";
								this.atomic=63;
								this.molar=152;
								this.line=0;
								break;
							case 'r':
								this.metalic=1;
								this.name="אֵרְבִּיּוּם";
								this.Ename="Erbium";
								this.atomic=68;
								this.molar=(float) 167.3;
								this.line=0;
								break;
							case 's':
								this.metalic=1;
								this.name="אַינְשְטַיְנְיוּם";
								this.Ename="Einsteinium";
								this.atomic=99;
								this.molar=254;
								this.line=0;
								break;
						}
					}
					else
						reset();
					break;
				case 'F':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=2;
						this.group="הלוגנים";
						this.Ename="Fluorine";
						this.name="פלואור";
						this.atomic=9;
						this.molar=19;
						this.line=7;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'r':
								this.metalic=1;
								this.group="מתכות אלקליות";
								this.name="פְֿרַנְצִיּוּם";
								this.Ename="Francium";
								this.atomic=87;
								this.molar=223;
								this.line=1;
								break;
							case 'e':
								this.metalic=1;
								this.name="ברזל";
								this.Ename="Iron";
								this.atomic=26;
								this.molar=(float) 55.8;
								this.line=0;
								break;
							case 'm':
								this.metalic=1;
								this.name="פֵֿרְמִיּוּם";
								this.Ename="Fermium";
								this.atomic=100;
								this.molar=253;
								this.line=0;
								break;
						}
					}
					break;
				case 'G':
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'a':
								this.metalic=1;
								this.name="גליום";
								this.Ename="Gallium";
								this.atomic=31;
								this.molar=(float) 69.7;
								this.line=3;
								break;
							case 'e':
								this.metalic=1;
								this.name="גרמניום";
								this.Ename="Germanium";
								this.atomic=32;
								this.molar=(float) 72.6;
								this.line=4;
								break;
							case 'd':
								this.metalic=1;
								this.name="גדוליניום";
								this.Ename="Gadolinium";
								this.atomic=64;
								this.molar=(float) 157.2;
								this.line=0;
								break;
						}
					}
					else
						reset();
					break;
				case 'H':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=2;
						this.name="מימן";
						this.Ename="Hydrogen";
						this.atomic=1;
						this.molar=1;
						this.line=1;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'e':
								this.metalic=2;
								this.group="גזים אצילים";
								this.name="הליום";
								this.Ename="Helium";
								this.atomic=2;
								this.molar=4;
								this.line=8;
								break;
							case 'f':
								this.metalic=1;
								this.name="הַפניום";
								this.Ename="Hafnium";
								this.atomic=72;
								this.molar=(float) 178.5;
								this.line=0;
								break;
							case 'g':
								this.metalic=1;
								this.name="כספית";
								this.Ename="Mercury";
								this.atomic=80;
								this.molar=(float) 200.6;
								this.line=0;
								break;
							case 's':
								this.metalic=1;
								this.name="הַאסְיוּם";
								this.Ename="Hassium";
								this.atomic=108;
								this.molar=269;
								this.line=0;
								break;
							case 'o':
								this.metalic=1;
								this.name="הולמיום";
								this.Ename="Holmium";
								this.atomic=67;
								this.molar=(float) 164.9;
								this.line=0;
								break;
						}
					}
					break;
				case 'I':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=2;
						this.group="הלוגנים";
						this.Ename="Iodine";
						this.name="יוד";
						this.atomic=53;
						this.molar=(float) 126.9;
						this.line=7;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'n':
								this.metalic=1;
								this.name="אִינְדִּיּוּם";
								this.Ename="Indium";
								this.atomic=49;
								this.molar=(float) 114.8;
								this.line=3;
								break;
							case 'r':
								this.metalic=1;
								this.name="אִירִידְיוּם";
								this.Ename="Iridium";
								this.atomic=77;
								this.molar=(float) 192.2;
								this.line=0;
								break;
						}
					}
					break;
				case 'K':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=1;
						this.group="מתכות אלקליות";
						this.name="אַשְׁלְגָן";
						this.Ename="Potassium";
						this.atomic=19;
						this.molar=(float) 39.1;
						this.line=1;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'r':
								this.metalic=2;
								this.group="גזים אצילים";
								this.name="קְרִיפְּטוֹן";
								this.Ename="Krypton";
								this.atomic=36;
								this.molar=(float) 83.8;
								this.line=8;
								break;
						}
					}
					break;
				case 'L':
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'i':
								this.metalic=1;
								this.group="מתכות אלקליות";
								this.name="ליתיום";
								this.Ename="Lithium";
								this.atomic=3;
								this.molar=(float) 6.9;
								this.line=1;
								break;
							case 'a':
								this.metalic=1;
								this.name="לַנְתַֿן";
								this.Ename="Lanthanum";
								this.atomic=57;
								this.molar=(float) 138.9;
								this.line=0;
								break;
							case 'u':
								this.metalic=1;
								this.name="לוטציום";
								this.Ename="Lutetium";
								this.atomic=71;
								this.molar=175;
								this.line=0;
								break;
							case 'r':
								this.metalic=1;
								this.name="לוֹרֵנְצִיּוּם";
								this.Ename="Lawrencium";
								this.atomic=103;
								this.molar=257;
								this.line=0;
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
								this.metalic=1;
								this.group="מתכות אלקליות עפרוריות";
								this.name="מגנזיום";
								this.Ename="Magnesium";
								this.atomic=12;
								this.molar=(float) 24.3;
								this.line=2;
								break;
							case 'n':
								this.metalic=1;
								this.name="מַנְגַּן";
								this.Ename="Manganese";
								this.atomic=25;
								this.molar=(float) 54.9;
								this.line=0;
								break;
							case 'o':
								this.metalic=1;
								this.name="מוליבדן";
								this.Ename="Molybdenum";
								this.atomic=42;
								this.molar=(float) 95.9;
								this.line=0;
								break;
							case 't':
								this.metalic=1;
								this.name="מֵיטְנֶרְיוּם";
								this.Ename="Meitnerium";
								this.atomic=109;
								this.molar=268;
								this.line=0;
								break;
							case 'd':
								this.metalic=1;
								this.name="מֵנְדֵּלֵבְֿיוּם";
								this.Ename="Mendelevium";
								this.atomic=101;
								this.molar=256;
								this.line=0;
								break;
						}
					}
					else
						reset();
					break;
				case 'N':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=2;
						this.name="חנקן";
						this.Ename="Nitrogen";
						this.atomic=7;
						this.molar=14;
						this.line=5;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'e':
								this.metalic=2;
								this.group="גזים אציליים";
								this.Ename="Neon";
								this.name="נֵאוֹן";
								this.atomic=10;
								this.molar=(float) 20.2;
								this.line=8;
								break;
							case 'i':
								this.metalic=1;
								this.name="ניקל";
								this.Ename="Nickel";
								this.atomic=28;
								this.molar=(float) 58.7;
								this.line=0;
								break;
							case 'a':
								this.metalic=1;
								this.group="מתכות אלקליות";
								this.name="נתרן";
								this.Ename="Sodium";
								this.atomic=11;
								this.molar=23;
								this.line=1;
								break;
							case 'b':
								this.metalic=1;
								this.name="ניאוביום";
								this.Ename="Niobium";
								this.atomic=41;
								this.molar=(float) 92.9;
								this.line=0;
								break;
							case 'd':
								this.metalic=1;
								this.name="נֵאוֹדִּימְיוּם";
								this.Ename="Neodymium";
								this.atomic=60;
								this.molar=(float) 144.2;
								this.line=0;
								break;
							case 'p':
								this.metalic=1;
								this.name="נֶפְּטוּנְיוּם";
								this.Ename="Neptunium";
								this.atomic=93;
								this.molar=237;
								this.line=0;
								break;
							case 'o':
								this.metalic=1;
								this.name="נוֹבֵּלְיוּם";
								this.Ename="Nobelium";
								this.atomic=102;
								this.molar=254;
								this.line=0;
								break;
						}
					}
					break;
				case 'O':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=2;
						this.name="חמצן";
						this.Ename="Oxygen";
						this.atomic=8;
						this.molar=16;
						this.line=6;}
					if(i+1<symbol.length()){
						if(symbol.charAt(i+1)=='s'){
							this.metalic=1;
							this.name="אוסמיום";
							this.Ename="Osmium";
							this.atomic=76;
							this.molar=(float) 190.2;
							this.line=0;}}
					break;
				case 'P':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=2;
						this.name="זרחן";
						this.Ename="Phosphorus";
						this.atomic=15;
						this.molar=31;
						this.line=5;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'd':
								this.metalic=1;
								this.name="פלדיום";
								this.Ename="Palladium";
								this.atomic=46;
								this.molar=(float) 106.4;
								this.line=0;
								break;
							case 't':
								this.metalic=1;
								this.name="פלטינה";
								this.Ename="Platinum";
								this.atomic=78;
								this.molar=(float) 195.1;
								this.line=0;
								break;
							case 'b':
								this.metalic=1;
								this.name="עופרת";
								this.Ename="Lead";
								this.atomic=82;
								this.molar=(float) 207.2;
								this.line=4;
								break;
							case 'o':
								this.metalic=1;
								this.name="פולוניום";
								this.Ename="Polonium";
								this.atomic=84;
								this.molar=210;
								this.line=6;
								break;
							case 'r':
								this.metalic=1;
								this.name="פרסאודימיום";
								this.Ename="Praseodymium";
								this.atomic=59;
								this.molar=(float) 140.9;
								this.line=0;
								break;
							case 'm':
								this.metalic=1;
								this.name="פרומתיום";
								this.Ename="Promethium";
								this.atomic=61;
								this.molar=145;
								this.line=3;
								break;
							case 'a':
								this.metalic=1;
								this.name="פְּרוֹטַקְטִינְיוּם";
								this.Ename="Protactinium";
								this.atomic=91;
								this.molar=231;
								this.line=0;
								break;
							case 'u':
								this.metalic=1;
								this.name="פְּלוּטוֹנְיוּם";
								this.Ename="Plutonium";
								this.atomic=94;
								this.molar=242;
								this.line=0;
								break;
						}
					}
					break;
				case 'R':
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'b':
								this.metalic=1;
								this.group="מתכות אלקליות";
								this.name="רובידיום";
								this.Ename="Rubidium";
								this.atomic=37;
								this.molar=(float) 85.5;
								this.line=1;
								break;
							case 'u':
								this.metalic=1;
								this.name="רותניום";
								this.Ename="Ruthenium";
								this.atomic=44;
								this.molar=(float) 101.1;
								this.line=0;
								break;
							case 'h':
								this.metalic=1;
								this.name="רודיום";
								this.Ename="Rhodium";
								this.atomic=45;
								this.molar=(float) 102.9;
								this.line=0;
								break;
							case 'e':
								this.metalic=1;
								this.name="רניום";
								this.Ename="Rhenium";
								this.atomic=75;
								this.molar=(float) 186.2;
								this.line=0;
								break;
							case 'n':
								this.metalic=2;
								this.group="גזים אצילים";
								this.name="רדון";
								this.Ename="Radon";
								this.atomic=86;
								this.molar=222;
								this.line=8;
								break;
							case 'a':
								this.metalic=1;
								this.group="מתכות אלקליות עפרוריות";
								this.name="רדיום";
								this.Ename="Radium";
								this.atomic=88;
								this.molar=226;
								this.line=2;
								break;
							case 'f':
								this.metalic=1;
								this.name="רָתֵֿרְפֿוֹרְדְּיוּם";
								this.Ename="Rutherfordium";
								this.atomic=104;
								this.molar=261;
								this.line=0;
								break;
							case 'g':
								this.metalic=1;
								this.name="רֶנְטְגֶּנְיוּם";
								this.Ename="Roentgenium";
								this.atomic=111;
								this.molar=272;
								this.line=0;
								break;
						}
					}
					else
						reset();
					break;
				case 'S':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=2;
						this.name="גופרית";
						this.Ename="Sulfur";
						this.atomic=16;
						this.molar=(float) 32.1;
						this.line=6;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'i':
								this.metalic=2;
								this.name="צוֹרָן";
								this.Ename="Silicon";
								this.atomic=14;
								this.molar=(float) 28.1;
								this.line=4;
								break;
							case 'c':
								this.metalic=1;
								this.name="סקנדיום";
								this.Ename="Scandium";
								this.atomic=21;
								this.molar=45;
								this.line=0;
								break;
							case 'e':
								this.metalic=2;
								this.name="סלניום";
								this.Ename="Selenium";
								this.atomic=34;
								this.molar=79;
								this.line=6;
								break;
							case 'r':
								this.metalic=1;
								this.group="מתכות אלקליות עפרוריות";
								this.name="סטרונציום";
								this.Ename="Strontium";
								this.atomic=38;
								this.molar=(float) 87.6;
								this.line=2;
								break;
							case 'n':
								this.metalic=1;
								this.name="בדיל";
								this.Ename="Tin";
								this.atomic=50;
								this.molar=(float) 118.7;
								this.line=4;
								break;
							case 'b':
								this.metalic=2;
								this.name="אנטימון";
								this.Ename="Antimony";
								this.atomic=51;
								this.molar=(float) 121.8;
								this.line=5;
								break;
							case 'g':
								this.metalic=1;
								this.name="סִיבּוֹרְגְּיוּם";
								this.Ename="Seaborgium";
								this.atomic=106;
								this.molar=266;
								this.line=0;
								break;
							case 'm':
								this.metalic=1;
								this.name="סמריום";
								this.Ename="Samarium";
								this.atomic=62;
								this.molar=(float) 150.4;
								this.line=0;
								break;
						}
					}
					break;
				case 'T':
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'i':
								this.metalic=1;
								this.name="טיטניום";
								this.Ename="Titanium";
								this.atomic=22;
								this.molar=(float) 47.9;
								this.line=0;
								break;
							case 'c':
								this.metalic=1;
								this.name="טכנציום";
								this.Ename="Technetium";
								this.atomic=43;
								this.molar=99;
								this.line=0;
								break;
							case 'e':
								this.metalic=2;
								this.name="טלור";
								this.Ename="Tellurium";
								this.atomic=52;
								this.molar=(float) 127.6;
								this.line=6;
								break;
							case 'a':
								this.metalic=1;
								this.name="טנטלום";
								this.Ename="Tantalum";
								this.atomic=73;
								this.molar=181;
								this.line=0;
								break;
							case 'l':
								this.metalic=1;
								this.name="תליום";
								this.Ename="Thallium";
								this.atomic=81;
								this.molar=(float) 204.4;
								this.line=3;
								break;
							case 'b':
								this.metalic=1;
								this.name="טרביום";
								this.Ename="Terbium";
								this.atomic=65;
								this.molar=(float) 158.9;
								this.line=0;
								break;
							case 'm':
								this.metalic=1;
								this.name="תוליום";
								this.Ename="Thulium";
								this.atomic=69;
								this.molar=(float) 168.9;
								this.line=0;
								break;
							case 'h':
								this.metalic=1;
								this.name="תוריום";
								this.Ename="Thorium";
								this.atomic=90;
								this.molar=232;
								this.line=0;
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
						this.metalic=1;
						this.name="אוּרַנְיוּם";
						this.Ename="Uranium";
						this.atomic=92;
						this.molar=238;
						this.line=0;}
					break;
				case 'V':
					if(i+1<symbol.length()){
						reset();
					}
					else{
						this.metalic=1;
						this.name="וַנַדִּיּוּם";
						this.Ename="Vanadium";
						this.atomic=23;
						this.molar=(float) 50.9;
						this.line=0;}
					break;
				case 'W':
					if(i+1<symbol.length()){
						reset();
					}
					else{
						this.metalic=1;
						this.name="טוּנְגְּסְטֶן";
						this.Ename="Tungsten";
						this.atomic=74;
						this.molar=(float) 183.8;
						this.line=0;}
					break;
				case 'X':
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'e':
								this.metalic=2;
								this.group="גזים אצילים";
								this.Ename="Xenon";
								this.name="קסנון";
								this.atomic=54;
								this.molar=(float) 131.3;
								this.line=8;
								break;
						}
					}
					else
						reset();
					break;
				case 'Y':
					if(i+1==symbol.length()||(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z')){
						this.metalic=1;
						this.name="איטריום";
						this.Ename="Yttrium";
						this.atomic=39;
						this.molar=(float) 88.1;
						this.line=0;}
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'b':
								this.metalic=1;
								this.name="איטרביום";
								this.Ename="Ytterbium";
								this.atomic=70;
								this.molar=173;
								this.line=0;
								break;
						}
					}
					break;
				case 'Z':
					if(i+1<symbol.length()){
						switch(symbol.charAt(i+1)){
							case 'n':
								this.metalic=1;
								this.name="אבץ";
								this.Ename="Zinc";
								this.atomic=30;
								this.molar=(float) 65.4;
								this.line=0;
								break;
							case 'r':
								this.metalic=1;
								this.name="זירקוניום";
								this.Ename="Zirconium";
								this.atomic=40;
								this.molar=(float) 91.2;
								this.line=0;
								break;
						}
					}
					else
						reset();
			}
		}
		this.protons=this.atomic;
		if(PM){
			symbol=tempName;
			boolean plus=false;
			this.Ename=this.Ename+" Ion";
			this.name="יון "+this.name+"";
			for(int i=0;i<symbol.length();i++){
				tav=symbol.charAt(i);
				if(tav=='+')
					plus=true;
			}
			if(plus){
				this.electrons=this.atomic-ion();
			}
			else {
				this.electrons=this.atomic+ion();
			}
			if(this.electrons<0)
				reset();
		}
		else
			this.electrons=this.atomic;
		if((atomic>=21&&atomic<=30)||(atomic>=39&&atomic<=48)||(atomic>=72&&atomic<=80)||(atomic>=104&&atomic<=111))
			this.group="מתכות מעבר";
		if(atomic>=57&atomic<=71)
			this.group="לנתנידים";
		if(atomic>=89&&atomic<=103)
			this.group="אקטינידים";
		if(atomic==13||atomic==31||atomic==49||atomic==50||atomic==81||atomic==82||atomic==83)
			this.group="מתכות מעבר עמידות";
		if(atomic==1||atomic==6||atomic==7||atomic==8||atomic==15||atomic==16||atomic==34)
			this.group="יסודות אל-מתכתיים";
		if(atomic==5||atomic==14||atomic==32||atomic==33||atomic==51||atomic==52||atomic==84)
			this.group="מתכות למחצה";
	}
	public boolean atomicNumber(){
		char tav;
		boolean num=true;
		for(int i=0;i<symbol.length();i++){
			tav=symbol.charAt(i);
			if(tav<'0'||tav>'9')
				num=false;
		}
		return num;
	}
	public void Atomic(){
		int multi;
		int sum=0;
		multi=(int)Math.pow(10,symbol.length()-1);
		int[] nums=new int[symbol.length()];
		for(int i=0;i<symbol.length();i++){
			nums[i]=findNum(i);
			if(symbol.length()>1){
				nums[i]=nums[i]*multi;
				multi=multi/10;}
			sum=sum+nums[i];
		}
		switch(sum){
			case 1:
				this.symbol="H";
				Symbol();
				break;
			case 2:
				this.symbol="He";
				Symbol();
				break;
			case 3:
				this.symbol="Li";
				Symbol();
				break;
			case 4:
				this.symbol="Be";
				Symbol();
				break;
			case 5:
				this.symbol="B";
				Symbol();
				break;
			case 6:
				this.symbol="C";
				Symbol();
				break;
			case 7:
				this.symbol="N";
				Symbol();
				break;
			case 8:
				this.symbol="O";
				Symbol();
				break;
			case 9:
				this.symbol="F";
				Symbol();
				break;
			case 10:
				this.symbol="Ne";
				Symbol();
				break;
			case 11:
				this.symbol="Na";
				Symbol();
				break;
			case 12:
				this.symbol="Mg";
				Symbol();
				break;
			case 13:
				this.symbol="Al";
				Symbol();
				break;
			case 14:
				this.symbol="Si";
				Symbol();
				break;
			case 15:
				this.symbol="P";
				Symbol();
				break;
			case 16:
				this.symbol="S";
				Symbol();
				break;
			case 17:
				this.symbol="Cl";
				Symbol();
				break;
			case 18:
				this.symbol="Ar";
				Symbol();
				break;
			case 19:
				this.symbol="K";
				Symbol();
				break;
			case 20:
				this.symbol="Ca";
				Symbol();
				break;
			case 21:
				this.symbol="Sc";
				Symbol();
				break;
			case 22:
				this.symbol="Ti";
				Symbol();
				break;
			case 23:
				this.symbol="V";
				Symbol();
				break;
			case 24:
				this.symbol="Cr";
				Symbol();
				break;
			case 25:
				this.symbol="Mn";
				Symbol();
				break;
			case 26:
				this.symbol="Fe";
				Symbol();
				break;
			case 27:
				this.symbol="Co";
				Symbol();
				break;
			case 28:
				this.symbol="Ni";
				Symbol();
				break;
			case 29:
				this.symbol="Cu";
				Symbol();
				break;
			case 30:
				this.symbol="Zn";
				Symbol();
				break;
			case 31:
				this.symbol="Ga";
				Symbol();
				break;
			case 32:
				this.symbol="Ge";
				Symbol();
				break;
			case 33:
				this.symbol="As";
				Symbol();
				break;
			case 34:
				this.symbol="Se";
				Symbol();
				break;
			case 35:
				this.symbol="Br";
				Symbol();
				break;
			case 36:
				this.symbol="Kr";
				Symbol();
				break;
			case 37:
				this.symbol="Rb";
				Symbol();
				break;
			case 38:
				this.symbol="Sr";
				Symbol();
				break;
			case 39:
				this.symbol="Y";
				Symbol();
				break;
			case 40:
				this.symbol="Zr";
				Symbol();
				break;
			case 41:
				this.symbol="Nb";
				Symbol();
				break;
			case 42:
				this.symbol="Mo";
				Symbol();
				break;
			case 43:
				this.symbol="Tc";
				Symbol();
				break;
			case 44:
				this.symbol="Ru";
				Symbol();
				break;
			case 45:
				this.symbol="Rh";
				Symbol();
				break;
			case 46:
				this.symbol="Pd";
				Symbol();
				break;
			case 47:
				this.symbol="Ag";
				Symbol();
				break;
			case 48:
				this.symbol="Cd";
				Symbol();
				break;
			case 49:
				this.symbol="In";
				Symbol();
				break;
			case 50:
				this.symbol="Sn";
				Symbol();
				break;
			case 51:
				this.symbol="Sb";
				Symbol();
				break;
			case 52:
				this.symbol="Te";
				Symbol();
				break;
			case 53:
				this.symbol="I";
				Symbol();
				break;
			case 54:
				this.symbol="Xe";
				Symbol();
				break;
			case 55:
				this.symbol="Cs";
				Symbol();
				break;
			case 56:
				this.symbol="Ba";
				Symbol();
				break;
			case 57:
				this.symbol="La";
				Symbol();
				break;
			case 58:
				this.symbol="Ce";
				Symbol();
				break;
			case 59:
				this.symbol="Pr";
				Symbol();
				break;
			case 60:
				this.symbol="Nd";
				Symbol();
				break;
			case 61:
				this.symbol="Pm";
				Symbol();
				break;
			case 62:
				this.symbol="Sm";
				Symbol();
				break;
			case 63:
				this.symbol="Eu";
				Symbol();
				break;
			case 64:
				this.symbol="Gd";
				Symbol();
				break;
			case 65:
				this.symbol="Tb";
				Symbol();
				break;
			case 66:
				this.symbol="Dy";
				Symbol();
				break;
			case 67:
				this.symbol="Ho";
				Symbol();
				break;
			case 68:
				this.symbol="Er";
				Symbol();
				break;
			case 69:
				this.symbol="Tm";
				Symbol();
				break;
			case 70:
				this.symbol="Yb";
				Symbol();
				break;
			case 71:
				this.symbol="Lu";
				Symbol();
				break;
			case 72:
				this.symbol="Hf";
				Symbol();
				break;
			case 73:
				this.symbol="Ta";
				Symbol();
				break;
			case 74:
				this.symbol="W";
				Symbol();
				break;
			case 75:
				this.symbol="Re";
				Symbol();
				break;
			case 76:
				this.symbol="Os";
				Symbol();
				break;
			case 77:
				this.symbol="Ir";
				Symbol();
				break;
			case 78:
				this.symbol="Pt";
				Symbol();
				break;
			case 79:
				this.symbol="Au";
				Symbol();
				break;
			case 80:
				this.symbol="Hg";
				Symbol();
				break;
			case 81:
				this.symbol="Tl";
				Symbol();
				break;
			case 82:
				this.symbol="Pb";
				Symbol();
				break;
			case 83:
				this.symbol="Bi";
				Symbol();
				break;
			case 84:
				this.symbol="Po";
				Symbol();
				break;
			case 85:
				this.symbol="At";
				Symbol();
				break;
			case 86:
				this.symbol="Rn";
				Symbol();
				break;
			case 87:
				this.symbol="Fr";
				Symbol();
				break;
			case 88:
				this.symbol="Ra";
				Symbol();
				break;
			case 89:
				this.symbol="Ac";
				Symbol();
				break;
			case 90:
				this.symbol="Th";
				Symbol();
				break;
			case 91:
				this.symbol="Pa";
				Symbol();
				break;
			case 92:
				this.symbol="U";
				Symbol();
				break;
			case 93:
				this.symbol="Np";
				Symbol();
				break;
			case 94:
				this.symbol="Pu";
				Symbol();
				break;
			case 95:
				this.symbol="Am";
				Symbol();
				break;
			case 96:
				this.symbol="Cm";
				Symbol();
				break;
			case 97:
				this.symbol="Bk";
				Symbol();
				break;
			case 98:
				this.symbol="Cf";
				Symbol();
				break;
			case 99:
				this.symbol="Es";
				Symbol();
				break;
			case 100:
				this.symbol="Fm";
				Symbol();
				break;
			case 101:
				this.symbol="Md";
				Symbol();
				break;
			case 102:
				this.symbol="No";
				Symbol();
				break;
			case 103:
				this.symbol="Lr";
				Symbol();
				break;
			case 104:
				this.symbol="Rf";
				Symbol();
				break;
			case 105:
				this.symbol="Db";
				Symbol();
				break;
			case 106:
				this.symbol="Sg";
				Symbol();
				break;
			case 107:
				this.symbol="Bh";
				Symbol();
				break;
			case 108:
				this.symbol="Hs";
				Symbol();
				break;
			case 109:
				this.symbol="Mt";
				Symbol();
				break;
			case 110:
				this.symbol="Ds";
				Symbol();
				break;
			case 111:
				this.symbol="Rg";
				Symbol();
				break;
		}
	}
	public int ion() {
		char tav;
		int num=0;
		int count=0,count2=0;
		int Si=0,O=0,P=0;
		boolean end=false;
		int index=0;
		String temp="";
		if(symbol.charAt(symbol.length()-1)=='}'){
			String charge=symbol.substring(symbol.indexOf('{')+1, symbol.indexOf('}'));
			if(charge.charAt(charge.length()-1)=='-'||charge.charAt(charge.length()-1)=='+')
				end=true;
			if(end){
				for(int i=0;i<charge.length()-1;i++){
					tav=charge.charAt(i);
					temp=temp+tav;
				}
				if(temp.equals(""))
					num=1;
				else
					num=Integer.parseInt(temp);
			}
			else{
				if(charge.indexOf('+')==-1)
					index=charge.indexOf('-');
				else
					index=charge.indexOf('+');
				for(int i=index+1;i<charge.length();i++){
					tav=charge.charAt(i);
					temp=temp+tav;
				}
				num=Integer.parseInt(temp);
			}
		}
		else{
			if(symbol.charAt(symbol.length()-1)=='-'||symbol.charAt(symbol.length()-1)=='+')
				end=true;
			if(end){
				for(int i=0;i<symbol.length();i++){
					tav=symbol.charAt(i);
					if(i+1<symbol.length())
						if(tav=='S'&symbol.charAt(i+1)=='i')
							Si++;
					if(i+1<symbol.length()){
						if(tav=='P'&&(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z'))
							P++;
					}
					else
					if(tav=='P')
						P++;
					if(i+1<symbol.length()){
						if(tav=='O'&&symbol.charAt(i+1)!='s')
							O++;
					}
					else
					if(tav=='O')
						O++;
				}
				for(int i=0;i<symbol.length();i++){
					tav=symbol.charAt(i);
					if(tav>='A'&&tav<='Z')
						count++;
					if(tav>='0'&&tav<='9')
						count2++;
				}
				if(symbol.length()-2>-1){
					tav=symbol.charAt(symbol.length()-2);
					if((tav>='A'&&tav<='Z')||(tav>='a'&&tav<='z'))
						num=1;

					if(count>1&&count2==1&&tav>='0'&&tav<='9')
						num=1;

					if(tav>='4'&&tav<='9'&&count>1)
						num=1;
					if(count==1)
						if(tav>='2'&&tav<='9')
							num=findNum(symbol.length()-2);
				}
				if(symbol.length()-1>-1)
					if(count>1&&symbol.charAt(symbol.length()-1)=='+')
						num=1;
				if(symbol.length()-3>-1){
					if(count==3&&count2==2)
						if(symbol.charAt(symbol.length()-1)=='-')
							if(symbol.charAt(symbol.length()-2)>='0'&&symbol.charAt(symbol.length()-2)<='9')
								if(symbol.charAt(symbol.length()-3)>='0'&&symbol.charAt(symbol.length()-3)<='9')
									num=findNum(symbol.length()-2);

					if((O==1&&P==0&&Si==0)||(O==0&&P==0&&Si==0)||(O==0&&P==1&&Si==0)||(O==0&&P==0&&Si==1))
						if(symbol.charAt(symbol.length()-1)=='-')
							if(symbol.charAt(symbol.length()-2)>='0'&&symbol.charAt(symbol.length()-2)<='9')
								if(symbol.charAt(symbol.length()-3)>='0'&&symbol.charAt(symbol.length()-3)<='9')
									num=findNum(symbol.length()-2);
				}
				if(symbol.length()-2>-1){
					if((count==2&&count2==2)||(count==2&&count2==3)||(count==3&&count2==4))
						if(symbol.charAt(symbol.length()-1)=='-')
							if(symbol.charAt(symbol.length()-2)>='0'&&symbol.charAt(symbol.length()-2)<='9')
								num=findNum(symbol.length()-2);

					if((O==1&&Si==1&&count==2)||(O==1&&Si==1&&count==3&&P==1)||(O==1&&count==2&&P==1)||(Si==1&&count==2&&P==1)){
						num=findNum(symbol.length() - 2);
						if(symbol.length()-3>-1)
							if(symbol.charAt(symbol.length()-3)=='1')
								num=num+10;
					}
				}
				if(symbol.equals("CH3CO2-"))
					num=1;
				if(symbol.equals("C2H3O2-"))
					num=1;
				if(symbol.equals("P2O74-"))
					num=4;
				if(num==0)
					num=1;
			}
			else{
				if(symbol.indexOf('-')==-1)
					index=symbol.indexOf('+');
				else
					index=symbol.indexOf('-');
				for(int i=index+1;i<symbol.length();i++){
					tav=symbol.charAt(i);
					temp=temp+tav;
				}
				num=Integer.parseInt(temp);
			}
		}
		return num;
	}
	public String element(){
		String E1="";
		char tav;
		int count=0,count2=0;
		int Si=0,O=0,P=0;
		boolean end=false;
		int index=0;
		if(symbol.charAt(symbol.length()-1)=='}'){
			E1=symbol.substring(0, symbol.indexOf('{'));
		}
		else{
			if(symbol.charAt(symbol.length()-1)=='-'||symbol.charAt(symbol.length()-1)=='+')
				end=true;
			if(end){
				for(int i=0;i<symbol.length();i++){
					tav=symbol.charAt(i);
					if(i+1<symbol.length())
						if(tav=='S'&symbol.charAt(i+1)=='i')
							Si++;
					if(i+1<symbol.length()){
						if(tav=='P'&&(symbol.charAt(i+1)<'a'||symbol.charAt(i+1)>'z'))
							P++;
					}
					else
					if(tav=='P')
						P++;
					if(i+1<symbol.length()){
						if(tav=='O'&&symbol.charAt(i+1)!='s')
							O++;
					}
					else
					if(tav=='O')
						O++;
				}
				for(int i=0;i<symbol.length();i++){
					tav=symbol.charAt(i);
					if(tav>='A'&&tav<='Z')
						count++;
					if(tav>='0'&&tav<='9')
						count2++;
				}
				if(symbol.length()-2>-1){
					tav=symbol.charAt(symbol.length()-2);
					if((tav>='A'&&tav<='Z')||(tav>='a'&&tav<='z'))
						E1=symbol.substring(0,symbol.length()-1);

					if(count>1&&count2==1&&tav>='0'&&tav<='9')
						E1=symbol.substring(0,symbol.length()-1);

					if(tav>='4'&&tav<='9'&&count>1)
						E1=symbol.substring(0,symbol.length()-1);
					if(count==1)
						if(tav>='2'&&tav<='9')
							E1=symbol.substring(0,symbol.length()-2);
				}
				if(symbol.length()-1>-1)
					if(count>1&&symbol.charAt(symbol.length()-1)=='+')
						E1=symbol.substring(0,symbol.length()-1);
				if(symbol.length()-3>-1){
					if(count==3&&count2==2)
						if(symbol.charAt(symbol.length()-1)=='-')
							if(symbol.charAt(symbol.length()-2)>='0'&&symbol.charAt(symbol.length()-2)<='9')
								if(symbol.charAt(symbol.length()-3)>='0'&&symbol.charAt(symbol.length()-3)<='9')
									E1=symbol.substring(0,symbol.length()-2);

					if((O==1&&P==0&&Si==0)||(O==0&&P==0&&Si==0)||(O==0&&P==1&&Si==0)||(O==0&&P==0&&Si==1))
						if(symbol.charAt(symbol.length()-1)=='-')
							if(symbol.charAt(symbol.length()-2)>='0'&&symbol.charAt(symbol.length()-2)<='9')
								if(symbol.charAt(symbol.length()-3)>='0'&&symbol.charAt(symbol.length()-3)<='9')
									E1=symbol.substring(0,symbol.length()-2);
				}
				if(symbol.length()-2>-1){
					if((count==2&&count2==2)||(count==2&&count2==3)||(count==3&&count2==4))
						if(symbol.charAt(symbol.length()-1)=='-')
							if(symbol.charAt(symbol.length()-2)>='0'&&symbol.charAt(symbol.length()-2)<='9')
								E1=symbol.substring(0,symbol.length()-2);

					if((O==1&&Si==1&&count==2)||(O==1&&Si==1&&count==3&&P==1)||(O==1&&count==2&&P==1)||(Si==1&&count==2&&P==1)){
						E1=symbol.substring(0,symbol.length()-2);
						if(symbol.length()-3>-1)
							if(symbol.charAt(symbol.length()-3)=='1')
								E1=symbol.substring(0,symbol.length()-3);
					}
				}
				if(symbol.equals("CH3CO2-"))
					E1=symbol.substring(0,symbol.length()-1);
				if(symbol.equals("C2H3O2-"))
					E1=symbol.substring(0,symbol.length()-1);
				if(symbol.equals("P2O74-"))
					E1=symbol.substring(0,symbol.length()-2);
				if(E1.equals(""))
					E1=symbol.substring(0,symbol.length()-1);
			}
			else{
				if(symbol.indexOf('-')==-1)
					index=symbol.indexOf('+');
				else
					index=symbol.indexOf('-');
				E1=symbol.substring(0,index);
			}
		}
		return E1;
	}
	public String compound(String matter1,String matter2,int anionnum,int kationnum){
		String C="";
		char tav;
		int count1=0;
		int count2=0;
		for(int i=0;i<matter1.length();i++){
			tav=matter1.charAt(i);
			if(tav>='A'&&tav<='Z')
				count1++;
		}
		for(int i=0;i<matter2.length();i++){
			tav=matter2.charAt(i);
			if(tav>='A'&&tav<='Z')
				count2++;
		}
		if((anionnum==1&&kationnum==1)||(anionnum==kationnum))
		C=matter1+matter2;
		else
			if((anionnum==1||(kationnum%anionnum==0))&&count2>1){
				if(anionnum!=1)
				kationnum=kationnum-kationnum/2;
				C=matter1+"("+matter2+")"+kationnum;}
			else
				if((kationnum==1||(anionnum%kationnum==0))&&count1>1){
					if(kationnum!=1)
					anionnum=anionnum-anionnum/2;
				C="("+matter1+")"+anionnum+matter2;}
				else
					if(count1>1&&count2>1)
						C="("+matter1+")"+anionnum+"("+matter2+")"+kationnum;
					else
						if(count2>1){
							if(anionnum%kationnum==0){
								if(kationnum!=1)
									anionnum=anionnum-anionnum/2;
								C=matter1+anionnum+matter2;
							}
							else
							if(kationnum%anionnum==0){
								if(anionnum!=1)
									kationnum=kationnum-kationnum/2;
								C=matter1+"("+matter2+")"+kationnum;
							}
							else
								C=matter1+anionnum+"("+matter2+")"+kationnum;
						}
						else
							if(count1>1){
								if(anionnum%kationnum==0){
									if(kationnum!=1)
										anionnum=anionnum-anionnum/2;
									C="("+matter1+")"+anionnum+matter2;}
								else
									if(kationnum%anionnum==0){
										if(anionnum!=1)
											kationnum=kationnum-kationnum/2;
										C=matter1+matter2+kationnum;
									}
									else
										C="("+matter1+")"+anionnum+matter2+kationnum;
							}
							else
						if(kationnum==1||(anionnum%kationnum==0)){
							if(kationnum!=1)
								anionnum=anionnum-anionnum/2;
							C=matter1+anionnum+matter2;}
						else
							if(anionnum==1||(kationnum%anionnum==0)){
								if(anionnum!=1)
									kationnum=kationnum-kationnum/2;
							C=matter1+matter2+kationnum;}
							else
								C=matter1+anionnum+matter2+kationnum;
		return C;
	}
	public void reset(){
		symbol="";
		name="";
		molar=0;
		protons=0;
		atomic=0;
		electrons=0;
		metalic=0;
		group="";
		line=0;
	}
	public void remove(){
		char tav;
		String temp="";
		boolean br=false;
		int index=0;
		for(int i=0;i<symbol.length();i++){
			tav=symbol.charAt(i);
			if((tav<'0'||tav>'9')&&tav!='.'){
				index=i;
				i=symbol.length();
			}
		}
		symbol=symbol.substring(index);
		for(int i=0;i<symbol.length();i++){
			tav=symbol.charAt(i);
			if(tav=='(')
				if(i+2<symbol.length())
					if((symbol.charAt(i+1)=='s'||symbol.charAt(i+1)=='l'||symbol.charAt(i+1)=='g')&&symbol.charAt(i+2)==')')
						br=true;
			if(tav=='(')
				if(i+3<symbol.length())
					if(symbol.charAt(i+1)=='a'&&symbol.charAt(i+2)=='q'&&symbol.charAt(i+3)==')')
						br=true;
			if(!br)
				temp=temp+tav;
			if(tav==')')
				br=false;
		}
		symbol=temp;
	}
	public int PKations(){
		if(symbol.contains("NH4")&&(symbol.charAt(symbol.indexOf("NH4")+3)==')'||(symbol.charAt(symbol.indexOf("NH4")+3)>='A'&&symbol.charAt(symbol.indexOf("NH4") + 3)<='Z')))
			return 1;
		else
		if(symbol.contains("H3O")&&(symbol.charAt(symbol.indexOf("H3O")+3)==')'||(symbol.charAt(symbol.indexOf("H3O")+3)>='A'&&symbol.charAt(symbol.indexOf("H3O")+3)<='Z')))
			return 1;
		else
		if(symbol.indexOf("NO2")==1&symbol.charAt(0)== '(' && symbol.contains("NO2")&&(symbol.charAt(symbol.indexOf("NO2") + 3)==')'||(symbol.charAt(symbol.indexOf("NO2") + 3) >= 'A' && symbol.charAt(symbol.indexOf("NO2") + 3) <= 'Z')))
			return 1;
		else
		if(symbol.indexOf("NO2")==0&&symbol.contains("NO2")&&(symbol.charAt(symbol.indexOf("NO2") + 3)==')'||(symbol.charAt(symbol.indexOf("NO2") + 3) >= 'A' && symbol.charAt(symbol.indexOf("NO2") + 3) <= 'Z')))
			return 1;
		return 0;
	}
	public boolean OH(){
		return symbol.contains("OH") && ((symbol.indexOf("OH") + 2 < symbol.length() && symbol.charAt(symbol.indexOf("OH") + 2) == ')') || (symbol.indexOf("OH") + 2 >= symbol.length()));
	}
	public int PAnions(){
		if(symbol.contains("OH")&&((symbol.indexOf("OH")+2<symbol.length()&&symbol.charAt(symbol.indexOf("OH")+2)==')')||(symbol.indexOf("OH")+2>=symbol.length())))
			return 1;
		else
		if(symbol.contains("NO3")&&((symbol.indexOf("NO3")+3<symbol.length()&&symbol.charAt(symbol.indexOf("NO3")+3)==')')||(symbol.indexOf("NO3")+3>=symbol.length())))
			return 1;
		else
		if(symbol.contains("NO2")&&((symbol.indexOf("NO2")+3<symbol.length()&&symbol.charAt(symbol.indexOf("NO2")+3)==')')||(symbol.indexOf("NO2")+3>=symbol.length())))
			return 1;
		else
		if(symbol.contains("PO3")&&((symbol.indexOf("PO3")+3<symbol.length()&&symbol.charAt(symbol.indexOf("PO3")+3)==')')||(symbol.indexOf("PO3")+3>=symbol.length())))
			return 3;
		else
		if(symbol.contains("ClO")&&((symbol.indexOf("ClO")+3<symbol.length()&&symbol.charAt(symbol.indexOf("ClO")+3)==')')||(symbol.indexOf("ClO")+3>=symbol.length())))
			return 1;
		else
		if(symbol.contains("BrO")&&((symbol.indexOf("BrO")+3<symbol.length()&&symbol.charAt(symbol.indexOf("BrO")+3)==')')||(symbol.indexOf("BrO")+3>=symbol.length())))
			return 1;
		else
		if(symbol.contains("IO3")&&((symbol.indexOf("IO3")+3<symbol.length()&&symbol.charAt(symbol.indexOf("IO3")+3)==')')||(symbol.indexOf("IO3")+3>=symbol.length())))
			return 1;
		else
		if(symbol.contains("NH2")&&((symbol.indexOf("NH2")+3<symbol.length()&&symbol.charAt(symbol.indexOf("NH2")+3)==')')||(symbol.indexOf("NH2")+3>=symbol.length())))
			return 1;
		else
		if(symbol.contains("OCN")&&((symbol.indexOf("OCN")+3<symbol.length()&&symbol.charAt(symbol.indexOf("OCN")+3)==')')||(symbol.indexOf("OCN")+3>=symbol.length())))
			return 1;
		else
		if(symbol.contains("SCN")&&((symbol.indexOf("SCN")+3<symbol.length()&&symbol.charAt(symbol.indexOf("SCN")+3)==')')||(symbol.indexOf("SCN")+3>=symbol.length())))
			return 1;
		else
		if(symbol.contains("CO3")&&((symbol.indexOf("CO3")+3<symbol.length()&&symbol.charAt(symbol.indexOf("CO3")+3)==')'&&symbol.indexOf("CO3")-1>-1&&symbol.charAt(symbol.indexOf("CO3")-1)!='H')||(symbol.indexOf("CO3")+3>=symbol.length()&&symbol.indexOf("CO3")-1>-1&&symbol.charAt(symbol.indexOf("CO3")-1)!='H')))
			return 2;
		else
		if(symbol.contains("SO4")&&((symbol.indexOf("SO4")+3<symbol.length()&&symbol.charAt(symbol.indexOf("SO4")+3)==')'&&symbol.indexOf("SO4")-1>-1&&symbol.charAt(symbol.indexOf("SO4")-1)!='H')||(symbol.indexOf("SO4")+3>=symbol.length()&&symbol.indexOf("SO4")-1>-1&&symbol.charAt(symbol.indexOf("SO4")-1)!='H')))
			return 2;
		else
		if(symbol.contains("SO3")&&((symbol.indexOf("SO3")+3<symbol.length()&&symbol.charAt(symbol.indexOf("SO3")+3)==')'&&symbol.indexOf("SO3")-1>-1&&symbol.charAt(symbol.indexOf("SO3")-1)!='H')||(symbol.indexOf("SO3")+3>=symbol.length()&&symbol.indexOf("SO3")-1>-1&&symbol.charAt(symbol.indexOf("SO3")-1)!='H')))
			return 2;
		return 0;
	}
	public void findKation(){
		char tav;
		kation.reset();
		metal=false;
		kationnum=0;
		int element=0;
		String kat="";
		for(int i=0;i<symbol.length();i++){
			tav=symbol.charAt(i);
			if(PKations()==0){
				if(tav>='A'&&tav<='Z'){
					kat=tav+"";
					element=i;
					i=symbol.length();
				}
			}
		}
		if(!kat.equals("")){
			if(element+1<symbol.length()){
				if(symbol.charAt(element+1)>='a'&&symbol.charAt(element+1)<='z'){
					kat=kat+symbol.charAt(element+1);
					letter=true;
					if(element+2<symbol.length())
						if(symbol.charAt(element+2)>='0'&&symbol.charAt(element+2)<='9'){
							if(symbol.charAt(element+3)>='0'&&symbol.charAt(element+3)<='9') {
								numindex = element + 3;
								kationnum = findNum(element + 2)*10+findNum(element + 3);
							}
							else{
								numindex = element + 2;
								kationnum = findNum(element + 2);
							}
						}
				}
				else
				if(symbol.charAt(element+1)>='0'&&symbol.charAt(element+1)<='9'){
					if(symbol.charAt(element+2)>='0'&&symbol.charAt(element+2)<='9') {
						numindex = element + 2;
						kationnum = findNum(element + 1)*10+findNum(element + 2);
					}
					else{
						numindex = element + 1;
						kationnum = findNum(element + 1);
					}
				}
			}
		}
		if(!kat.equals("")){
			kation.setSymbol(kat);
			kation.Symbol();
			if(kation.getMetalic()==1)
				metal=true;
		}
		else{
			if(PKations()!=0)
				metal=true;
			kation.setSymbol("");
		}
	}
	public void findAnion(){
		panion.reset();
		anion.reset();
		nmetal=false;
		char tav;
		anion.reset();
		int element=0;
		int countA=0;
		int indexE=0;
		String pn="";
		String an="";
		if(!kation.getSymbol().equals("")){
			if(kationnum!=0){
				if(kationnum<10) {
					for (int i = kation.getSymbol().length() + 1; i < symbol.length(); i++) {
						tav = symbol.charAt(i);
						if (tav >= 'A' && tav <= 'Z') {
							countA++;
							indexE = i;
						}
					}
				}
				else
					for (int i = kation.getSymbol().length() + 2; i < symbol.length(); i++) {
						tav = symbol.charAt(i);
						if (tav >= 'A' && tav <= 'Z') {
							countA++;
							indexE = i;
						}
					}
				if(countA==1){
					for(int i=kation.getSymbol().length()+1;i<symbol.length();i++){
						tav=symbol.charAt(i);
						if(PKations()==0&&PAnions()==0){
							if(tav>='A'&&tav<='Z'){
								an=tav+"";
								element=i;
								i=symbol.length();
							}
						}
					}
				}
				if(countA>1){
					pn=pn+symbol.charAt(indexE);
					if(indexE+1<symbol.length())
						if(symbol.charAt(indexE+1)>='a'&&symbol.charAt(indexE+1)<='z')
							pn=pn+symbol.charAt(indexE+1);
				}
			}
			else{
				for(int i=kation.getSymbol().length();i<symbol.length();i++){
					tav=symbol.charAt(i);
					if(tav>='A'&&tav<='Z'){
						countA++;
						indexE=i;
					}
				}
				if(countA==1){
					for(int i=kation.getSymbol().length();i<symbol.length();i++){
						tav=symbol.charAt(i);
						if(PKations()==0&&PAnions()==0){
							if(tav>='A'&&tav<='Z'){
								an=tav+"";
								element=i;
								i=symbol.length();
							}
						}
					}
				}
				if(countA>1){
					pn=pn+symbol.charAt(indexE);
					if(indexE+1<symbol.length())
						if(symbol.charAt(indexE+1)>='a'&&symbol.charAt(indexE+1)<='z')
							pn=pn+symbol.charAt(indexE+1);
				}
			}
			if(!an.equals(""))
				if(element+1<symbol.length())
					if(symbol.charAt(element+1)>='a'&&symbol.charAt(element+1)<='z')
						an=an+symbol.charAt(element+1);
			if(!an.equals("")){
				anion.setSymbol(an);
				anion.Symbol();
			}
			if(!pn.equals("")){
				panion.setSymbol(pn);
				panion.Symbol();
			}
			if(PAnions()!=0||anion.getMetalic()==2||panion.getMetalic()==2){
				nmetal=true;
			}
		}
		else{
			for(int i=0;i<symbol.length();i++){
				tav=symbol.charAt(i);
				if(tav>='A'&&tav<='Z'){
					indexE=i;
				}
			}
			pn=pn+symbol.charAt(indexE);
			if(indexE+1<symbol.length())
				if(symbol.charAt(indexE+1)>='a'&&symbol.charAt(indexE+1)<='z')
					pn=pn+symbol.charAt(indexE+1);
			panion.setSymbol(pn);
			panion.Symbol();
			if(PAnions()!=0||panion.getMetalic()==2){
				nmetal=true;
			}
		}
	}
	public String[] Split(){
		char tav;
		int br=0;
		String kat="";
		String an="";
		String[] ions=new String[4];
		int knum;
		int anum;
		int kcharge=0;
		int acharge=0;
		if(metal&&nmetal){
			if(PKations()==1){
				if(symbol.charAt(0)=='('&&symbol.charAt(6)>='0'&&symbol.charAt(6)<='9'){
					knum=findNum(5)*10+findNum(6);
					kat=kat+symbol.charAt(1)+symbol.charAt(2)+symbol.charAt(3);
					for(int i=7;i<symbol.length();i++){
						tav=symbol.charAt(i);
						an=an+tav;
					}
					kat=knum+kat;
					acharge=knum;
					kcharge=1;
				}
				else
				if(symbol.charAt(0)=='('){
					knum=findNum(5);
					kat=kat+symbol.charAt(1)+symbol.charAt(2)+symbol.charAt(3);
					for(int i=6;i<symbol.length();i++){
						tav=symbol.charAt(i);
						an=an+tav;
					}
					kat=knum+kat;
					acharge=knum;
					kcharge=1;
				}
				else{
					kat=kat+symbol.charAt(0)+symbol.charAt(1)+symbol.charAt(2);
					for(int i=3;i<symbol.length();i++){
						tav=symbol.charAt(i);
						an=an+tav;
					}
					acharge=1;
					kcharge=1;
				}
			}
			else
			if(PAnions()!=0){
				acharge=PAnions();
				if(OH()){
					if(symbol.charAt(symbol.length()-2)==')'){
						anum=findNum(symbol.length()-1);
						for(int i=symbol.length()-4;i<symbol.length()-2;i++){
							tav=symbol.charAt(i);
							an=an+tav;
						}
						for(int i=0;i<symbol.length()-5;i++){
							tav=symbol.charAt(i);
							kat=kat+tav;
						}
						an=anum+an;
						kcharge=anum;
					}
					else{
						for(int i=0;i<symbol.length()-2;i++){
							tav=symbol.charAt(i);
							kat=kat+tav;
						}
						for(int i=symbol.length()-2;i<symbol.length();i++){
							tav=symbol.charAt(i);
							an=an+tav;
						}
						kcharge=1;
						acharge=1;
					}
				}
				else{
					if(symbol.charAt(symbol.length()-2)==')'){
						anum=findNum(symbol.length()-1);
						if(kationnum!=0){
							for(int i=symbol.length()-5;i<symbol.length()-2;i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							for(int i=0;i<symbol.length()-7;i++){
								tav=symbol.charAt(i);
								kat=kat+tav;
							}
							kcharge=anum*acharge/kationnum;
							an=anum+an;
							kat=kationnum+kat;
							}
							else{
								for(int i=symbol.length()-5;i<symbol.length()-2;i++){
									tav=symbol.charAt(i);
									an=an+tav;
								}
								for(int i=0;i<symbol.length()-6;i++){
									tav=symbol.charAt(i);
									kat=kat+tav;
								}
								kcharge=anum*acharge;
								an=anum+an;
							}
						}
						else{
							if(kationnum!=0){
								for(int i=symbol.length()-3;i<symbol.length();i++){
									tav=symbol.charAt(i);
									an=an+tav;
								}
								for(int i=0;i<symbol.length()-4;i++){
									tav=symbol.charAt(i);
									kat=kat+tav;
								}
								kcharge=acharge/kationnum;
								kat=kationnum+kat;
							}
							else{
								for(int i=symbol.length()-3;i<symbol.length();i++){
									tav=symbol.charAt(i);
									an=an+tav;
								}
								for(int i=0;i<symbol.length()-3;i++){
									tav=symbol.charAt(i);
									kat=kat+tav;
								}
								kcharge=acharge;
							}
						}
					}
				}
			else
			if(kation.getLine()==1||kation.getLine()==2||kation.getAtomic()==13){
				for(int i=1;i<symbol.length();i++){
					tav=symbol.charAt(i);
					if(tav>='A'&&tav<='Z')
						count++;
					if(tav=='(')
						br=i;
				}
				if(count>1){
					if(symbol.charAt(symbol.length()-2)==')'){
						anum=findNum(symbol.length()-1);
						if(kationnum<10&&kationnum!=0){
							for(int i=br+1;i<symbol.length()-2;i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							for(int i=0;i<br-1;i++){
								tav=symbol.charAt(i);
								kat=kat+tav;
							}
							kcharge=kation.getLine();
							acharge=kcharge*kationnum/anum;
							an=anum+an;
							kat=kationnum+kat;
						}
						else
						if(kationnum>9){
							for(int i=br+1;i<symbol.length()-2;i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							for(int i=0;i<br-2;i++){
								tav=symbol.charAt(i);
								kat=kat+tav;
							}
							kcharge=kation.getLine();
							acharge=kcharge*kationnum/anum;
							an=anum+an;
							kat=kationnum+kat;
						}
						else{
							for(int i=br+1;i<symbol.length()-2;i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							for(int i=0;i<br;i++){
								tav=symbol.charAt(i);
								kat=kat+tav;
							}
							kcharge=kation.getLine();
							acharge=kcharge/anum;
							an=anum+an;
						}
					}
					else{
						if(kationnum<10&&kationnum!=0){
							for(int i=numindex+1;i<symbol.length();i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							for(int i=0;i<numindex;i++){
								tav=symbol.charAt(i);
								kat=kat+tav;
							}
							kcharge=kation.getLine();
							acharge=kcharge*kationnum;
							kat=kationnum+kat;
						}
						else
						if(kationnum>9){
							for(int i=numindex+1;i<symbol.length();i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							for(int i=0;i<numindex-1;i++){
								tav=symbol.charAt(i);
								kat=kat+tav;
							}
							kcharge=kation.getLine();
							acharge=kcharge*kationnum;
							kat=kationnum+kat;
						}
						else
						if(letter){
							for(int i=2;i<symbol.length();i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							kat=kat+symbol.charAt(0)+symbol.charAt(1);
							kcharge=kation.getLine();
							acharge=kcharge;
						}
						else{
							for(int i=1;i<symbol.length();i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							kat=kat+symbol.charAt(0);
							kcharge=kation.getLine();
							acharge=kcharge;
						}
					}
				}
				else{
					if(symbol.charAt(symbol.length()-1)>='2'&&symbol.charAt(symbol.length()-1)<='9'){
						anum=findNum(symbol.length()-1);
						if(kationnum!=0){
							for(int i=numindex+1;i<symbol.length()-1;i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							for(int i=0;i<numindex;i++){
								tav=symbol.charAt(i);
								kat=kat+tav;
							}
							kcharge=kation.getLine();
							acharge=kcharge*kationnum/anum;
							an=anum+an;
							kat=kationnum+kat;
						}
						else
						if(letter){
							for(int i=2;i<symbol.length()-1;i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							kat=kat+symbol.charAt(0)+symbol.charAt(1);
							kcharge=kation.getLine();
							acharge=kcharge/anum;
							an=anum+an;
						}
						else{
							for(int i=1;i<symbol.length()-1;i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							kat=kat+symbol.charAt(0);
							kcharge=kation.getLine();
							acharge=kcharge/anum;
							an=anum+an;
						}
					}
					else{
						if(kationnum!=0){
							for(int i=numindex+1;i<symbol.length();i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							for(int i=0;i<numindex;i++){
								tav=symbol.charAt(i);
								kat=kat+tav;
							}
							kcharge=kation.getLine();
							acharge=kcharge*kationnum;
							kat=kationnum+kat;
						}
						else
						if(letter){
							for(int i=2;i<symbol.length();i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							kat=kat+symbol.charAt(0)+symbol.charAt(1);
							kcharge=kation.getLine();
							acharge=kcharge;
						}
						else{
							for(int i=1;i<symbol.length();i++){
								tav=symbol.charAt(i);
								an=an+tav;
							}
							kat=kat+symbol.charAt(0);
							kcharge=kation.getLine();
							acharge=kcharge;
						}
					}
				}
			}
			else
			if(anion.getLine()==1||anion.getLine()==7||anion.getLine()==6||anion.getLine()==5){
				if(anion.getLine()!=1)
					acharge=8-anion.getLine();
				else
					acharge=anion.getLine();
				if(symbol.charAt(symbol.length()-1)>='2'&&symbol.charAt(symbol.length()-1)<='9'){
					anum=findNum(symbol.length()-1);
					if(kationnum!=0){
						for(int i=numindex+1;i<symbol.length()-1;i++){
							tav=symbol.charAt(i);
							an=an+tav;
						}
						for(int i=0;i<numindex;i++){
							tav=symbol.charAt(i);
							kat=kat+tav;
						}
						kcharge=acharge*anum/kationnum;
						an=anum+an;
						kat=kationnum+kat;
					}
					else
					if(letter){
						for(int i=2;i<symbol.length()-1;i++){
							tav=symbol.charAt(i);
							an=an+tav;
						}
						kat=kat+symbol.charAt(0)+symbol.charAt(1);
						kcharge=acharge*anum;
						an=anum+an;
					}
					else{
						for(int i=1;i<symbol.length()-1;i++){
							tav=symbol.charAt(i);
							an=an+tav;
						}
						kat=kat+symbol.charAt(0);
						kcharge=acharge*anum;
						an=anum+an;
					}
				}
				else{
					if(kationnum!=0){
						for(int i=numindex+1;i<symbol.length();i++){
							tav=symbol.charAt(i);
							an=an+tav;
						}
						for(int i=0;i<numindex;i++){
							tav=symbol.charAt(i);
							kat=kat+tav;
						}
						kcharge=acharge/kationnum;
						kat=kationnum+kat;
					}
					else
					if(letter){
						for(int i=2;i<symbol.length();i++){
							tav=symbol.charAt(i);
							an=an+tav;
						}
						kat=kat+symbol.charAt(0)+symbol.charAt(1);
						kcharge=acharge;
					}
					else{
						for(int i=1;i<symbol.length();i++){
							tav=symbol.charAt(i);
							an=an+tav;
						}
						kat=kat+symbol.charAt(0);
						kcharge=acharge;
					}
				}
			}
			else{
				kat="לא ניתן לחשב";
				an="";
			}
			if(kation.getAtomic()==47&&!symbol.equals("AgNO3")){
				kat="אין תגובת המסה";
				an="";
			}
		}
		else{
			kat="לא חומר יוני";
			an="";
		}
		ions[0]=kat;
		ions[1]=an;
		ions[2]=kcharge+"";
		ions[3]=acharge+"";
		return ions;
	}
	public void removeIon(){
		char tav;
		String temp="";
		int countA=0,br=0,cof=0;
		for(int i=0;i<symbol.length();i++){
			tav=symbol.charAt(i);
			if(tav>='A'&&tav<='Z')
				countA++;
			if(countA==0&&tav>='0'&&tav<='9')
				cof++;
		}
		if(cof!=0){
			for(int i=cof;i<symbol.length();i++){
				tav=symbol.charAt(i);
				temp=temp+tav;
			}
			symbol=temp;
		}
		if(symbol.charAt(symbol.length()-1)==')'){
			for(int i=symbol.length()-1;i>-1;i--){
				tav=symbol.charAt(i);
				if(tav=='('){
					br=i;
					i=-1;
				}
			}
		}
		if(br!=0){
			temp="";
			for(int i=0;i<br;i++){
				tav=symbol.charAt(i);
				temp=temp+tav;
			}
			symbol=temp;
		}
	}
	public int findNum(int index){
		switch(symbol.charAt(index)){
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
		}
		return 0;
	}
	public boolean isKSinkable(){
		if(line!=1)
			line=2;
		char tav;
		int count=0;
		if(element().equals("H3O")||element().equals("NH4"))
			return true;
		for (int i=0;i<symbol.length();i++){
			tav=symbol.charAt(i);
			if(tav>='A'&&tav<='Z')
				count++;
		}
		return count == 1 && line == 1;
	}
	public boolean isASinkable(){
		return element().equals("NO3");
	}
	public int countCapital(){
		char tav;
		int count=0;
		for(int i=0;i<symbol.length();i++){
			tav=symbol.charAt(i);
			if(tav>='A'&&tav<='Z')
				count++;
		}
		return count;
	}
	/*public void EngGroup(){
		switch (group){
			case "����� �������":
				group="Alkali Metal";
				break;
			case "����� ������� ��������":
				group="Alkaline Earth Metal";
				break;
			case "�������":
				group="Diatomic Nonmetal";
				break;
			case "���� ������":
				group="Noble Gas";
				break;
			default:
				if((atomic>=21&&atomic<=30)||(atomic>=39&&atomic<=48)||(atomic>=72&&atomic<=80)||(atomic>=104&&atomic<=111))
					this.group="Transition metal";
				else
				if(atomic>=57&atomic<=71)
					this.group="Lan�thanide";
				else
				if(atomic>=89&&atomic<=103)
					this.group="Actinide";
				else
				if(atomic==13||atomic==31||atomic==49||atomic==50||atomic==81||atomic==82||atomic==83)
					this.group="Post-Transition Metal";
				else
				if(atomic==1||atomic==6||atomic==7||atomic==8||atomic==15||atomic==16||atomic==34)
					this.group="Polyatomic Nonmetal";
				else
				if(atomic==5||atomic==14||atomic==32||atomic==33||atomic==51||atomic==52||atomic==84)
					this.group="Metalloid";
		}
	}
	*/
}