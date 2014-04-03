package com.example.wallt.test;

import java.util.ArrayList;

import com.example.wallt.BankAccount;
import com.example.wallt.ServerUtility;

import android.test.AndroidTestCase;

public class Harris extends AndroidTestCase {

	private ServerUtility instance;

    protected void setUp() throws Exception {
		super.setUp();
		instance = ServerUtility.getInstance();
		if (!instance.logInUser("USERNAME", "PASSWORD")) {
			instance.signUpUser("USERNAME", "PASSWORD");
		}
	}

    public void testCreateNewBankAccount() {
    	BankAccount account1 = new BankAccount(null, "000001", 100, "bank123", null);
    	BankAccount account2 = new BankAccount(null, "000002", 100, "bank124", null);
    	BankAccount account3 = new BankAccount(null, "000003", 100, "bank125", null);
    	BankAccount account4 = new BankAccount(null, "000004", 100, "bank126", null);
    	instance.createNewBankAccount(account1);
    	instance.createNewBankAccount(account2);
    	instance.createNewBankAccount(account3);
    	instance.createNewBankAccount(account4);
    	ArrayList<BankAccount> list = instance.getBankAccounts();
    	assertEquals(4, list.size());
    }
}