<!DOCTYPE html>

<html>

<head>
<title>Bank Index</title>
<style>
table, th, td {
	border: 1px solid black;
}

</style>
</head>

<body>

<h2>Bank index</h2>
	<table style="width: 100%">
		<tr>
			<th>Function</th>
			<th>REST API call</th>
			<th>HTTP method</th>
			<th>Json content</th>
		</tr>
		<tr>
			<td>List accounts</td>
			<td>/list</td>
			<td>GET</td>
			<td>null</td>
		</tr>
		<tr>
			<td>New account</td>
			<td>/newaccount</td>
			<td>POST</td>
			<td>{ "name": stringName, "accountNumber": intValue }</td>
		</tr>
		<tr>
			<td>Transfer value between accounts</td>
			<td>/transfer</td>
			<td>PUT</td>
			<td>{ "bailorAccountNumber": intValue,
				"depositaryAccountNumber": intValue, "value": doubleValue }</td>
		</tr>
		<tr>
			<td>Deposit value</td>
			<td>/deposit</td>
			<td>PUT</td>
			<td>{ "depositaryAccountNumber": intValue, "value": doubleValue
				}</td>
		</tr>
		<tr>
			<td>Withdraw value</td>
			<td>/withdraw</td>
			<td>PUT</td>
			<td>{ "bailorAccountNumber": intValue, "value": doubleValue }</td>
		</tr>
		<tr>
			<td>Delete account</td>
			<td>/delete/{accountId}</td>
			<td>DELETE</td>
			<td>null</td>
		</tr>
	</table>
</body>

</html>
