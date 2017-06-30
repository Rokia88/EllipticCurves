//
//  main.c
//  EC-points
//
//  Created by BrokenHeart on 6/8/17.
//  Copyright © 2017 BrokenHeart. All rights reserved.
//

#include <stdio.h>
#include <gmp.h>
#include <time.h>

gmp_randstate_t generator;
#define bit160 160
#define P160 "1147860701762054730346201299935827782113538756127"
#define B160 "993193335754933797118314178888153828594854512705"


#define bit224 224
#define P224 "21174292597673270169193562049053717791882423761323585056162680913631"
#define B224 "18321183280385145938884990414875229336370193019939570227257813318147"


#define bit256 256
#define P256 "90942894222941581070058735694432465663348344332098107489693037779484723616779"
#define B256 "78688883013276200091698248537162581920209762369847930022367595957783191893217"


#define bit384 384
#define P384 "30946263300823101954888425259784296108860594177929936231961025381527827855583154673559277957637088071546809309873019"
#define B384 "2677643936212245379258831955273195965014103242523976013961762903324499451740187144031703534071217029867094433378961"

#define bit512 512
#define B512 "9111550163858012281440901732746538838772262590143654133938674743542107885492015390851248618042056679983385207705625699101049041930943171450852516780927629"
#define P512 "10530467723362659054861705371139847026313999328372313651398671272025951445569024729948471343061931586610942824229083371331823229156399790385588443550959087"


void generate_number(mpz_t alea, unsigned int nbr_bit)
{
    mpz_t k;
    mpz_init(k);
    mpz_ui_pow_ui(k,2,nbr_bit-1);
    mpz_urandomb(alea, generator, nbr_bit-1);
    mpz_add(alea,alea,k);
    mpz_clear(k);
}

void generate_number_b(mpz_t alea,mpz_t p)
{
    mpz_urandomm(alea, generator,p);
}

void ecEquation(mpz_t y,mpz_t x, int A,mpz_t B,mpz_t p)
{

    mpz_t val1, val2;
    mpz_inits(val1,val2,NULL);

    mpz_powm_ui(val1,x,3,p);
    mpz_mul_ui(val2,x,A);
    mpz_mod(val2,val2,p);
    
    mpz_sub(y, val1, val2);
    mpz_add(y,y,B);
    mpz_mod(y,y,p);
    
    mpz_clears(val1,val2,NULL);
    
}

void verif(mpz_t y,mpz_t x, int A,mpz_t B,mpz_t p)
{
    
    mpz_t val1, val2;
    mpz_inits(val1,val2,NULL);
    
    mpz_powm_ui(val1,x,3,p);
    gmp_printf("xcube :%Zu \n",val1);
    mpz_mul_ui(val2,x,A);
    mpz_mod(val2,val2,p);
    gmp_printf("-Ax :%Zu \n",val2);
    
    mpz_sub(val1, val1, val2);
    mpz_add(val1,val1,B);
    mpz_mod(val1,val1,p);
    gmp_printf("all :%Zu \n",val1);
    
    mpz_powm_ui(y,y,2,p);
    
    gmp_printf("y2 :%Zu \n",y);
    
    if(mpz_cmp(y,val1)==0)
    {
        printf("OK\n");
    }
    
    mpz_clears(val1,val2,NULL);
    
}

int main(int argc, const char * argv[])
{
    
    gmp_randinit_default(generator);
    time_t t = time(NULL);
    gmp_randseed_ui(generator,t);
    mpz_t x,B,p,y, val,val1;
    mpz_inits(x,B,p,y,val,val1,NULL);
 
    mpz_set_str(B,B512,0);
    mpz_set_str(p,P512,0);
    
    mpz_mod_ui(val,p,4);
    gmp_printf("val :%Zu \n",val);
    
    mpz_sub_ui(val, p,1);
    mpz_div_ui(val, val,2);
    
    int A = 3 ;
   
    do{
        //generate_number(x,160);
        generate_number_b(x,p);
        
        ecEquation(y,x, A,B,p);
        
        mpz_powm(val1,y,val,p);
    
    }while(mpz_cmp_ui(val1,1)!=0);
    
    gmp_printf("val1 :%Zu \n",val1);
    
    mpz_add_ui(val, p,1);
    mpz_div_ui(val, val,4);
    
    mpz_powm(y,y,val,p);
    
    gmp_printf("x :%Zu \n",x);
    gmp_printf("y :%Zu \n",y);
    
    verif(y,x,A,B,p);
    
    
    mpz_clears(x,B,p,y,val,val1,NULL);

    return 0;
}
