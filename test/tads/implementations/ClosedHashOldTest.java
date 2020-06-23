package tads.implementations;

import exceptions.FullHashException;
import exceptions.InvalidInformationException;
import exceptions.KeyNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClosedHashOldTest {
    @Test
    public void put(){

        ClosedHashOld prueba= new ClosedHashOld(5);

        try {

            prueba.put(1, "a"); // pos 1

            prueba.put(10, "b"); // pos 0

            prueba.put(2, "c"); // pos 1, no funca tonces 3

            prueba.put(550, "0");

            prueba.put(6,"!");

            assertEquals(prueba.getSize(), 5);

        }catch (InvalidInformationException e) {


            e.printStackTrace();
        }
        catch (FullHashException e) {

            e.printStackTrace();

        }


    }

    @Test
    public void get(){

        ClosedHashOld prueba = new ClosedHashOld(5);
        try {

            prueba.put(1, "a"); // pos 1

            prueba.put(10, "b"); // pos 0

            prueba.put(2, "c"); // pos 1, no funca tonces 3

            prueba.put(550, "0");

            prueba.put(6,"!");

            assertEquals(prueba.get(550), "0");

        } catch (InvalidInformationException e) {
            e.printStackTrace();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        } catch (FullHashException e) {
            e.printStackTrace();
        }
    }

        @Test
    public void getSize(){

            ClosedHashOld prueba= new ClosedHashOld(5);

            try {

                prueba.put(1, "a"); // pos 1

                prueba.put(10, "b"); // pos 0

                assertEquals(prueba.getSize(), 2);

            }catch (InvalidInformationException e) {


                e.printStackTrace();
            }
            catch (FullHashException e) {

                e.printStackTrace();

            }


    }
}
