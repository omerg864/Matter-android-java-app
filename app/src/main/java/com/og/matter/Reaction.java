package com.og.matter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reaction {
	private String equation,removed,balanced,finalEquation;
	private String[] matters;
	public Reaction(){
		//constractor
	}
	public String getEquation() {
		return equation;
	}
	public void setEquation(String equation) {
		this.equation = equation;
	}
	public String[] getMatters() {
		return matters;
	}
	public void setMatters(String[] matters) {
		this.matters = matters;
	}
	public String getBalanced() {
		return balanced;
	}
	public void setBalanced(String balanced) {
		this.balanced = balanced;
	}
	public String getFinalEquation() {
		return finalEquation;
	}
	public void setFinalEquation(String finalEquation) {
		this.finalEquation = finalEquation;
	}
	public String getRemoved() {
		return removed;
	}
	public void setRemoved(String removed) {
		this.removed = removed;
	}
	public void Balance(){
		balanced=equationBalance();
	}
    private  String equationBalance() {
        // initialize reactant and product ArrayLists
        ArrayList<String> rterms = new ArrayList<String>();
        ArrayList<String> pterms = new ArrayList<String>();

        // used for redox equations
        ArrayList<Double> coeffsr = new ArrayList<Double>();
        ArrayList<Double> coeffsp = new ArrayList<Double>();

        // enclose all code in a large try/catch to catch all possible errors in
        // equation
        try {

            // split equation into reactants and products, and convert to arrays
            // of compounds
            String reactants = removed.substring(0, removed.indexOf("="));
            String products = removed.substring(removed.indexOf("=") + 1,removed.length());
            reactants = reactants.trim();
            products = products.trim();
            converttoArrayList(reactants, rterms);
            converttoArrayList(products, pterms);
            String rterms1[] = new String[rterms.size()];
            String pterms1[] = new String[pterms.size()];
            for (int i = 0; i < rterms.size(); i++) {
                if (Character.isDigit(rterms.get(i).charAt(0))) {
                    throw new Exception();
                }
                rterms.set(i, rterms.get(i).trim());
                rterms1[i] = rterms.get(i);
            }
            for (int i = 0; i < pterms.size(); i++) {
                if (Character.isDigit(pterms.get(i).charAt(0))) {
                    throw new Exception();
                }
                pterms.set(i, pterms.get(i).trim());
                pterms1[i] = pterms.get(i);
            }

            // deal with redox equations
            boolean isredox = configureRedox(rterms, coeffsr);
            isredox |= configureRedox(pterms, coeffsp);

            // add "1" subscripts and deal with polyatomic ions
            addNums(rterms);
            configureParenthesis(rterms);
            addNums(pterms);
            configureParenthesis(pterms);
            addNums(rterms);
            addNums(pterms);

            // equation is now all configured, do pattern matching to extract
            // elements
            ArrayList<String> elements = new ArrayList<String>();
            patternMatch(rterms, elements);
            patternMatch(pterms, elements);

            // initialize matrix m in order to solve system of equations
            int size = rterms.size() + pterms.size();
            String h[] = new String[1000];
            double m[][] = null;
            int rows = elements.size();
            if (size > rows) {
                m = new double[size][size];
            } else if (rows > size) {
                m = new double[rows][size];
            } else if (rows == size) {
                m = new double[size][rows];
            }
            if (isredox) {
                m = new double[m.length + 1][m[0].length];
                int c = 0;
                for (int i = 0; i < coeffsr.size(); i++) {
                    m[m.length - 1][c] = coeffsr.get(i);
                    c++;
                }
                for (int i = 0; i < coeffsp.size(); i++) {
                    if (i == coeffsp.size() - 1) {
                        m[m.length - 1][c] = coeffsp.get(i);
                    } else {
                        m[m.length - 1][c] = coeffsp.get(i) * -1;
                        c++;
                    }
                }
            }

            // add system of equations to matrix m
            addToReactantsMatrix(rterms, m, h);
            addToProductsMatrix(pterms, m, h, rterms.size());

            // perform RREF to solve system of linear equations
            toRREF(m);

            // re-extract balanced equation from solved matrix m
            ArrayList<Double> coefficients = new ArrayList<Double>();
            for (int i = 0; i < m[0].length; i++) {
                if (m[i][m[0].length - 1] == 0.0) {
                    m[i][m[0].length - 1] = 1.0;
                }
                coefficients.add(m[i][m[0].length - 1]);
            }
            Double elem[] = new Double[coefficients.size()];
            int factor = 0;
            int denoms[] = new int[elem.length];
            for (int i = 0; i < elem.length; i++) {
                elem[i] = m[i][elem.length - 1];
                denoms[i] = toFraction(elem[i]);
            }
            factor = lcm(denoms);
            int fin[] = new int[elem.length];
            for (int i = 0; i < elem.length; i++) {
                elem[i] *= factor;
                fin[i] = (int) Math.round(elem[i].doubleValue());
            }

            // generate final equation
            String newequ1 = generateFinalEquation(rterms1, pterms1, fin);
            String newequ2 = removeSpaces(newequ1);
            if (newequ2.replace('\u2192', '=').equals(removeSpaces(removed))) {
                return null;
            }
            return newequ2;
        } catch (Exception e) {
            return null;
        }
    }
    private String generateFinalEquation(String[] rterms1, String[] pterms1,int[] fin) {
        int cou = 0;
        String newequ = "";
        for (int i = 0; i < rterms1.length; i++) {
            if (fin[cou] == 1) {
                if (i == rterms1.length - 1) {
                    newequ += rterms1[i] + " ? ";
                } else {
                    newequ += rterms1[i] + " + ";
                }
                cou++;
            } else {
                if (i == rterms1.length - 1) {
                    newequ += fin[cou] + rterms1[i] + " ? ";
                } else {
                    newequ += fin[cou] + rterms1[i] + " + ";
                }
                cou++;
            }
        }
        for (int i = 0; i < pterms1.length; i++) {
            if (fin[cou] == 1) {
                if (i == pterms1.length - 1) {
                    newequ += pterms1[i];
                } else {
                    newequ += pterms1[i] + " + ";
                }
                cou++;
            } else {
                if (i == pterms1.length - 1) {
                    newequ += fin[cou] + pterms1[i];
                } else {
                    newequ += fin[cou] + pterms1[i] + " + ";
                }
                cou++;
            }
        }
        return newequ;
    }
    private void patternMatch(ArrayList<String> terms,ArrayList<String> elements) {
        for (int i = 0; i < terms.size(); i++) {
            // match single uppercase letter, or uppercase with 1 or 2 lowercase
            Pattern p1 = Pattern.compile("([A-Z])(\\d+)");
            String comp = terms.get(i);
            Matcher m1 = p1.matcher(comp);
            while (m1.find()) {
                if (!elements.contains(m1.group(1))) {
                    elements.add(m1.group(1));
                }
            }
            Pattern p2 = Pattern.compile("([A-Z])([a-z])(\\d+)");
            Matcher m2 = p2.matcher(comp);
            while (m2.find()) {
                if (!elements.contains(m2.group(1) + "" + m2.group(2))) {
                    elements.add(m2.group(1) + "" + m2.group(2));
                }
            }
            Pattern p3 = Pattern.compile("([A-Z])([a-z])([a-z])(\\d+)");
            Matcher m3 = p3.matcher(comp);
            while (m3.find()) {
                if (!elements.contains(m3.group(1) + "" + m3.group(2) + ""
                        + m3.group(3))) {
                    elements.add(m3.group(1) + "" + m3.group(2) + ""
                            + m3.group(3));
                }
            }
            if (terms.get(i).length() == 1) {
                String e = terms.get(i);
                terms.set(i, e + "1");
            }
        }

    }
    private void addToReactantsMatrix(ArrayList<String> terms, double[][] m,String[] h) {
        int count = 0;
        int track = 0;
        for (int i = 0; i < terms.size(); i++) {
            String comp = terms.get(i);
            ArrayList<String> x = new ArrayList<String>();
            ArrayList<Integer> y = new ArrayList<Integer>();
            patternMatchMatrix(comp, x, y);
            if (i == 0) {
                for (int j = 0; j < y.size(); j++) {
                    m[track][i] = y.get(j);
                    track++;
                    h[count] = x.get(j);
                    count++;
                }
            } else {
                boolean b = false;
                for (int j = 0; j < x.size(); j++) {
                    b = false;
                    for (int k = 0; k < h.length; k++) {
                        if (x.get(j).equals(h[k])) {
                            m[k][i] = y.get(j);
                            b = true;
                        }
                    }
                    if (!b) {
                        m[track][i] = y.get(j);
                        track++;
                        h[count] = x.get(j);
                        count++;
                    }
                }
            }
        }
    }
    private void addToProductsMatrix(ArrayList<String> terms, double[][] m,String[] h, int rtermsSize) {
        int count = 0;
        int track = 0;
        for (int i = 0; i < terms.size(); i++) {
            String comp = terms.get(i);
            ArrayList<String> x = new ArrayList<String>();
            ArrayList<Integer> y = new ArrayList<Integer>();
            patternMatchMatrix(comp, x, y);
            boolean b = false;
            for (int j = 0; j < x.size(); j++) {
                b = false;
                for (int k = 0; k < h.length; k++) {
                    if (x.get(j).equals(h[k])) {
                        if (i + rtermsSize == m[0].length - 1) {
                            m[k][i + rtermsSize] = y.get(j);
                            b = true;
                        } else {
                            m[k][i + rtermsSize] = y.get(j) * -1;
                            b = true;
                        }
                    }
                }
                if (!b) {
                    if (i + rtermsSize == m[0].length - 1) {
                        m[track][i + rtermsSize] = y.get(j);
                        track++;
                        h[count] = x.get(j);
                        count++;
                    } else {
                        m[track][i + rtermsSize] = y.get(j) * -1;
                        track++;
                        h[count] = x.get(j);
                        count++;
                    }
                }
            }
        }
    }
    private void patternMatchMatrix(String comp, ArrayList<String> x,ArrayList<Integer> y) {
        Pattern p1 = Pattern.compile("([A-Z])(\\d+)");
        Matcher m1 = p1.matcher(comp);
        while (m1.find()) {
            if (x.contains(m1.group(1))) {
                int ind = x.indexOf(m1.group(1));
                Integer add = y.get(ind);
                y.set(ind, add + Integer.parseInt(m1.group(2)));
            } else {
                x.add(m1.group(1));
                y.add(Integer.parseInt(m1.group(2)));
            }
        }
        Pattern p2 = Pattern.compile("([A-Z])([a-z])(\\d+)");
        Matcher m2 = p2.matcher(comp);
        while (m2.find()) {
            if (x.contains(m2.group(1) + "" + m2.group(2))) {
                int ind = x.indexOf(m2.group(1) + "" + m2.group(2));
                Integer add = y.get(ind);
                y.set(ind, add + Integer.parseInt(m2.group(3)));
            } else {
                x.add(m2.group(1) + "" + m2.group(2));
                y.add(Integer.parseInt(m2.group(3)));
            }
        }
        Pattern p3 = Pattern.compile("([A-Z])([a-z])([a-z])(\\d+)");
        Matcher m3 = p3.matcher(comp);
        while (m3.find()) {
            if (x.contains(m3.group(1) + "" + m3.group(2) + "" + m3.group(3))) {
                int ind = x.indexOf(m3.group(1) + "" + m3.group(2) + ""
                        + m3.group(3));
                Integer add = y.get(ind);
                y.set(ind, add + Integer.parseInt(m3.group(4)));
            } else {
                x.add(m3.group(1) + "" + m3.group(2) + "" + m3.group(3));
                y.add(Integer.parseInt(m3.group(4)));
            }
        }
    }
    private boolean configureRedox(ArrayList<String> terms,ArrayList<Double> coeffs) {
        boolean isredox = false;
        for (int i = 0; i < terms.size(); i++) {
            String x = terms.get(i);
            for (int j = 0; j < x.length(); j++) {
                if (j == x.length() - 1 && x.charAt(j) != ']') {
                    coeffs.add(0.0);
                }
                if (x.charAt(j) == '[') {
                    isredox = true;
                    int ind = x.indexOf(']');
                    String num = x.substring(j + 1, ind);
                    coeffs.add(Double.parseDouble(num));
                    x = x.substring(0, j);
                    break;
                }
            }
            terms.set(i, x);
        }
        return isredox;
    }
    private String removeSpaces(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", false);
        String t = "";
        while (st.hasMoreElements())
            t += st.nextElement();
        return t;
    }
    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
    private int lcm(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++)
            result = lcm(result, input[i]);
        return result;
    }
    private int toFraction(double decimal) {
        int LIMIT = 12;
        int denominators[] = new int[LIMIT + 1];
        int numerator, denominator = 0, temp;
        int MAX_GOODNESS = 100;
        int i = 0;
        while (i < LIMIT + 1) {
            denominators[i] = (int) decimal;
            decimal = 1.0 / (decimal - denominators[i]);
            i = i + 1;
        }
        int last = 0;
        while (last < LIMIT) {
            numerator = 1;
            denominator = 1;
            temp = 0;
            int current = last;
            while (current >= 0) {
                denominator = numerator;
                numerator = (numerator * denominators[current]) + temp;
                temp = denominator;
                current = current - 1;
            }
            last = last + 1;
            int goodness = denominators[last];
            if (Math.abs(goodness) > MAX_GOODNESS)
                break;
        }
        return denominator;
    }
    private void converttoArrayList(String a, ArrayList<String> b) {
        int pos = 0;
        for (int i = 0; i < a.length(); i++) {
            if (i == a.length() - 1) {
                String x = a.substring(pos, a.length());
                b.add(x);
            }
            if (Character.toString(a.charAt(i)).equals("+")) {
                String x = a.substring(pos, i);
                pos = i + 1;
                b.add(x);
            }
        }
    }
    private void addNums(ArrayList<String> b) {
        for (int i = 0; i < b.size(); i++) {
            String x = b.get(i);
            for (int j = 0; j < x.length() - 1; j++) {
                if (!Character.isDigit(x.charAt(j)) && x.charAt(j + 1) == ')') {
                    x = x.substring(0, j + 1) + "1"
                            + x.substring(j + 1, x.length());
                    break;
                }
                if ((Character.isUpperCase(x.charAt(j))
                        && !Character.isDigit(j + 1) && Character.isUpperCase(x
                        .charAt(j + 1)))) {
                    x = x.substring(0, j + 1) + "1"
                            + x.substring(j + 1, x.length());
                } else if (j == x.length() - 2
                        && Character.isUpperCase(x.charAt(j + 1))) {
                    x = x + "1";
                }
                if (Character.isUpperCase(x.charAt(j))
                        && Character.isLowerCase(x.charAt(j + 1))) {
                    if (j != x.length() - 2) {
                        if (Character.isUpperCase(x.charAt(j + 2))
                                || x.charAt(j + 2) == '(') {
                            x = x.substring(0, j + 2) + "1"
                                    + x.substring(j + 2, x.length());
                        }
                    } else if (j == x.length() - 2) {
                        x = x + "1";
                    }
                }
            }
            b.set(i, x);
        }
    }
    private void configureParenthesis(ArrayList<String> b) {
        int oldlength = 0;
        for (int i = 0; i < b.size(); i++) {
            String x = b.get(i);
            oldlength = x.length();
            for (int j = 0; j < x.length() - 1; j++) {
                if (x.charAt(j) == '(') {
                    int end = x.indexOf(')');
                    Integer factor = Integer.parseInt(Character.toString(x
                            .charAt(end + 1)));
                    for (int k = j + 1; k < end; k++) {
                        if (Character.isDigit(x.charAt(k))) {
                            Integer num = Integer.parseInt(Character.toString(x
                                    .charAt(k)));
                            Integer newnum = num * factor;
                            String num1 = num.toString();
                            int ind = x.indexOf(num1, k);
                            x = x.substring(0, ind) + newnum.toString()
                                    + x.substring(ind + 1, x.length());
                            if (x.length() > oldlength) {
                                k += x.length() - oldlength;
                                end += x.length() - oldlength;
                            }
                            oldlength = x.length();
                        }
                    }
                    if (j == 0) {
                        end = x.indexOf(')');
                        x = x.substring(1, end)
                                + x.substring(end + 2, x.length());
                        b.set(i, x);
                        break;
                    } else {
                        end = x.indexOf(')');
                        x = x.substring(0, j) + x.substring(j + 1, end);
                        b.set(i, x);
                        break;
                    }

                }
            }
        }
    }
    private void toRREF(double[][] M) {
        int rowCount = M.length;
        if (rowCount == 0)
            return;

        int columnCount = M[0].length;

        int lead = 0;
        for (int r = 0; r < rowCount; r++) {
            if (lead >= columnCount)
                break;
            {
                int i = r;
                while (M[i][lead] == 0) {
                    i++;
                    if (i == rowCount) {
                        i = r;
                        lead++;
                        if (lead == columnCount)
                            return;
                    }
                }
                double[] temp = M[r];
                M[r] = M[i];
                M[i] = temp;
            }

            {
                double lv = M[r][lead];
                for (int j = 0; j < columnCount; j++)
                    M[r][j] /= lv;
            }

            for (int i = 0; i < rowCount; i++) {
                if (i != r) {
                    double lv = M[i][lead];
                    for (int j = 0; j < columnCount; j++)
                        M[i][j] -= lv * M[r][j];
                }
            }
            lead++;
        }
    }
    public boolean typeError(){
        char tav;
        int[] capital=new int[91];
        int[] letters=new int[123];
        for(int i=0;i<123;i++)
            letters[i]=0;
        for(int i=0;i<91;i++)
            capital[i]=0;
        if(removed.length()<3)
            return true;
        int count=0;
        for(int i=0;i<removed.length();i++){
            tav=removed.charAt(i);
            if(tav>='A'&&tav<='Z')
                count++;
        }
        if(count==0)
            return true;
        count=0;
        for(int i=0;i<removed.length();i++){
            tav=removed.charAt(i);
            if(tav=='=')
                count++;
        }
        if(count!=1)
            return true;
        for(int i=0;i<removed.length();i++){
            tav=removed.charAt(i);
            if((tav<'a'||tav>'z')&&(tav<'A'||tav>'Z')&&(tav<'0'||tav>'9')&&tav!='-'&&tav!='+'&&tav!='.'&&tav!='('&&tav!=')'&&tav!='{'&&tav!='}'&&tav!='=')
                return true;
        }
        for(int i=0;i<removed.length();i++){
            tav=removed.charAt(i);
            if(tav>='a'&&tav<='z')
                letters[tav]++;
            if(tav>='A'&&tav<='Z')
                capital[tav]++;
            if(tav>='a'&&tav<='z')
                if(i+1<removed.length())
                    if(removed.charAt(i+1)>='a'&&removed.charAt(i+1)<='z')
                        return true;
            if(tav=='Q'||tav=='J')
                return true;
        }
        for(int i=0;i<123;i++)
            if(letters[i]==1)
                return true;
        for(int i=0;i<91;i++)
            if(capital[i]==1)
                return true;
        return false;
    }
    public boolean typeErrorFirst(){
        char tav;
        int[] capital=new int[91];
        int[] letters=new int[123];
        for(int i=0;i<123;i++)
            letters[i]=0;
        for(int i=0;i<91;i++)
            capital[i]=0;
        if(equation.length()<3)
            return true;
        int count=0;
        for(int i=0;i<equation.length();i++){
            tav=equation.charAt(i);
            if(tav>='A'&&tav<='Z')
                count++;
        }
        if(count==0)
            return true;
        count=0;
        for(int i=0;i<equation.length();i++){
            tav=equation.charAt(i);
            if(tav=='=')
                count++;
        }
        if(count!=1)
            return true;
        for(int i=0;i<equation.length();i++){
            tav=equation.charAt(i);
            if((tav<'a'||tav>'z')&&(tav<'A'||tav>'Z')&&(tav<'0'||tav>'9')&&tav!='-'&&tav!='+'&&tav!='.'&&tav!='('&&tav!=')'&&tav!='{'&&tav!='}'&&tav!='=')
                return true;
        }
        for(int i=0;i<equation.length();i++){
            tav=equation.charAt(i);
            if(tav>='a'&&tav<='z')
                letters[tav]++;
            if(tav>='A'&&tav<='Z')
                capital[tav]++;
            if(tav>='a'&&tav<='z')
                if(i+1<equation.length())
                    if(equation.charAt(i+1)>='a'&&equation.charAt(i+1)<='z')
                        return true;
            if(tav=='Q'||tav=='J')
                return true;
        }
        for(int i=0;i<123;i++)
            if(letters[i]==1)
                return true;
        for(int i=0;i<91;i++)
            if(capital[i]==1)
                return true;
        return false;
    }
    public void removeSpace(){
 	   char tav;
 	   String temp="";
 	   for(int i=0;i<equation.length();i++){
 		   tav=equation.charAt(i);
 		   if(tav!=' ')
 			   temp=temp+tav;
 	   }
 	   equation=temp;
    }
    public void removeExtras(){
 	   char tav;
 	   String temp="";
 	   boolean br=false;
 	   for(int i=0;i<equation.length();i++){
 		   tav=equation.charAt(i);
 		   if(tav=='(')
 			   if(i+2<equation.length())
 				   if((equation.charAt(i+1)=='s'||equation.charAt(i+1)=='l'||equation.charAt(i+1)=='g')&&equation.charAt(i+2)==')')
 					   br=true;
 		   if(tav=='(')
 			   if(i+3<equation.length())
 				   if(equation.charAt(i+1)=='a'&&equation.charAt(i+2)=='q'&&equation.charAt(i+3)==')')
 					   br=true;
 		   if(!br)
 			   temp=temp+tav;
 		   if(tav==')')
 			   br=false;
 	   }
 	  equation=temp;
 	   temp="";
 	   String[] matters=toMatters(equation);
 	   for(int i=0;i<matters.length;i++){
 		   if(!matters[i].equals("="))
 			   matters[i]=removeCoefficient(matters[i]);
 	   }
 	   temp=buildEquation(matters);
 	  equation=temp;
    }
    private String removeCoefficient(String matter){
 	   char tav;
 		String temp="";
 		int endC=-1;
 		int j=0;
 		while(j<matter.length()&&((matter.charAt(j)>='0'&&matter.charAt(j)<='9')||(matter.charAt(j)=='.'))){
 			endC=j;
 			j++;
 		}
 		for(int i=endC+1;i<matter.length();i++){
 			tav=matter.charAt(i);
 			temp=temp+tav;
 		}
 		return temp;
    }
    public String[] toMatters(String equation){
 	   char tav;
 	   	int equals=0;
 	   	int count=2;
 	   	int k=0;
 		boolean RP=false;
 		for(int i=0;i<equation.length();i++){
 			tav=equation.charAt(i);
 			if(tav=='=')
 				equals=i;
 			if(tav=='+')
 				if(i+1<equation.length()&&i-1>-1)
 					if(((equation.charAt(i+1)>='0'&&equation.charAt(i+1)<='9')||(equation.charAt(i+1)>='A'&&equation.charAt(i+1)<='Z')||(equation.charAt(i+1)=='('))&&equation.charAt(i-1)!='{')
 						count++;
 		}
 		String[] temp=new String[count+1];
 		for(int i=0;i<temp.length;i++){
 			temp[i]="";
 		}
 		RP=false;
 	   	for(int i=0;i<equation.length();i++){
 			tav=equation.charAt(i);
 			if(tav=='='){
 				k++;
 				temp[k]="=";
 				k++;
 				RP=true;
 			}
 			if(!RP){
 	    		if(tav=='+'){
 	    			if(i+1<equation.length()&&i-1>-1){
 	    				if(((equation.charAt(i+1)>='0'&&equation.charAt(i+1)<='9')||(equation.charAt(i+1)>='A'&&equation.charAt(i+1)<='Z')||(equation.charAt(i+1)=='('))&&equation.charAt(i-1)!='{')
 	    					k++;
 	    				else
 	    			    	temp[k]=temp[k]+tav;
 	    			}
 	    			else
 	    				temp[k]=temp[k]+tav;
 	    		}
 	    		else
 	    			temp[k]=temp[k]+tav;
 			}
 			else{
 				if(i>equals){
 		    		if(tav=='+'){
 		    			if(i+1<equation.length()&&i-1>-1){
 		    				if(((equation.charAt(i+1)>='0'&&equation.charAt(i+1)<='9')||(equation.charAt(i+1)>='A'&&equation.charAt(i+1)<='Z')||(equation.charAt(i+1)=='('))&&equation.charAt(i-1)!='{')
 		    					k++;
 		    				else
 		    			    	temp[k]=temp[k]+tav;
 		    			}
 		    			else
 		    				temp[k]=temp[k]+tav;
 		    		}
 		    		else
 		    			temp[k]=temp[k]+tav;
 				}
 			}
 		}
 	   	return temp;
    }
    public String buildEquation(String[] matters){
 	   String temp="";
 	   for(int i=0;i<matters.length-1;i++){
 		   temp=temp+matters[i];
 		   if(!matters[i+1].equals("=")){
 			   if(!matters[i].equals("="))
 				   temp=temp+"+";
 		   }
 	   }
 	   temp=temp+matters[matters.length-1];
 	   return temp;
    }
    public String buildEquationWithArrow(String[] matters){
  	   String temp="";
  	   for(int i=0;i<matters.length-1;i++){
  		   temp=temp+matters[i];
  		   if(!matters[i+1].equals("\u2191")){
  			   if(!matters[i].equals("\u2191"))
  				   temp=temp+"+";
  		   }
  	   }
  	   temp=temp+matters[matters.length-1];
  	   return temp;
     }
    public void question(){
 	   char tav;
 	   String temp;
 	   int q=0;
 	   for(int i=0;i<balanced.length();i++){
 		   tav=balanced.charAt(i);
 		   if(tav=='?')
 			   q=i;
 	   }
 	   temp=balanced.substring(0,q);
 	   temp=temp+"=";
 	   temp=temp+balanced.substring(q+1,balanced.length());
 	  balanced=temp;
    }
    public void removeCharge(){
 	   char tav;
 	   boolean b=false;
 	   String temp="";
 	   for(int i=0;i<equation.length();i++){
 		   tav=equation.charAt(i);
 		   if(tav=='{')
 			   b=true;
 		   if(!b)
 			   temp=temp+tav;
 		   if(tav=='}')
 			   b=false;
 	   }
 	  removed=temp;
    }
    public void merge(){
 	   String[] R=toMatters(equation);
 	   String[] B=toMatters(balanced);
 	   for(int i=0;i<B.length;i++){
 		   if(!B[i].equals("=")){
 			   R[i]=getCoefficient(B[i])+R[i];
 		   }
 	   }
 	   finalEquation=buildEquation(R);
    }
    private String getCoefficient(String matter){
 	   char tav;
 		String temp="";
 		int endC=-1;
 		int j=0;
 		while(j<matter.length()&&((matter.charAt(j)>='0'&&matter.charAt(j)<='9')||(matter.charAt(j)=='.'))){
 			endC=j;
 			j++;
 		}
 		for(int i=0;i<=endC;i++){
 			tav=matter.charAt(i);
 			temp=temp+tav;
 		}
 		if(endC==-1)
 			return "";
 		return temp;
    }
    public void Arrow(){
    	String[] matters=toMatters(finalEquation);
    	for(int i=0;i<matters.length;i++)
    		if(matters[i].equals("="))
    			matters[i]="\u2192";
    	finalEquation=buildEquationWithArrow(matters);
    }
}