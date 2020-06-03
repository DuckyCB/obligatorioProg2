package tads.implementations;

import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class OpenHashTest {
    @Test
    public void putTest(){
        OpenHash prueba= new OpenHash(5);
        try {
            prueba.put(4, "a");
            prueba.put(5, "b");
            prueba.put(2, "c");
            prueba.put(5,"aa");
            prueba.put(3, "d");
            assertEquals(prueba.size,4);
        }catch(InvalidInformationException e){
            fail();
        }

    }

    @Test
    public void getTest(){
        OpenHash prueba= new OpenHash(5);
        try {
            prueba.put(4, "a");
            prueba.put(5, "b");
            prueba.put(2, "c");
            prueba.put(5,"aa");
            prueba.put(3, "d");
            assertEquals(prueba.get(5),"aa");
        }catch(InvalidInformationException e){
            fail();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sizeTest(){
        OpenHash prueba= new OpenHash(5);
        try {
            prueba.put(4, "a");
            prueba.put(5, "b");

            assertEquals(prueba.size,2);
        }catch(InvalidInformationException e){
            fail();
        }
    }
}
