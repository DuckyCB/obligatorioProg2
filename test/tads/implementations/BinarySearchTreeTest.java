package tads.implementations;

import exceptions.DuplicatedKeyException;
import exceptions.EmptyTreeException;
import exceptions.KeyNotFoundException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void find(){
        BinarySearchTree<Integer,String> prueba= new BinarySearchTree();

        try {

            prueba.insert(10,"+");
            prueba.insert(14,"B");
            prueba.insert(8,"*");
            prueba.insert(1,"A");
            prueba.insert(3,"C");

            assertEquals(prueba.find(8), "*");

        } catch (DuplicatedKeyException | EmptyTreeException | KeyNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        BinarySearchTree<Integer, String> prueba = new BinarySearchTree();

        try {

            prueba.insert(10, "+");
            prueba.insert(14, "B");
            prueba.insert(8, "*");
            prueba.insert(1, "A");
            prueba.insert(3, "C");

            assertEquals(prueba.size(), 5);


        } catch (DuplicatedKeyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete(){
        BinarySearchTree<Integer, Integer> prueba = new BinarySearchTree();
        try {

            prueba.insert(13, 1);
            prueba.insert(3, 2);
            prueba.insert(20, 3);
            prueba.insert(1, 4);
            prueba.insert(4, 5);
            prueba.delete(20);

            assertNotEquals((int)prueba.find(20),20);

        } catch (DuplicatedKeyException e) {
            e.printStackTrace();
        } catch (EmptyTreeException e) {
            e.printStackTrace();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void size(){
        BinarySearchTree<Integer, String> prueba = new BinarySearchTree();
        try {

            prueba.insert(10, "+");
            prueba.insert(14, "B");
            prueba.insert(8, "*");
            prueba.insert(1, "A");
            prueba.insert(3, "C");

            assertEquals(prueba.size(), 5);
        } catch (DuplicatedKeyException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void countLeaf(){
        BinarySearchTree<Integer, String> prueba = new BinarySearchTree();
        try {

            prueba.insert(10, "+");
            prueba.insert(14, "B");
            prueba.insert(8, "*");
            prueba.insert(1, "A");
            prueba.insert(9, "C");

            assertEquals(prueba.countLeaf(), 3);
        } catch (DuplicatedKeyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countCompleteElements(){
        BinarySearchTree<Integer, String> prueba = new BinarySearchTree();
        try {

            prueba.insert(5, "a");
            prueba.insert(2, "b");
            prueba.insert(6, "c");
            prueba.insert(1, "d");
            prueba.insert(7, "e");

            assertEquals(prueba.countCompleteElements(), 1);
        } catch (DuplicatedKeyException e) {
            e.printStackTrace();
        }
    }

    //@Test void preOrder(){}

    //@Test void inOrder(){ }

    //@Test void postOrder() { }

}
