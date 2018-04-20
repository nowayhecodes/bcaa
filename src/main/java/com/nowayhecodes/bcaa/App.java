package com.nowayhecodes.bcaa;

public class App 
{
    public static void main( String[] args )
    {
        
    }

    public long countPrimes(int upTo) 
    {
        long tally = 0;
        for(int i = 1; i < upTo; i++) 
        {
            if (isPrime(i)) 
            {
                tally++;
            }
        }
        return tally;
    }
    
    private boolean isPrime(int number) 
    {
        for (int i = 0; i < number; i++) 
        {
            if (number % i == 0) 
            {
                return false;
            }
        }
        return true;
    }
    
}

