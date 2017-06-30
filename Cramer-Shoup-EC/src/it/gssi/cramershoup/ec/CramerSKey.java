/*******************************************************************************
 * Cramer-Shoup
 * 
 * Created by Rokia on 16/6/17.
 * Copyright © 2017 Rokia. All rights reserved.
 ******************************************************************************/
package it.gssi.cramershoup.ec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

import ecc.*;
import ecc.elliptic.ECPoint;
import ecc.elliptic.EllipticCurve;
import ecc.elliptic.NoCommonMotherException;

public class CramerSKey  implements Key{
	
	protected BigInteger x1,x2,y1,y2,z;
	protected EllipticCurve mother;
	protected ECPoint c,d,h;
	protected ECPoint alpha,beta;
	protected boolean secret;
	
	public CramerSKey(EllipticCurve ec) throws NoCommonMotherException
	{
		secret = true;
		mother = ec;
		x1= new BigInteger(ec.getp().bitLength() + 17,Rand.om);
		x2= new BigInteger(ec.getp().bitLength() + 17,Rand.om);
		y1= new BigInteger(ec.getp().bitLength() + 17,Rand.om);
		y2= new BigInteger(ec.getp().bitLength() + 17,Rand.om);
		z= new BigInteger(ec.getp().bitLength() + 17,Rand.om);
		if (mother.getOrder() != null) 
		{
			x1=x1.mod(mother.getOrder());
			x2=x2.mod(mother.getOrder());
			y1=y1.mod(mother.getOrder());
			y2=y2.mod(mother.getOrder());
			z=z.mod(mother.getOrder());
		}
		ECPoint c1,d1,d2,c2;
		alpha = mother.getGenerator();
		beta = mother.getGenerator2();
		c1= (alpha.multiply(x1));
		c2= (beta.multiply(x2));
		c = c1.add(c2);
		d1= (alpha.multiply(y1));
		d2= (beta.multiply(y2));
		d = d1.add(d2);
		h= (alpha.multiply(z));
	}

	@Override
	public Key readKey(InputStream in) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeKey(OutputStream out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CramerSKey getPublic() throws NoCommonMotherException {
		CramerSKey temp = new CramerSKey(mother);
		((CramerSKey)temp).beta = beta;
		((CramerSKey)temp).alpha = alpha;
		((CramerSKey)temp).c = c;
		((CramerSKey)temp).d = d;
		((CramerSKey)temp).h = h;
		((CramerSKey)temp).x1 = BigInteger.ZERO;
		((CramerSKey)temp).x2 = BigInteger.ZERO;
		((CramerSKey)temp).y1 = BigInteger.ZERO;
		((CramerSKey)temp).y2 = BigInteger.ZERO;
		((CramerSKey)temp).z = BigInteger.ZERO;
		((CramerSKey)temp).secret = false;
		System.gc();
		return temp;
	}

	@Override
	public boolean isPublic() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
