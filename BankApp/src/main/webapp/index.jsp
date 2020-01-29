<!DOCTYPE html>

<html>

<head>
<title>Bank Index</title>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Bank</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- New Account -->
			<input type="button" value="New Account"
				onclick="window.location.href='newAccount'; return false;"
				class="new-button" />

			<!-- Transfer between accounts -->
			<input type="button" value="Transfer"
				onclick="window.location.href='Transfer'; return false;"
				class="transfer-button" />

			<!-- Deposit -->
			<input type="button" value="Deposit"
				onclick="window.location.href='Deposit'; return false;"
				class="deposit-button" />

			<!-- Withdrawal -->
			<input type="button" value="Withdraw"
				onclick="window.location.href='Withdraw'; return false;"
				class="withdraw-button" />

			<!-- Delete Account -->
			<input type="button" value="Delete"
				onclick="window.location.href='Delete'; return false;"
				class="delete-button" />
				
			<!-- List Accounts -->
			<input type="button" value="List Accounts"
				onclick="window.location.href='list'; return false;"
				class="list-button" />

		</div>

	</div>


</body>

</html>
