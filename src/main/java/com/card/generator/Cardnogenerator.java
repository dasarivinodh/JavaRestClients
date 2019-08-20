package com.card.generator;

public class Cardnogenerator {
	
	public static void main(String[] args) {

		String inputCard="98000138890";
	    char[] charArray = inputCard.toCharArray();
	    int v_sum;
	    int v_checkdigit;
	    int v_i;
	    v_sum = 0;
	    v_i = 0;

	    while (v_i <= inputCard.length() - 1) {
	      v_sum = v_sum + Integer.parseInt("" + charArray[v_i]);
	      v_i = v_i + 2;
	    }

	    v_sum = v_sum * 3;

	    v_i = 1;
	    while (v_i <= inputCard.length() - 1) {
	      v_sum = v_sum + Integer.parseInt("" + charArray[v_i]);
	      v_i = v_i + 2;
	    }

	    v_checkdigit = v_sum % 10;
	    v_checkdigit = 10 - v_checkdigit;

	    if (v_checkdigit == 10) {
	      v_checkdigit = 0;
	    }

	    inputCard = inputCard.concat(v_checkdigit + "");
	    System.out.println(inputCard);
	  
	}

}
