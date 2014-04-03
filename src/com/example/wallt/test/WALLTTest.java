package com.example.wallt.test;

import java.util.ArrayList;

import com.example.wallt.BankAccount;
import com.example.wallt.ServerUtility;
import com.example.wallt.Transactions;

import android.test.AndroidTestCase;

public class WALLTTest extends AndroidTestCase {

	private ServerUtility instance;

    protected void setUp() throws Exception {
		super.setUp();
		instance = ServerUtility.getInstance();
		if (!instance.logInUser("yong", "yong")) {
			instance.signUpUser("yong", "yong");
		}
	}
    
    public void testGetWithdrawAmount() {
    	BankAccount account4 = new BankAccount(null, "99999", 100, "bank1aa53", null);
    	instance.createNewBankAccount(account4);
    	ArrayList<BankAccount> accounts = instance.getBankAccounts();
    	BankAccount account = accounts.get(0);
    	instance.depositAmount(account, 2000, "PayCheck");
    	instance.withdrawAmount(account, 100, "lunch money");

    	ArrayList<Transactions> list =instance.getTransactions(account);
    	assertEquals(2, list.size());
    }
}
