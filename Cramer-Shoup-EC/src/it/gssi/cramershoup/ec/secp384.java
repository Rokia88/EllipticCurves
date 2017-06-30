/*******************************************************************************
 * Cramer-Shoup
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.cramershoup.ec;

import java.math.BigInteger;

import ecc.elliptic.ECParameters;

public class secp384 implements ECParameters {
    private static final BigInteger p 
	= new BigInteger("30946263300823101954888425259784296108860594177929936231961025381527827855583154673559277957637088071546809309873019", 10);
    
    private static final BigInteger a 
	= new BigInteger("-3");
    
    private static final BigInteger b 
	= new BigInteger("2677643936212245379258831955273195965014103242523976013961762903324499451740187144031703534071217029867094433378961", 10);
    
    /*private static final BigInteger S 
	= new BigInteger("C49D3608"+"86E70493"+"6A6678E1"+"139D26B7"+
			 "819F7E90", 16);*/
    
    private static final BigInteger gx
	= new BigInteger("14178639404406746682605711229110660451562193721390372927909907348910045692494901710547554646487233856635007663515613", 10);

    private static final BigInteger gy
	= new BigInteger("23711026615694012948612033169343672655503600228181811129641066159710183639921671600000400570606296003367190487536661", 10);
    
    private static final BigInteger n
	= new BigInteger("30946263300823101954888425259784296108860594177929936231959195086011429040851460901626189237585847628753659044398489", 10);
    
    private static final BigInteger msgx
   	= new BigInteger("968728525755085411281970662709583949302009222845", 10);

       private static final BigInteger msgy
       	= new BigInteger("12996389902699847389518658211336070286216911599499062835437201132780947019620739478555293762347013334313251032881728", 10); 
    
       private static final BigInteger gx2
    	= new BigInteger("1593628865891009001403773946230053696930153766479896968902301943505153080317352565771492118486772090003928859853474", 10);

        private static final BigInteger gy2
        	= new BigInteger("6341747796620176183738583335085518762834477359697894614521721903905461600128403024056613852723856854609910827177127", 10);
       
    public BigInteger a() {
	return a;
    }

    public BigInteger b() {
	return b;
    }

    public BigInteger p() {
	return p;
    }

    public BigInteger generatorX() {
	return gx;
    }

    public BigInteger generatorY() {
	return gy;
    }

    public BigInteger order() {
	return n;
    }
    
    public BigInteger msgY() {
    	return msgy;
        }
        
        public BigInteger msgX() {
        	return msgx;
            }

    public String toString(){
	return "secp384";
    }

    public static void main(String[] args) {
	System.out.println("a:  "+a);
	System.out.println("b:  "+b);
	System.out.println("p:  "+p);
	System.out.println("gx: "+gx);
	System.out.println("gy: "+gy);
	System.out.println("n:  "+n);
	System.out.println("p.toByteArray().length: "+p.toByteArray().length);
    }

	@Override
	public BigInteger generator2X() {
		// TODO Auto-generated method stub
		return gx2;
	}

	@Override
	public BigInteger generator2Y() {
		// TODO Auto-generated method stub
		return gy2;
	}
}
