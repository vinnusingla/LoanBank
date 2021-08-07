package com.navi.loan.service.impl;

import com.navi.loan.dao.BalanceCommand;
import com.navi.loan.dao.Command;
import com.navi.loan.dao.LoanCommand;
import com.navi.loan.dao.PaymentCommand;
import com.navi.loan.service.InputHandler;
import com.navi.loan.service.InputHandlerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TxtFileInputHandlerTest {
    @Test
    public void txtFileHandlerTest() throws Exception {
        String testInputFile = "src/test/resources/testInput.txt";
        InputHandlerFactory inputHandlerFactory = new InputHandlerFactory();
        InputHandler inputHandler = inputHandlerFactory.getHandler("txtFileHandler");
        List<Command> commands = inputHandler.parseFile(testInputFile);
        Assert.assertEquals(10, commands.size());
        Assert.assertTrue(commands.get(0) instanceof LoanCommand);
        Assert.assertTrue(commands.get(3) instanceof PaymentCommand);
        Assert.assertTrue(commands.get(9) instanceof BalanceCommand);
    }
}
