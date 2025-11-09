import java.io.File;
import java.util.ArrayList;
import java.util.function.Predicate;

import commands.*;
import models.Transactions;
import models.User;
import services.TerminalCommandService;
import utils.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Application financeApp = new Application();
        financeApp.start();
    }
}
