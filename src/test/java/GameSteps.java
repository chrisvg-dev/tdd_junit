import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameSteps {
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

    @Before
    public void setup() {
        /**
         * SE CAPTURA LO QUE SALE POR CONSOLA
         */

        this.out = new ByteArrayOutputStream();
        System.setOut( new PrintStream(out));
    }

    private ByteArrayOutputStream out;
    @Given("the user will choose {string}")
    public void theUserWillChoose(String userOption) {
        MockitoAnnotations.initMocks(this);
        when( scanner.nextLine() ).thenReturn(userOption).thenReturn("Quit");
    }

    @And("the computter will choose {string}")
    public void theComputterWillChoose(String computerOption) {
        int selection = 0;
        if (computerOption.equals("scissors")) {
            selection = OPTION_SCISSORS;
        }
        if (computerOption.equals("rock")) {
            selection = OPTION_ROCK;
        }
        if (computerOption.equals("paper")) {
            selection = OPTION_PAPER;
        }
        when( random.nextInt(3)).thenReturn(selection);
    }

    @When("they play")
    public void thePlay() {
        game.play();
    }

    @Then("the user wins")
    public void theUserWins() {

        Assert.assertTrue(out.toString().contains("wins:1"));
    }

    @Then("verify that the computer chose {string}")
    public void verifyThatTheComputerChose(String computerSelection) {
        Assert.assertTrue(out.toString().contains("Computer chose " + computerSelection));
    }

    @Then("the user lose")
    public void theUserLose() {
        Assert.assertTrue(out.toString().contains("loses:1"));
    }

    @Then("the user tie")
    public void theUserTie() {
        Assert.assertTrue(out.toString().contains("ties:1"));
    }
}
