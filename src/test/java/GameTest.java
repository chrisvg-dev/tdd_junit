import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

/**
 * SE AGREGA RUNWITH PARA TRABAJAR CON MOCKITO
 */

@RunWith(MockitoJUnitRunner.class)
public class GameTest {
    public static final int OPTION_ROCK = 0;
    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;
    /**
     * SE AGREGA INTECJMOCKS PARA inyectar datos CON MOCKITO
     */
    @InjectMocks
    private Game game;
    /**
     * SE AGREGA MOCK PARA INDICAR DE DONDE SE VA A RECIBIR LA INFORMACION
     * NO SE PUEDEN MOCKEAR LAS CLASES FINAL
     */
    @Mock
    Scanner scanner;

    @Mock
    Random random;


    private ByteArrayOutputStream out;

    @Before
    public void setup() {
        /**
         * SE CAPTURA LO QUE SALE POR CONSOLA
         */

        this.out = new ByteArrayOutputStream();
        System.setOut( new PrintStream(out));
    }

    @Test
    public void when_writeQuit_then(){
        when( scanner.nextLine() ).thenReturn("Quit");
        game.play();
        Assert.assertTrue(out.toString().contains("Let's play Rock"));
    }

    @Test
    public void when_chooseRock_then_beatsScissorss(){
        when( scanner.nextLine() ).thenReturn("Rock").thenReturn("Quit");
        when( random.nextInt(3)).thenReturn(OPTION_SCISSORS);

        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose scissors"));
        Assert.assertTrue(out.toString().contains("wins:1"));
    }

    @Test
    public void when_chooseScissors_then_beatsPaper(){
        when( scanner.nextLine() ).thenReturn("Scissors").thenReturn("Quit");
        when( random.nextInt(3)).thenReturn(OPTION_PAPER);

        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose paper"));
        Assert.assertTrue(out.toString().contains("wins:1"));
    }

    @Test
    public void when_choosePaper_then_beatsRock(){
        when( scanner.nextLine() ).thenReturn("Paper").thenReturn("Quit");
        when( random.nextInt(3)).thenReturn(OPTION_ROCK);

        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose rock"));
        Assert.assertTrue(out.toString().contains("wins:1"));
    }

    @Test
    public void when_bothChooseRock_then_tie(){
        when( scanner.nextLine() ).thenReturn("Rock").thenReturn("Quit");
        when( random.nextInt(3)).thenReturn(OPTION_ROCK);

        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose rock"));
        Assert.assertTrue(out.toString().contains("ties:1"));
    }

    @Test
    public void when_chooseRockAndComputerChoosePaper_then_loose(){
        when( scanner.nextLine() ).thenReturn("Rock").thenReturn("Quit");
        when( random.nextInt(3)).thenReturn(OPTION_PAPER);

        game.play();
        Assert.assertTrue(out.toString().contains("Computer chose paper"));
        Assert.assertTrue(out.toString().contains("loses:1"));
    }

}
