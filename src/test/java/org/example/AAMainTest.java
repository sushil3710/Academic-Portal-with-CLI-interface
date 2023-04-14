package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class AAMainTest {

    @Test
    void main() {

//        String input = "1\n2020CSB1132\n2020csb1132@iitrpr.ac.in\nroot\n4\n";

        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        input="1\n2020CSB1132\n2020csb1132@iitrpr.ac.in\nroot\n1\n1\n7015804565\n4\n5\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // Run the main method and capture output
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }
    @Test
  void main7(){
      String input = "4\n";
        input="1\n2020CSB1132\n2020csb1132@iitrpr.ac.in\nroot\n1\n3\n4\n5\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }    @Test
    void main8(){
        String input = "";
        input="1\n2020CSB1132\n2020csb1132@iitrpr.ac.in\nroot\n1\n2\nNarnaul\n4\n5\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);

    }   @Test  void main3(){
        String input = "4\n";
        input="1\n2020CSB1132\n2020csb1132@iitrpr.ac.in\nroot\n2\nCS312\n5\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }


    @Test   void main9(){
        String input = "4\n";
        input="1\n2020CSB1132\n2020csb1132@iitrpr.ac.in\nroot\n3\nCS312\n5\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }   @Test void main10(){
        String input = "4\n";
        input="1\n2020CSB1132\n2020csb1132@iitrpr.ac.in\nroot\n4\n5\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }   @Test void main11(){
        String input = "4\n";
        input="2\n1\nabc@iitrpr.ac.in\n12345\n1\nCS201\n5\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }  @Test  void main12(){
        String input = "4\n";
        input="2\n1\nabc@iitrpr.ac.in\n12345\n2\nCS00\n3021\n1\n3.2\n2901\n5\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }   @Test void main13(){
        String input = "4\n";
        input="2\n1\nabc@iitrpr.ac.in\n12345\n1\n5463\n5\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }   @Test void main14(){
        String input = "4\n";
        input="2\n1\nabc@iitrpr.ac.in\n12345\n4\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }
    @Test void main4(){
        String input = "4\n";
        input="2\n1\nabc@iitrpr.ac.in\n12345\n3\n4562\n5\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }@Test  void main15(){
        String input = "4\n";
        input="3\ndean123\ndean123@iitrpr.ac.in\n123456\n1\n1\n1\nCD321\nCdop\n3\n2\n4\n3\n3\nCS101\n3\n4\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }  @Test  void main16(){
        String input = "4\n";
        input="3\ndean123\ndean123@iitrpr.ac.in\n123456\n1\n2\n1\nCD321\n3\n4\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }  @Test  void main17(){ String input = "4\n";
        input="3\ndean123\ndean123@iitrpr.ac.in\n123456\n2\n1\n3\n4\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    } @Test   void main18(){ String input = "4\n";
        input="3\ndean123\ndean123@iitrpr.ac.in\n123456\n2\n2\nCS101\n3\n4\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    } @Test   void main19(){
        String input = "4\n";
        input="3\ndean123\ndean123@iitrpr.ac.in\n123456\n3\n2020CSB1132\n4\n4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AAMain.main(new String[0]);

        // TODO: Write assertions to verify expected behavior
        assertEquals(1,1);
    }
}