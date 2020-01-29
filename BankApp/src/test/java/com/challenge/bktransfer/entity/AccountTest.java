/**
 * 
 */
package com.challenge.bktransfer.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Juliano Nakamura
 *
 */
@ExtendWith(MockitoExtension.class)
class AccountTest {

	Account account = new Account(123, "Pessoa", 456);

	@Test
	void increaseAccountBalance() {
		// given

		// when
		account.increaseBalance(456);

		// then
		assertEquals(912, account.getBalance());
	}

	@Test
	void decreaseAccountBalance() {
		// given

		// when
		account.decreaseBalance(456);

		// then
		assertEquals(0, account.getBalance());
	}
}