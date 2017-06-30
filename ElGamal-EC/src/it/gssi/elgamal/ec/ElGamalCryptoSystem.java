/*******************************************************************************
 * ElGamal
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.elgamal.ec;

import java.math.BigInteger;
import java.security.MessageDigest;

import ecc.*;
import ecc.elliptic.ECPoint;
import ecc.elliptic.EllipticCurve;
import ecc.elliptic.NoCommonMotherException;
import ecc.elliptic.NotOnMotherException;

public class ElGamalCryptoSystem implements CryptoSystem{
	
	MessageDigest hash;
	
	private EllipticCurve ec;
	
	 public ElGamalCryptoSystem(EllipticCurve ec) {
			this.ec = ec;
			try {
			    hash = MessageDigest.getInstance("SHA-512");
			} catch (java.security.NoSuchAlgorithmException e) {
			    System.out.println("RSACryptoSystem: THIS CANNOT HAPPEN\n"+e);
			    System.exit(0);
			}
		    }

	@Override
	public byte[] encrypt(byte[] plain, int numbytes, Key key) {
		return null;
	}
	
	public ECPoint[] encrypt(ECPoint x ,Key key) throws NoCommonMotherException {
	ElGamalKey ek = (ElGamalKey) key;

	BigInteger rk = new BigInteger(ek.mother.getp().bitLength() + 17, Rand.om);
	if (ek.mother.getOrder() != null) {
	    rk = rk.mod(ek.mother.getOrder());
	}
	ECPoint gamma = ek.alpha.multiply(rk);
	/*if(ek.mother.onCurve(gamma))
    {
    	System.out.println("gamma lies on the curve");
    }*/
	ECPoint sec = ek.beta.multiply(rk);
	/*if(ek.mother.onCurve(sec))
    {
    	System.out.println("sec lies on the curve");
    }*/
	ECPoint mu = x.add(sec);
	ECPoint[] res = {gamma,mu};

	return res;
	}

	@Override
	public byte[] decrypt(byte[] cipher, Key dk) {
	
		return null;
	}
	
	public ECPoint decrypt(ECPoint[] cipher, Key key) throws NoCommonMotherException, NotOnMotherException {
		ElGamalKey dk = (ElGamalKey) key;
		ECPoint sec = cipher[0].multiply(dk.sk);
		ECPoint sec1 = new ECPoint(dk.mother, sec.getx(), sec.gety().negate());
		ECPoint x = sec1.add(cipher[1]);
		return x;
	}

	@Override
	public Key generateKey() {
		// TODO Auto-generated method stub
		return new ElGamalKey(ec);
	}

	@Override
	public int blockSize() {
		// TODO Auto-generated method stub
		return 20;
	}

}
