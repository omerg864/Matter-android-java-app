package com.og.matter;

public class Matter {
    private String category;
    private float concentration;
    private float mass;
    private float mol;
    private float molar;
    private float molarvol;
    private String name;
    private float volumeg;
    private float volumel;

    public float getConcentration() {
        return this.concentration;
    }

    public void setConcentration(float concentration) {
        this.concentration = concentration;
    }

    public float getMolarvol() {
        return this.molarvol;
    }

    public void setMolarvol(float molarvol) {
        this.molarvol = molarvol;
    }

    public float getVolumeg() {
        return this.volumeg;
    }

    public void setVolumeg(float volumeg) {
        this.volumeg = volumeg;
    }

    public float getMass() {
        return this.mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getMol() {
        return this.mol;
    }

    public void setMol(float mol) {
        this.mol = mol;
    }

    public float getMolar() {
        return this.molar;
    }

    public void setMolar(float molar) {
        this.molar = molar;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getVolumel() {
        return this.volumel;
    }

    public void setVolumel(float volumel) {
        this.volumel = volumel;
    }

    public void findMolar() {
        int Metalic=0,nonMetalic=0;
        float sumElement=0;
        float sumBr=0;
        int M=0;
        int nums=0;
        int multi=0;
        int letter=1;
        float sum=0;
        char tav,tav1;
        boolean inbr=false;
        for(int i=0;i<name.length();i++){
            tav=name.charAt(i);
            switch(tav){
                case 'A':
                    switch(name.charAt(i+1)){
                        case 'l':
                            Metalic++;
                            sumElement=27;
                            break;
                        case 'r':
                            nonMetalic++;
                            sumElement=40;
                            break;
                        case 's':
                            nonMetalic++;
                            sumElement=(float) 74.9;
                            break;
                        case 'g':
                            Metalic++;
                            sumElement=(float) 107.9;
                            break;
                        case 'u':
                            Metalic++;
                            sumElement=197;
                            break;
                        case 't':
                            nonMetalic++;
                            sumElement=210;
                            break;
                        case 'c':
                            Metalic++;
                            sumElement=227;
                            break;
                        case 'm':
                            Metalic++;
                            sumElement=243;
                            break;
                    }
                    break;
                case 'B':
                    letter=0;
                    nonMetalic++;
                    sumElement=(float) 10.8;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'e':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=9;
                                break;
                            case 'r':
                                letter=1;
                                sumElement=(float) 79.9;
                                break;
                            case 'a':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 137.3;
                                break;
                            case 'i':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=209;
                                break;
                            case 'h':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=264;
                                break;
                            case 'k':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=247;
                                break;
                        }
                    }
                    break;
                case 'C':
                    letter=0;
                    nonMetalic++;
                    sumElement=12;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'a':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 40.1;
                                break;
                            case 'o':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 58.9;
                                break;
                            case 'u':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 63.5;
                                break;
                            case 's':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 132.9;
                                break;
                            case 'l':
                                letter=1;
                                sumElement=(float) 35.5;
                                break;
                            case 'r':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=52;
                                break;
                            case 'd':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 112.4;
                                break;
                            case 'n':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=285;
                                break;
                            case 'e':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 140.1;
                                break;
                            case 'm':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=247;
                                break;
                            case 'f':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=251;
                                break;
                        }
                    }
                    break;
                case 'D':
                    letter=1;
                    switch(name.charAt(i+1)){
                        case 'b':
                            Metalic++;
                            sumElement=262;
                            break;
                        case 's':
                            Metalic++;
                            sumElement=271;
                            break;
                        case 'y':
                            Metalic++;
                            sumElement=(float) 162.5;
                            break;
                    }
                    break;
                case 'E':
                    letter=1;
                    switch(name.charAt(i+1)){
                        case 'u':
                            Metalic++;
                            sumElement=152;
                            break;
                        case 'r':
                            Metalic++;
                            sumElement=(float) 167.3;
                            break;
                        case 's':
                            Metalic++;
                            sumElement=254;
                            break;
                    }
                    break;
                case 'F':
                    letter=0;
                    nonMetalic++;
                    sumElement=19;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'r':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=223;
                                break;
                            case 'e':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 55.8;
                                break;
                            case 'm':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=253;
                                break;
                        }
                    }
                    break;
                case 'G':
                    letter=1;
                    switch(name.charAt(i+1)){
                        case 'a':
                            Metalic++;
                            sumElement=(float) 69.7;
                            break;
                        case 'e':
                            Metalic++;
                            sumElement=(float) 72.6;
                            break;
                        case 'd':
                            Metalic++;
                            sumElement=(float) 157.2;
                            break;
                    }
                    break;
                case 'H':
                    letter=0;
                    nonMetalic++;
                    sumElement=1;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'e':
                                letter=1;
                                sumElement=4;
                                break;
                            case 'f':
                                letter=1;
                                sumElement=(float) 178.5;
                                nonMetalic--;
                                Metalic++;
                                break;
                            case 'g':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 200.6;
                                break;
                            case 's':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=269;
                                break;
                            case 'o':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 164.9;
                                break;
                        }
                    }
                    break;
                case 'I':
                    letter=0;
                    nonMetalic++;
                    sumElement=(float) 126.9;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'n':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 114.8;
                                break;
                            case 'r':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 192.2;
                                break;
                        }
                    }
                    break;
                case 'K':
                    letter=0;
                    Metalic++;
                    sumElement=(float) 39.1;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'r':
                                letter=1;
                                nonMetalic++;
                                Metalic--;
                                sumElement=(float) 83.8;
                                break;
                        }
                    }
                    break;
                case 'L':
                    letter=1;
                    Metalic++;
                    switch(name.charAt(i+1)){
                        case 'i':
                            sumElement=(float) 6.9;
                            break;
                        case 'a':
                            sumElement=(float) 138.9;
                            break;
                        case 'u':
                            sumElement=175;
                            break;
                        case 'r':
                            sumElement=257;
                            break;
                    }
                    break;
                case 'M':
                    letter=1;
                    Metalic++;
                    switch(name.charAt(i+1)){
                        case 'g':
                            sumElement=(float) 24.3;
                            break;
                        case 'n':
                            sumElement=(float) 54.9;
                            break;
                        case 'o':
                            sumElement=(float) 95.9;
                            break;
                        case 't':
                            sumElement=268;
                            break;
                        case 'd':
                            sumElement=256;
                            break;
                    }
                    break;
                case 'N':
                    letter=0;
                    nonMetalic++;
                    sumElement=14;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'e':
                                letter=1;
                                sumElement=(float) 20.2;
                                break;
                            case 'i':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 58.7;
                                break;
                            case 'a':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=23;
                                break;
                            case 'b':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 92.9;
                                break;
                            case 'd':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 144.2;
                                break;
                            case 'p':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=237;
                                break;
                            case 'o':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=254;
                                break;
                        }
                    }
                    break;
                case 'O':
                    letter=0;
                    nonMetalic++;
                    sumElement=16;
                    if(i+1<name.length())
                        if(name.charAt(i+1)=='s'){
                            letter=1;
                            nonMetalic--;
                            Metalic++;
                            sumElement=(float) 190.2;}
                    break;
                case 'P':
                    letter=0;
                    nonMetalic++;
                    sumElement=31;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'd':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 106.4;
                                break;
                            case 't':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 195.1;
                                break;
                            case 'b':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 207.2;
                                break;
                            case 'o':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=210;
                                break;
                            case 'r':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 140.9;
                                break;
                            case 'm':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=145;
                                break;
                            case 'a':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=231;
                                break;
                            case 'u':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=242;
                                break;
                        }
                    }
                    break;
                case 'R':
                    letter=1;
                    Metalic++;
                    switch(name.charAt(i+1)){
                        case 'b':
                            sumElement=(float) 85.5;
                            break;
                        case 'u':
                            sumElement=(float) 101.1;
                            break;
                        case 'h':
                            sumElement=(float) 102.9;
                            break;
                        case 'e':
                            sumElement=(float) 186.2;
                            break;
                        case 'n':
                            nonMetalic++;
                            Metalic--;
                            sumElement=222;
                            break;
                        case 'a':
                            sumElement=226;
                            break;
                        case 'f':
                            sumElement=261;
                            break;
                        case 'g':
                            sumElement=272;
                            break;
                    }
                    break;
                case 'S':
                    letter=0;
                    nonMetalic++;
                    sumElement=(float) 32.1;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'i':
                                letter=1;
                                sumElement=(float) 28.1;
                                break;
                            case 'c':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=45;
                                break;
                            case 'e':
                                letter=1;
                                sumElement=79;
                                break;
                            case 'r':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 87.6;
                                break;
                            case 'n':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 118.7;
                                break;
                            case 'b':
                                letter=1;
                                sumElement=(float) 121.8;
                                break;
                            case 'g':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=266;
                                break;
                            case 'm':
                                letter=1;
                                nonMetalic--;
                                Metalic++;
                                sumElement=(float) 150.4;
                                break;
                        }
                    }
                    break;
                case 'T':
                    letter=1;
                    Metalic++;
                    switch(name.charAt(i+1)){
                        case 'i':
                            sumElement=(float) 47.9;
                            break;
                        case 'c':
                            sumElement=99;
                            break;
                        case 'e':
                            nonMetalic++;
                            Metalic--;
                            sumElement=(float) 127.6;
                            break;
                        case 'a':
                            sumElement=181;
                            break;
                        case 'l':
                            sumElement=(float) 204.4;
                            break;
                        case 'b':
                            sumElement=(float) 158.9;
                            break;
                        case 'm':
                            sumElement=(float) 168.9;
                            break;
                        case 'h':
                            sumElement=232;
                            break;
                    }
                    break;
                case 'U':
                    letter=0;
                    Metalic++;
                    sumElement=238;
                    break;
                case 'V':
                    letter=0;
                    Metalic++;
                    sumElement=(float) 50.9;
                    break;
                case 'W':
                    letter=0;
                    Metalic++;
                    sumElement=(float) 183.8;
                    break;
                case 'X':
                    letter=1;
                    nonMetalic++;
                    switch(name.charAt(i+1)){
                        case 'e':
                            sumElement=(float) 131.3;
                            break;
                    }
                    break;
                case 'Y':
                    letter=0;
                    Metalic++;
                    sumElement=(float) 88.1;
                    if(i+1<name.length()){
                        switch(name.charAt(i+1)){
                            case 'b':
                                letter=1;
                                sumElement=173;
                                break;
                        }
                    }
                    break;
                case 'Z':
                    letter=1;
                    Metalic++;
                    switch(name.charAt(i+1)){
                        case 'n':
                            sumElement=(float) 65.4;
                            break;
                        case 'r':
                            sumElement=(float) 91.2;
                            break;
                    }
            }
            if(tav=='(')
                inbr=true;
            if(inbr){
                if(tav>='A'&&tav<='Z'){
                    if(i+letter<name.length()){
                        if(name.charAt(i+letter+1)>='0'&&name.charAt(i+letter+1)<='9'){
                            for(int j=i+letter+1;j<name.length();j++){
                                tav1=name.charAt(j);
                                if(tav1>='0'&&tav1<='9')
                                    nums++;
                                else
                                    j=name.length();
                            }
                            multi=(int)(Math.pow(10, nums-1));
                            for(int j=i+letter+1;j<i+letter+1+nums;j++){
                                M=M+findNum(j)*multi;
                                multi=multi/10;
                            }
                            nums=0;
                            sumBr=sumBr+sumElement*M;
                            M=0;
                        }
                        else{
                            sumBr=sumBr+sumElement;
                        }
                    }
                }
                if(tav==')'){
                    if(name.charAt(i+1)>='0'&&name.charAt(i+1)<='9'){
                        for(int j=i+1;j<name.length();j++){
                            tav1=name.charAt(j);
                            if(tav1>='0'&&tav1<='9')
                                nums++;
                            else
                                j=name.length();
                        }
                        multi=(int)(Math.pow(10, nums-1));
                        for(int j=i+1;j<i+1+nums;j++){
                            M=M+findNum(j)*multi;
                            multi=multi/10;
                        }
                        nums=0;
                        sum=sum+sumBr*M;
                        M=0;
                    }
                    inbr=false;
                }
            }
            else{
                if(tav>='A'&&tav<='Z'){
                    if(i+letter+1<name.length()){
                        if(name.charAt(i+letter+1)>='0'&&name.charAt(i+letter+1)<='9'){
                            for(int j=i+letter+1;j<name.length();j++){
                                tav1=name.charAt(j);
                                if(tav1>='0'&&tav1<='9')
                                    nums++;
                                else
                                    j=name.length();
                            }
                            multi=(int)(Math.pow(10, nums-1));
                            for(int j=i+letter+1;j<i+letter+1+nums;j++){
                                M=M+findNum(j)*multi;
                                multi=multi/10;
                            }
                            nums=0;
                            sum=sum+sumElement*M;
                            M=0;
                        }
                        else{
                            sum=sum+sumElement;
                        }
                    }
                    else{
                        sum=sum+sumElement;
                    }
                }
            }
        }
        this.molar=sum;
    }

    public int findNumName(int index) {
        switch (this.name.charAt(index)) {
            case 49:
                return 1;
            case 50:
                return 2;
            case 51:
                return 3;
            case 52:
                return 4;
            case 53:
                return 5;
            case 54:
                return 6;
            case 55:
                return 7;
            case 56:
                return 8;
            case 57:
                return 9;
            default:
                return 0;
        }
    }

    public int findNum(int index){
        switch(name.charAt(index)){
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

    public void findMolM() {
        this.mol = this.mass / this.molar;
    }

    public void findMass() {
        this.mass = this.mol * this.molar;
    }

    public void findMolVG() {
        this.mol = this.volumeg / this.molarvol;
    }

    public void findVolumeg() {
        this.volumeg = this.mol * this.molarvol;
    }

    public void findMolarvol() {
        this.molarvol = this.volumeg / this.mol;
    }

    public void findConcentration() {
        this.concentration = this.mol / this.volumel;
    }

    public void findMolc() {
        this.mol = this.concentration * this.volumel;
    }

    public void findVolc() {
        this.volumel = this.mol / this.concentration;
    }

    public float toFloat(String num) {
        return Float.parseFloat(num);
    }

    public int[] numH(int indexH) {
        int nums = 0;
        int numH = 0;
        int i = indexH + 1;
        while (i < this.name.length()) {
            char tav = this.name.charAt(i);
            if (tav < '0' || tav > '9') {
                i = this.name.length();
            } else {
                nums++;
            }
            i++;
        }
        int multi = (int) Math.pow(10.0d, (double) (nums - 1));
        for (i = indexH + 1; i < (indexH + 1) + nums; i++) {
            numH += findNumName(i) * multi;
            multi /= 10;
        }
        return new int[]{numH, nums};
    }

    public String[] BaseAcid(boolean ba) {
        String ion;
        String acharge = "";
        int indexH = 0;
        int count = 0;
        boolean plus = false;
        boolean minus = false;
        int charge = 0;
        for (int i = 0; i < this.name.length(); i++) {
            char tav = this.name.charAt(i);
            if (tav == '+') {
                plus = true;
            }
            if (tav == '-') {
                minus = true;
            }
            if (tav == 'H') {
                indexH = i;
                count++;
            }
        }
        boolean num = (plus || minus) ? indexH + 1 < element().length() && element().charAt(indexH + 1) >= '1' && element().charAt(indexH + 1) <= '9' : indexH + 1 < this.name.length() && this.name.charAt(indexH + 1) >= '1' && this.name.charAt(indexH + 1) <= '9';
        if (ba) {
            if (num) {
                if (plus || minus) {
                    charge = ion();
                    this.name = element();
                }
                int numH = numH(indexH)[0];
                int nums = numH(indexH)[1];
                ion = this.name.substring(0, indexH + 1);
                numH--;
                if (numH != 1) {
                    ion = ion + numH;
                }
                ion = ion + this.name.substring((indexH + 1) + nums, this.name.length());
            } else {
                if (plus || minus) {
                    charge = ion();
                    this.name = element();
                }
                ion = this.name.substring(0, indexH) + this.name.substring(indexH + 1, this.name.length());
            }
            if (minus) {
                acharge = (charge + 1) + "-";
            } else if (plus) {
                charge--;
                if (charge > 0) {
                    acharge = charge == 1 ? "+" : charge + "+";
                }
            } else {
                acharge = "-";
            }
        } else {
            if (count == 0) {
                if (plus || minus) {
                    charge = ion();
                    this.name = element();
                }
                ion = "H" + this.name;
            } else if (num) {
                if (plus || minus) {
                    charge = ion();
                    this.name = element();
                }
                ion = (this.name.substring(0, indexH + 1) + (numH(indexH)[0] + 1)) + this.name.substring((indexH + 1) + numH(indexH)[1], this.name.length());
            } else {
                if (plus || minus) {
                    charge = ion();
                    this.name = element();
                }
                ion = this.name.substring(0, indexH + 1) + "2" + this.name.substring(indexH + 1, this.name.length());
            }
            if (minus) {
                charge--;
                if (charge > 0) {
                    acharge = charge == 1 ? "-" : charge + "-";
                }
            } else {
                acharge = plus ? (charge + 1) + "+" : "+";
            }
        }
        return new String[]{ion, acharge};
    }

    public static int exceptionalH(String matter) {
        if (matter.length() == 5 && matter.equals("H2SO4")) {
            return 1;
        }
        if (matter.equals("CO22-") || matter.equals("CO2{-2}") || matter.equals("CO2-2") || matter.equals("CO2{2-}")) {
            return 2;
        }
        if (matter.equals("SO22-") || matter.equals("SO2{-2}") || matter.equals("SO2-2") || matter.equals("SO2{2-}")) {
            return 3;
        }
        return 0;
    }

    public int ion() {
        int num = 0;
        int count = 0;
        int count2 = 0;
        int Si = 0;
        int O = 0;
        int P = 0;
        boolean end = false;
        String temp = "";
        int i;
        int index;
        if (this.name.charAt(this.name.length() - 1) == '}') {
            String charge = this.name.substring(this.name.indexOf(123) + 1, this.name.indexOf(125));
            if (charge.charAt(charge.length() - 1) == '-' || charge.charAt(charge.length() - 1) == '+') {
                end = true;
            }
            if (end) {
                for (i = 0; i < charge.length() - 1; i++) {
                    temp = temp + charge.charAt(i);
                }
                if (temp.equals("")) {
                    return 1;
                }
                return Integer.parseInt(temp);
            }
            if (charge.indexOf(43) == -1) {
                index = charge.indexOf(45);
            } else {
                index = charge.indexOf(43);
            }
            for (i = index + 1; i < charge.length(); i++) {
                temp = temp + charge.charAt(i);
            }
            return Integer.parseInt(temp);
        }
        if (this.name.charAt(this.name.length() - 1) == '-' || this.name.charAt(this.name.length() - 1) == '+') {
            end = true;
        }
        if (end) {
            char tav;
            i = 0;
            while (i < this.name.length()) {
                tav = this.name.charAt(i);
                if (i + 1 < this.name.length()) {
                    if (((tav == 'S' ? 1 : 0) & (this.name.charAt(i + 1) == 'i' ? 1 : 0)) != 0) {
                        Si++;
                    }
                }
                if (i + 1 < this.name.length()) {
                    if (tav == 'P' && (this.name.charAt(i + 1) < 'a' || this.name.charAt(i + 1) > 'z')) {
                        P++;
                    }
                } else if (tav == 'P') {
                    P++;
                }
                if (i + 1 < this.name.length()) {
                    if (tav == 'O' && this.name.charAt(i + 1) != 's') {
                        O++;
                    }
                } else if (tav == 'O') {
                    O++;
                }
                i++;
            }
            for (i = 0; i < this.name.length(); i++) {
                tav = this.name.charAt(i);
                if (tav >= 'A' && tav <= 'Z') {
                    count++;
                }
                if (tav >= '0' && tav <= '9') {
                    count2++;
                }
            }
            if (this.name.length() - 2 > -1) {
                tav = this.name.charAt(this.name.length() - 2);
                if ((tav >= 'A' && tav <= 'Z') || (tav >= 'a' && tav <= 'z')) {
                    num = 1;
                }
                if (count > 1 && count2 == 1 && tav >= '0' && tav <= '9') {
                    num = 1;
                }
                if (tav >= '4' && tav <= '9' && count > 1) {
                    num = 1;
                }
                if (count == 1 && tav >= '2' && tav <= '9') {
                    num = findNumName(this.name.length() - 2);
                }
            }
            if (this.name.length() - 1 > -1 && count > 1 && this.name.charAt(this.name.length() - 1) == '+') {
                num = 1;
            }
            if (this.name.length() - 3 > -1) {
                if (count == 3 && count2 == 2 && this.name.charAt(this.name.length() - 1) == '-' && this.name.charAt(this.name.length() - 2) >= '0' && this.name.charAt(this.name.length() - 2) <= '9' && this.name.charAt(this.name.length() - 3) >= '0' && this.name.charAt(this.name.length() - 3) <= '9') {
                    num = findNumName(this.name.length() - 2);
                }
                if (((O == 1 && P == 0 && Si == 0) || ((O == 0 && P == 0 && Si == 0) || ((O == 0 && P == 1 && Si == 0) || (O == 0 && P == 0 && Si == 1)))) && this.name.charAt(this.name.length() - 1) == '-' && this.name.charAt(this.name.length() - 2) >= '0' && this.name.charAt(this.name.length() - 2) <= '9' && this.name.charAt(this.name.length() - 3) >= '0' && this.name.charAt(this.name.length() - 3) <= '9') {
                    num = findNumName(this.name.length() - 2);
                }
            }
            if (this.name.length() - 2 > -1) {
                if (((count == 2 && count2 == 2) || ((count == 2 && count2 == 3) || (count == 3 && count2 == 4))) && this.name.charAt(this.name.length() - 1) == '-' && this.name.charAt(this.name.length() - 2) >= '0' && this.name.charAt(this.name.length() - 2) <= '9') {
                    num = findNumName(this.name.length() - 2);
                }
                if ((O == 1 && Si == 1 && count == 2) || ((O == 1 && Si == 1 && count == 3 && P == 1) || ((O == 1 && count == 2 && P == 1) || (Si == 1 && count == 2 && P == 1)))) {
                    num = findNumName(this.name.length() - 2);
                    if (this.name.length() - 3 > -1 && this.name.charAt(this.name.length() - 3) == '1') {
                        num += 10;
                    }
                }
            }
            if (this.name.equals("CH3CO2-")) {
                num = 1;
            }
            if (this.name.equals("C2H3O2-")) {
                num = 1;
            }
            if (this.name.equals("P2O74-")) {
                num = 4;
            }
            if (num == 0) {
                return 1;
            }
            return num;
        }
        if (this.name.indexOf(45) == -1) {
            index = this.name.indexOf(43);
        } else {
            index = this.name.indexOf(45);
        }
        for (i = index + 1; i < this.name.length(); i++) {
            temp = temp + this.name.charAt(i);
        }
        return Integer.parseInt(temp);
    }

    public String element() {
        String E1 = "";
        int count = 0;
        int count2 = 0;
        int Si = 0;
        int O = 0;
        int P = 0;
        boolean end = false;
        if (this.name.charAt(this.name.length() - 1) == '}') {
            return this.name.substring(0, this.name.indexOf(123));
        }
        if (this.name.charAt(this.name.length() - 1) == '-' || this.name.charAt(this.name.length() - 1) == '+') {
            end = true;
        }
        if (end) {
            char tav;
            int i = 0;
            while (i < this.name.length()) {
                tav = this.name.charAt(i);
                if (i + 1 < this.name.length()) {
                    if (((tav == 'S' ? 1 : 0) & (this.name.charAt(i + 1) == 'i' ? 1 : 0)) != 0) {
                        Si++;
                    }
                }
                if (i + 1 < this.name.length()) {
                    if (tav == 'P' && (this.name.charAt(i + 1) < 'a' || this.name.charAt(i + 1) > 'z')) {
                        P++;
                    }
                } else if (tav == 'P') {
                    P++;
                }
                if (i + 1 < this.name.length()) {
                    if (tav == 'O' && this.name.charAt(i + 1) != 's') {
                        O++;
                    }
                } else if (tav == 'O') {
                    O++;
                }
                i++;
            }
            for (i = 0; i < this.name.length(); i++) {
                tav = this.name.charAt(i);
                if (tav >= 'A' && tav <= 'Z') {
                    count++;
                }
                if (tav >= '0' && tav <= '9') {
                    count2++;
                }
            }
            if (this.name.length() - 2 > -1) {
                tav = this.name.charAt(this.name.length() - 2);
                if ((tav >= 'A' && tav <= 'Z') || (tav >= 'a' && tav <= 'z')) {
                    E1 = this.name.substring(0, this.name.length() - 1);
                }
                if (count > 1 && count2 == 1 && tav >= '0' && tav <= '9') {
                    E1 = this.name.substring(0, this.name.length() - 1);
                }
                if (tav >= '4' && tav <= '9' && count > 1) {
                    E1 = this.name.substring(0, this.name.length() - 1);
                }
                if (count == 1 && tav >= '2' && tav <= '9') {
                    E1 = this.name.substring(0, this.name.length() - 2);
                }
            }
            if (this.name.length() - 1 > -1 && count > 1 && this.name.charAt(this.name.length() - 1) == '+') {
                E1 = this.name.substring(0, this.name.length() - 1);
            }
            if (this.name.length() - 3 > -1) {
                if (count == 3 && count2 == 2 && this.name.charAt(this.name.length() - 1) == '-' && this.name.charAt(this.name.length() - 2) >= '0' && this.name.charAt(this.name.length() - 2) <= '9' && this.name.charAt(this.name.length() - 3) >= '0' && this.name.charAt(this.name.length() - 3) <= '9') {
                    E1 = this.name.substring(0, this.name.length() - 2);
                }
                if (((O == 1 && P == 0 && Si == 0) || ((O == 0 && P == 0 && Si == 0) || ((O == 0 && P == 1 && Si == 0) || (O == 0 && P == 0 && Si == 1)))) && this.name.charAt(this.name.length() - 1) == '-' && this.name.charAt(this.name.length() - 2) >= '0' && this.name.charAt(this.name.length() - 2) <= '9' && this.name.charAt(this.name.length() - 3) >= '0' && this.name.charAt(this.name.length() - 3) <= '9') {
                    E1 = this.name.substring(0, this.name.length() - 2);
                }
            }
            if (this.name.length() - 2 > -1) {
                if (((count == 2 && count2 == 2) || ((count == 2 && count2 == 3) || (count == 3 && count2 == 4))) && this.name.charAt(this.name.length() - 1) == '-' && this.name.charAt(this.name.length() - 2) >= '0' && this.name.charAt(this.name.length() - 2) <= '9') {
                    E1 = this.name.substring(0, this.name.length() - 2);
                }
                if ((O == 1 && Si == 1 && count == 2) || ((O == 1 && Si == 1 && count == 3 && P == 1) || ((O == 1 && count == 2 && P == 1) || (Si == 1 && count == 2 && P == 1)))) {
                    E1 = this.name.substring(0, this.name.length() - 2);
                    if (this.name.length() - 3 > -1 && this.name.charAt(this.name.length() - 3) == '1') {
                        E1 = this.name.substring(0, this.name.length() - 3);
                    }
                }
            }
            if (this.name.equals("CH3CO2-")) {
                E1 = this.name.substring(0, this.name.length() - 1);
            }
            if (this.name.equals("C2H3O2-")) {
                E1 = this.name.substring(0, this.name.length() - 1);
            }
            if (this.name.equals("P2O74-")) {
                E1 = this.name.substring(0, this.name.length() - 2);
            }
            if (E1.equals("")) {
                return this.name.substring(0, this.name.length() - 1);
            }
            return E1;
        }
        int index;
        if (this.name.indexOf(45) == -1) {
            index = this.name.indexOf(43);
        } else {
            index = this.name.indexOf(45);
        }
        return this.name.substring(0, index);
    }

    public void reset() {
        this.name = "";
        this.molar = 0.0f;
        this.mass = 0.0f;
        this.mol = 0.0f;
        this.volumeg = 0.0f;
        this.molarvol = 0.0f;
        this.category = "";
        this.concentration = 0.0f;
        this.volumel = 0.0f;
    }

    public void removeBA() {
        String temp = "";
        boolean br = false;
        char tav;
        int index = 0;
        int i = 0;
        while (i < this.name.length()) {
            tav = this.name.charAt(i);
            if ((tav < '0' || tav > '9') && tav != '.') {
                index = i;
                i = this.name.length();
            }
            i++;
        }
        this.name = this.name.substring(index);
        i = 0;
        while (i < this.name.length()) {
            tav = this.name.charAt(i);
            if (tav == '(' && i + 2 < this.name.length() && ((this.name.charAt(i + 1) == 's' || this.name.charAt(i + 1) == 'l' || this.name.charAt(i + 1) == 'g') && this.name.charAt(i + 2) == ')')) {
                br = true;
            }
            if (tav == '(' && i + 3 < this.name.length() && this.name.charAt(i + 1) == 'a' && this.name.charAt(i + 2) == 'q' && this.name.charAt(i + 3) == ')') {
                br = true;
            }
            if (!br) {
                temp = temp + tav;
            }
            if (tav == ')') {
                br = false;
            }
            i++;
        }
        this.name = temp;
    }

    public double findCoefficient() {
        String temp = "";
        int endC = -1;
        int j = 0;
        while (j < this.name.length() && ((this.name.charAt(j) >= '0' && this.name.charAt(j) <= '9') || this.name.charAt(j) == '.')) {
            endC = j;
            j++;
        }
        for (int i = 0; i <= endC; i++) {
            temp = temp + this.name.charAt(i);
        }
        if (endC == -1) {
            return 1.0d;
        }
        return (double) toFloat(temp);
    }

    public int CNumber() {
        int sum = 0;
        int nums = 0;
        int i = 0;
        while (i < this.name.length()) {
            if (this.name.charAt(i) == 'C' && i + 1 < this.name.length()) {
                int j = i + 1;
                while (j < this.name.length()) {
                    char tav1 = this.name.charAt(j);
                    if (tav1 < '0' || tav1 > '9') {
                        j = this.name.length();
                    } else {
                        nums++;
                    }
                    j++;
                }
                int multi = (int) Math.pow(10.0d, (double) (nums - 1));
                j = i + 1;
                while (this.name.charAt(j) >= '0' && this.name.charAt(j) <= '9' && j < this.name.length()) {
                    sum += findNumName(j) * multi;
                    multi /= 10;
                    j++;
                }
            }
            i++;
        }
        return sum;
    }

    public int Bonds() {
        int sum = 0;
        int nums = 0;
        int i = 0;
        while (i < this.name.length()) {
            if (this.name.charAt(i) == ':' && i + 1 < this.name.length()) {
                int j = i + 1;
                while (j < this.name.length()) {
                    char tav1 = this.name.charAt(j);
                    if (tav1 < '0' || tav1 > '9') {
                        j = this.name.length();
                    } else {
                        nums++;
                    }
                    j++;
                }
                int multi = (int) Math.pow(10.0d, (double) (nums - 1));
                for (j = i + 1; j < this.name.length(); j++) {
                    sum += findNumName(j) * multi;
                    multi /= 10;
                }
            }
            i++;
        }
        return sum;
    }

    public String[] Resault(int FC, int FB, int SC, int SB, String FCT, String SCT, String language) {
        String[] resault = new String[]{"", ""};
        if (FC > SC) {
            resault[0] = ">";
            if (language.equals("Eng")) {
                resault[1] = "";
            } else {
                resault[1] = "הטמפרטורת היתוך גבוה שמספר הפחמנים גדול יותר וכתוצאה מכך ענן האלקטרונים גדול יותר דבר המחזק את קשרי הואן דר ואלס ולכן צריך יותר אנרגיה לפרקם וכתוצאה מכך טמפרטורת ההיתוך גדלה"; }
        } else if (SC > FC) {
            resault[0] = "<";
            if (language.equals("Eng")) {
                resault[1] = "";
            } else {
                resault[1] = "הטמפרטורת היתוך גבוה שמספר הפחמנים גדול יותר וכתוצאה מכך ענן האלקטרונים גדול יותר דבר המחזק את קשרי הואן דר ואלס ולכן צריך יותר אנרגיה לפרקם וכתוצאה מכך טמפרטורת ההיתוך גדלה"; }
        } else if (SC == FC) {
            if (FB > SB) {
                resault[0] = "<";
                if (language.equals("Eng")) {
                    resault[1] = "";
                } else {
                    resault[1] = "הטמפרטורת היתוך נמוכה יותר כאשר יש יותר קשרים כפולים כי הם פוגעים בגמישות המולקולה וביכולת האריזה של המולקולות וכתוצאה מכך קשרי הואן דר ואלס נחלשים וקל יותר לפרקם דבר המוריד מטמפרטורת ההיתוך"; }
            } else if (SB > FB) {
                resault[0] = ">";
                if (language.equals("Eng")) {
                    resault[1] = "";
                } else {
                    resault[1] = "הטמפרטורת היתוך נמוכה יותר כאשר יש יותר קשרים כפולים כי הם פוגעים בגמישות המולקולה וביכולת האריזה של המולקולות וכתוצאה מכך קשרי הואן דר ואלס נחלשים וקל יותר לפרקם דבר המוריד מטמפרטורת ההיתוך"; }
            } else if (SB == FB) {
                if (FCT.equals("trans") && SCT.equals("cis")) {
                    resault[0] = ">";
                    if (language.equals("Eng")) {
                        resault[1] = "";
                    } else {
                        resault[1] = "לחומצות שומן מסוג טרנס טמפרטורת היתוך גבוה יותר משום שבחומצות שומן מסוג ציס קיים כיפוף של המולקולה הגורם לפגיעה ביכולת האריזה של המולקולות, דבר הגורם להחלשת קשרי הואן דר ואלס ולירידה בטמפרטורת ההיתוך"; }
                } else if (FCT.equals("cis") && SCT.equals("trans")) {
                    resault[0] = "<";
                    if (language.equals("Eng")) {
                        resault[1] = "";
                    } else {
                        resault[1] = "לחומצות שומן מסוג טרנס טמפרטורת היתוך גבוה יותר משום שבחומצות שומן מסוג ציס קיים כיפוף של המולקולה הגורם לפגיעה ביכולת האריזה של המולקולות, דבר הגורם להחלשת קשרי הואן דר ואלס ולירידה בטמפרטורת ההיתוך"; }
                } else {
                    resault[0] = "=";
                    if (language.equals("Eng")) {
                        resault[1] = "";
                    } else {
                        resault[1] = "החומרים הם אינם איזומרים או חומרים שונים הם אותו החומר"; }
                }
            }
        }
        return resault;
    }
}
