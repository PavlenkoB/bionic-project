package ua.ho.godex;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Creator: Pavlenko Bohdan
 * Date: 23.08.2017
 * Project: istore
 */
public class PlaceHolderTest {
    @Test
    public void sum() throws Exception {
        assertEquals(new Integer(3), PlaceHolder.sum(1, 2));
    }

}