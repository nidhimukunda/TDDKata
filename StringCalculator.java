package stringcalc;

public class StringCalculator {

	public static void main(String[] args) {
		String t="1\n2,3";
		Integer res = add(t);
		System.out.println(res);
	}
	public static Integer add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			String delimiter = ",";
			if(text.matches("//(.*)\n(.*)")){
				delimiter = Character.toString(text.charAt(2));
				text = text.substring(4);
			}
			
			String list[] = splitNumbers(text, delimiter + "|\n");
			return sum(list);
		}
	}

	private static Integer toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String divider){
	    return numbers.split(divider);
	}

	private static Integer sum(String[] numbers){
 	    Integer total = 0;
 	    String negativeString = "";

        for(String number : numbers){
        	if(toInt(number) < 0){
        		if(negativeString.equals(""))
        			negativeString = number;
        		else
        			negativeString += ("," + number);
        	}
        	if(toInt(number) < 1000)
		    	total += toInt(number);
		}

		if(!negativeString.equals("")){
			throw new IllegalArgumentException("negatives not allowed: " + negativeString);
		}

		return total;
    }
}