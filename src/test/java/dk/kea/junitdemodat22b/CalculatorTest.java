package dk.kea.junitdemodat22b;


import dk.kea.junitdemodat22b.service.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorTest {

    private Calculator calculator;

    //spring skal injecte i constructoren - gør den ikke uden autowired
    @Autowired
    CalculatorTest(Calculator calculator){
        //arrange
        this.calculator = calculator;
    }

    /*@BeforeAll
    void setUp(){
        //calculator = new Calculator();
        //System.out.println("BeforeAll runs once before any testing is done");
    }*/

    @BeforeEach
    void setUpEach(){
        System.out.println("BeforeEach runs before each test is done");
    }

    @Test
    void adderPositive() {
        //arrange
        //se setUp

        //act
        int t1 = 27;
        int t2 = 15;
        int result = calculator.adder(t1, t2);

        //assert
        assertEquals(42, result, "Mening med livet, universet og alt det der?");
    }

    @Test
    void adderNotEqual(){
        //arrange

        //act
        int t1 = 27;
        int t2 = 5;
        int result = calculator.adder(t1, t2);
        //assert
        assertNotEquals(42, result, "42 er ikke det samme som 32");
    }

    @Test
    void adderExcetionNegative(){
        //act & assert
        assertThrows(IllegalArgumentException.class,
                () -> calculator.adder(-1, -2),
                "Exception should happen on negative numbers.");
    }

    @Test
    void adderDeltaTolerance(){
        //tillad 0.25 afvigelse
        assertEquals(222, 222.1, 0.25, "Afvigelse 0.1");
    }
}