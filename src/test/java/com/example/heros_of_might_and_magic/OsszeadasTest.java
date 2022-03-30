package com.example.heros_of_might_and_magic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith()
class OsszeadasTest {


    private Osszeadas osszeadas;

    @BeforeEach
    public void setUp(){
        osszeadas = new Osszeadas();
    }

    @Test
    public void helyesenOsszead(){
        int eredmeny = osszeadas.osszead(2, 3);
        assertEquals(6, eredmeny);
    }


}